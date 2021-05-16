package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
/*
@Component
public class Encoder {
    private IEncoder iEncoder;

    public Encoder(@Qualifier("base74Encoder") IEncoder iEnconder) {
        this.iEncoder = iEnconder;
    }

    public void setIEncoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message) {
        return iEncoder.encode(message);
    }
}

 */

// 컴포넌트가 아닌 빈으로 직접 등록
public class Encoder {
    private IEncoder iEncoder;

    public Encoder(IEncoder iEnconder) {
        this.iEncoder = iEnconder;
    }

    public void setIEncoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message) {
        return iEncoder.encode(message);
    }
}