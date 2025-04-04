package com.skillbox.fibonacci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class FibonacciControllerTest extends PostgresTestContainerInitializer {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("send status Ok when index >= 0")
    public void giveOk_whenFibonacciController_thenIndexNotNegative() {
        try {
            mockMvc.perform(get("/fibonacci/1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.index").value(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("send status 400 when index < 0")
    public void give4xx_whenFibonacciController_thenIndexNegative() {
        try {
            mockMvc.perform(get("/fibonacci/-1")).andExpect(status().is4xxClientError());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
