package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.web.GreetingController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class helloWorldTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private GreetingController greetingController;

    @Test
    public void testHelloName() throws Exception {
        this.mockMvc.perform(get("/hello/noor")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, noor!")));
    }

    @Test
    public void testLoading() {
        assertThat(greetingController).isNotNull();
    }

    @Test
    public void testCapitalize() throws Exception {
        this.mockMvc.perform(get("/capitalize/hello world")).andExpect(status().isOk());
    }
}
