package com.example.sprintcaculator.controller;

import com.example.sprintcaculator.component.Calculator;
import com.example.sprintcaculator.component.DollarCalculator;
import com.example.sprintcaculator.component.MarketApi;
import com.example.sprintcaculator.dto.Req;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.yaml.snakeyaml.error.Mark;

@WebMvcTest(CalculatorApiController.class)  // 단위 테스트
@AutoConfigureWebMvc
@Import({Calculator.class, DollarCalculator.class})  // 빈 주입
public class CalculatorApiControllerTest {

    @MockBean
    private MarketApi marketApi;

    // mvo를 mocking으로 테스트 하겠다.
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach  // test init이 실행될 때마다 설정해 주겠다.
    public void init() {
        Mockito.when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void sumTest() throws Exception {
        // http://localhost:8080/api/sum



        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/api/sum")
                        .queryParam("x","10")
                        .queryParam("y","10")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()  // status가 200이어야 한다.
        ).andExpect(
                MockMvcResultMatchers.content().string("60000")  // 값이 6만이어야 한다.
        ).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void minusTest() throws Exception {
        Req req = new Req();
        req.setX(10);
        req.setY(10);

        String json = new ObjectMapper().writeValueAsString(req);

        mockMvc.perform(
                MockMvcRequestBuilders.post("http://localhost:8080/api/minus")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.result").value("0")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.response.resultCode").value("OK")  // depth가 있는 response 확인하기
        )
                .andDo(MockMvcResultHandlers.print());
    }
}
