package com.example.project;

import com.example.project.common.controller.RestDocsTestController;
import com.example.project.utils.AbstractRestDocsTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestDocsTestController.class)
class RestDocsTestControllerTest extends AbstractRestDocsTest {

    @Test
    void RestDocsTest() throws Exception{
        mockMvc.perform(get("/restDocsTest")).andExpect(status().isOk());
    }

}