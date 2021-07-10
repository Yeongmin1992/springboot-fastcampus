package com.example.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

// 직접 스레드 만들기
@Configuration
public class AppConfig {

    // 스레드의 사용법 'ex) 몇개를 사용하면 좋을지' ,maxpoolsize, corepoolsize 와 같은 부분은 인터넷을 찾아 볼 것
    // 아래 코드 간단 설명 : 우선 CorePoolSize가 10개 -> 10개 다 사용하면 Queue의 10개 사용 -> Queue의 10개를 다 사용 하면 CorePoolSize가 10개 만큼 늘어나 20개 됨
    // 20개 다 채만 다시 queue에 10개 참 -> 100까지 반복
    @Bean("async-thread")
    public Executor asyncThread() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(100);
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(10);
        threadPoolTaskExecutor.setThreadNamePrefix("Async-");
        return threadPoolTaskExecutor;
    }
}
