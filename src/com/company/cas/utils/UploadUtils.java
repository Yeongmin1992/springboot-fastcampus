package com.company.cas.utils;

//업로드 유틸 클래스

import java.io.ObjectInputFilter;

@Component
@RequiredArgsConstructor
public class UploadUtils {
    private final AuthCheck authCheck;

    private final DataConvertUtils dataConvertUtils;

    private final AwsS3Config awsS3Config;

    private final LogUtils logUtils;


    //S3 업로드 정보 반환

    public UploadContent getDefaultUploadInfo(MultipartFile file, UploadSearch uploadSearch) throws Exception {
        // 파일 기본 정보 세팅
        String uploadTrget = uploadSearch.getUploadTrget();
        String orgFileNm = file.getOriginalFilename();
        long fileSize = file.getSize();

        //업로드 정보 세팅
        UploadContent uploadContent = new UploadContent();
        UploadContent.setUploadTrget(uploadTrget);
        uploadContent.setOrgFileNm(orgFileNm);
        uploadContent.setSttusCd(ObjectInputFilter.Status.PROGRESS.getCode());
        uploadContent.setSttusDtlCn(StatusDtl.STATUS_CLEAR.getCn());
        uploadContent.setFileSize(fileSize);
        uploadContent.setUserId(uploadSearch.getUserId());

        return uploadContent;
    }

    // 광고주 계정 권한체크, S3업로드 후 파일 정보 반환

    public UploadContent getUploadDetail(MultipartFile file, UploadContent uploadContent) throws Exception {
        //파일 기본 정보 세팅
        String uploadTrget = uploadContent.getUploadTrget();
        String orgFileNm = file.getOriginalFilename();
        long fileSize = file.getSize();
        String uniqueKey = new UniqueKey().makeUniqueKey();
        String[] fileArr = orgFileNm.split(Regex.DOT.find());

        // 권한 체크 및 스키마, 테이블 반환
        String[] KeyNm = this.authCheck.getKeyName(fileArr, uploadContent.getUserId());
        String schemaNm = keyNm[0];
        String tableNm = keyNm[1];

        // csv 헤더 추출
        List<String> headerList = this.dataConvertUtils.getHeaderList(file);

        // 업로드 경로 설정 및 S3 업로드

    }
}
