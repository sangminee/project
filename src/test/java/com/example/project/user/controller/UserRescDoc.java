package com.example.project.user.controller;

import com.example.project.user.domain.UserCreate;
import com.example.project.utils.AbstractRestDocsTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class UserRescDoc extends AbstractRestDocsTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @DisplayName("회원 가입")
    @Test
    void user_create() throws Exception{
        // given
        UserCreate userCreate = UserCreate.builder()
                .email("test111@gmail.com")
                .nickname("sangmin")
                .address("Seoul")
                .build();
        // when
        // then
        mockMvc.perform(
                        post("/api/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(userCreate)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.email").value("test111@gmail.com"))
                .andExpect(jsonPath("$.nickname").value("sangmin"))
                .andDo(// rest docs 문서 작성 시작
                        document("user-create", // 문서 조각 디렉토리 명
                                requestFields(
                                        fieldWithPath("email").description("이메일"),
                                        fieldWithPath("nickname").description("닉네임"),
                                        fieldWithPath("address").description("주소")
                                ),
                                responseFields( // response 필드 정보 입력
                                        fieldWithPath("id").description("ID"),
                                        fieldWithPath("email").description("email"),
                                        fieldWithPath("nickname").description("nickname"),
                                        fieldWithPath("status").description("유저 상태"),
                                        fieldWithPath("lastLoginAt").description("마지막 로그인 날짜")
                                )
                        )
                );
    }

}
