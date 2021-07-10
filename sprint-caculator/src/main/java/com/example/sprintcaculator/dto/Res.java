package com.example.sprintcaculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// depth가 있는 response
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Res {
    private int result;
    private Body response;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Body {
        private String resultCode = "OK";
    }

}
