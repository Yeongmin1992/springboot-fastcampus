package com.company.cas.service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UploadServiceImpl {
    private final DataConvertUtils dataConvertUtils;

    private final UploadUtils uploadUtils;

    privat final TrgetMapperUtils trgetMapperUtils;

    private static final ObjectMapper Mapper = new ObjectMapper();

    //업로드 정보 저장 후 파일 유효성 검사
    @Transactional
    public List<UploadContent> fileUpload(UploadSearch uploadSearch) throws Exception {
        List<UploadContent> uploadContentList = new ArrayList<>();
        String uploadTrget = uploadSearch.getUploaTrget();
        // 파일 리스트
        List<MultipartFile> fileList = uploadSearch.getFile();

        for (MultipartFile file : fileList) {
            // 업로드 기본정보 저장
            UploadContent uploadContent = this.uploadUtils.getDefaultUplUoadInfo(file, uploadSearch);
            this.trgetMapperUtils.callTrgetMethodByUploadContent(uploadContent, "insertFileUpload");

            // 업로드 일련번호 자동 증가 값 세팅
            uploadContent.setUploadSn((int) this.trgetMapperUtils.callTrgetMethod(uploadTrget, "getLastInsertId"));

            // s3 업로드 후 파일 상세 정보 반환
            uploadContent = this.uploadUtils.getUploadDetail(file, uploadContent);

            if(!Status.FAILURE.getCode().equals(uploadContent.getSttusCd())) {
                //테이블 정보 조회
                Map tableInfo = (Map) this.trgetMapperUtils.callTrgetMethodByUplozdContent(uploadContent,"selectTableInfo");
                if (tableInfo != null) {
                    String tableComment - tableInfo.get("TABLE_COMMENT").toString();
                    uploadContent.setTbCm(tableCommnet);
                }

                // 테이블 column list 조회
                List<UploadColumn> columnlist = this.selectColumnList(uploadContent);
                if (columnlist.size() == 0) {
                    uploadContent.setSttusDtlCn(StatusDTL.STATUS_TABLE.getCn());
                    uploadContent.setSttusCd(Status.FAILURE.getCode());
                }
            }


        }
    }
}
