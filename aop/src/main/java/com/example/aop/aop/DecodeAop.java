package com.example.aop.aop;

import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))") // 컨트롤러 밑의 모든 메소드를 aop로 보겠다.
    private void cut(){}

    @Pointcut("@annotation(com.example.aop.annotation.Decode)") // annotation 패키지 하위의 Decode 머노테이션이 설정된 메소드 만
    private void enableDecode(){}

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();

        for(Object arg : args) {
            if(arg instanceof User) {   // 아규먼트 중에 내가 원하는 User 클래스가 있으면
                User user = User.class.cast(arg);
                String base64Email = user.getEmail();  // base64로 인코딩 되어 있는 email 꺼내기
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");  // email 디코딩
                user.setEmail(email); // 디코딩된 email을 user에 set
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        if(returnObj instanceof User) {
            User user = User.class.cast(returnObj);
            String email = user.getEmail();
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes());  // email 인코딩
            user.setEmail(base64Email);
        }

    }
}
