package com.example.interceptor.interceptor;

import com.example.interceptor.annotation.Auth;
import com.example.interceptor.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    /*
    필터는 제일 앞단이라 HttpServletRequest 형 변환이 불가능하나 interceptor에서는 가능
    -> (ContentCachingRequestWrapper) request
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();

        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build()
                .toUri();

        log.info("request url : {}", url);
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation : {}", hasAnnotation);

        // 나의 서버는 모두 public으로 동작을 하는데
        // 단! Auth 권한을 가진 요청에 대해서는 세션, 쿠키 등을 검사하겠다?
        if(hasAnnotation) {
            // 어노테이션을 갖고 있을 경우 권한체크
            String query = uri.getQuery();

            log.info("query : {}", query);

            // 쿼리의 내용이 아래 설정 내용과 동일하면 통과시키겠다.
            if(query.equals("name=steve")) {
                return true;
            }
            throw new AuthException();
        }

       return true;
    }

    // interceptor는 spring context에서 관리하기 때문에 handler와 같은 객체를 쓸 수 있지만, Filter는 Web Application에서 관리하여 사용 불가
    // interceptor가 false로 끝나면 동작하지 않는다.
    private boolean checkAnnotation(Object handler, Class clazz) {

        // resource javascript, html 같은 애들은 통과
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        // annotation check -> HandlerMethod 찾아보기 추천
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if (null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)) {
            // Auth annotation이 있을 때는 true
            return true;
        }
        return false;
    }

}
