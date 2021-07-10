package com.example.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncService {

    // @Async는 aop기반이기 때문에 proxy 패턴 사용을 한다. 따라서 public method에만 @Async를 넣어줄 수 있다.
    // request, response를 사용하기 위한 방법
    @Async("async-thread") // 스레드의 빈이름을 넣어서, 직접 만든 스레드 넣어주기
    public CompletableFuture run() {
        return new AsyncResult(hello()).completable();
    }

    // @Async
    public String hello() {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
                log.info("thread sleep ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "async hello";
    }

}
