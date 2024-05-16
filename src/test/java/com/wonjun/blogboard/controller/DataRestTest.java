package com.wonjun.blogboard.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DataRestTest {

    @Autowired private MockMvc mvc;

    @Test
    void test() throws Exception {
        // Given

        // When
        mvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json;charset=UTF-8")))
                .andDo(print());

        // Then
    }

}
