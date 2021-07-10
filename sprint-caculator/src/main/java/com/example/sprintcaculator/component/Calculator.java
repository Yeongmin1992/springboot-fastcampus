package com.example.sprintcaculator.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// spirg 버전
@Component
@RequiredArgsConstructor
public class Calculator {

    private final ICalculator iCalculator;

    public int sum(int x, int y) {
        // 계산 전에 서버에서 정보를 받아와라
        this.iCalculator.init();
        return this.iCalculator.sum(x, y);
    }

    public int minus(int x, int y) {
        this.iCalculator.init();
        return this.iCalculator.minus(x, y);
    }
}

/* 자바버전
public class Calculator {

    private ICalculator iCalculator;

    public Calculator(ICalculator iCalculator) {
        this.iCalculator = iCalculator;
    }

    public int sum(int x, int y) {
        return this.iCalculator.sum(x, y);
    }

    public int minus(int x, int y) {
        return this.iCalculator.minus(x, y);
    }
}

 */
