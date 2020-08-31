package com.tlaughlan.commissionator.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTests {

    @Autowired
    private MainController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void controllerLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testShowCalc() throws Exception {
        this.mockMvc.perform(get("/calculator")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"));
    }

    @Test
    public void testProcessCommission() throws Exception {
        this.mockMvc.perform(post("/calculator")
                .param("actual", "210")
                .param("target", "100")
                .param("motc", "5000")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeHasNoErrors("commission"));
    }

    @Test
    public void testProcessCommissionWithErrors() throws Exception {
        this.mockMvc.perform(post("/calculator")
                .param("actual", "-4")
                .param("target", "")
                .param("motc", "10001")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("commission"));
    }
}
