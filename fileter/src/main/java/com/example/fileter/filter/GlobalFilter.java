package com.example.fileter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// java servlet의 필터를 상속
//@Component(전역으로 사용) @WebFilter(적용 범위 지정) 사용 안할 시에는 component 어노테이션 사용하여 빈으로 등록해줘야 함.
@Slf4j
@WebFilter(urlPatterns = "/api/user/*")
public class GlobalFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 전처리
        // request와 response를 ServeletRequest를 상속 받는 HttpServelet으로 형변환
        // HttpServletRequest httpServletRequest = (HttpServletRequest)request;

        // BufferedReader는 커서 단위로 읽고, 한번 읽어 버리면 커서가 제일 끝으로 가 버려서 다시 읽을 수 없다. 이를 해결하기 위한 방법으로 캐싱을 사용하는 아래의 방법을 사용
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest)request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse)response);

        /* ContentCachingRequestWrapper 클래스를 들여다보면 생성자에서 컨텐츠의 길이만 지정을 해 놓았고, 내용은 추후에 사용 함. doFilter 이후에 request에 대한 정보를 읽어줘야 한다.
        BufferedReader br = httpServletRequest.getReader();
        br.lines().forEach(line -> {
            log.info("url : {}, line : {}", url, line);
        });
         */

        chain.doFilter(httpServletRequest, httpServletResponse);

        String url = httpServletRequest.getRequestURI();

        // 후처리
        // req
        String reqContent = new String(httpServletRequest.getContentAsByteArray());  // 기본 인코딩이 utf-8
        log.info("request url : {}, request body : {}", url, reqContent);


        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();

        // 위의 resContent에서 바디를 끝 까지 한번 읽었기 때문에 커서가 제일 마지막으로 가서 더 이상 읽을게 없는 상태여서 response에 'No Body'가 발생. 따라서, 읽었던 내용을 한번 더 복사 해줌
        httpServletResponse.copyBodyToResponse();

        log.info("response status : {}, responseBody : {}", httpStatus, resContent);

    }
}
