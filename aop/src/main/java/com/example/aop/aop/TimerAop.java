package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.DeleteMapping;

/* 빈, 컴포넌트, configuration 의 차이
- 빈은 클래스에 붙일 수 없음, 메소드에서 사용
- configuration은 하나의 클래스에 여러가지 빈을 등록
- 컴포넌트를 사용하여 클래스 단위로 등록
 */
@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))") // 컨트롤러 밑의 모든 메소드를 aop로 보겠다.
    private void cut(){}

    @Pointcut("@annotation(com.example.aop.annotation.Timer)") // annotation 패키지 하위의 Timer 머노테이션이 설정된 메소드 만
    private void enableTimer(){}

    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        //메소드 실행 전
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();


        Object resutlt = joinPoint.proceed();  // proceed로 실체적 메소드를 실행하여 Object로 리턴

        // 메소드 실행 후후
        stopWatch.stop();

        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
    }
}
