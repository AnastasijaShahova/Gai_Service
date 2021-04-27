package com.ashahova.gai_spring_boot.demo;

import com.ashahova.gai_spring_boot.demo.controller.GaiController;
import com.ashahova.gai_spring_boot.demo.servlet.GaiServlet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootGaiApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GaiController controller;

    @Autowired
    private GaiServlet servlet;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }
    @Test
    public void resRandTest() throws Exception {
        this.mockMvc.perform(get("/gai/rest/random"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void resNextTest() throws Exception {
        this.mockMvc.perform(get("/gai/rest/next"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
