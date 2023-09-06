package com.example.project.utils;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.operation.preprocess.Preprocessors;

@TestConfiguration
public class RestDocsConfig {

    @Bean
    public RestDocumentationResultHandler write() {
        return MockMvcRestDocumentation.document(
                "{class-name}/{method-name}", // "테스트 코드에서 andDo(document()) 부분에서 문서명을 항상 지정해줘야 하는 점"을 해결
                Preprocessors.preprocessRequest(Preprocessors.prettyPrint()), // prettyPrint : json이 한 줄로 출력되던 내용을 pretty 하게 찍어줌
                Preprocessors.preprocessResponse(Preprocessors.prettyPrint())
        );
    }
}