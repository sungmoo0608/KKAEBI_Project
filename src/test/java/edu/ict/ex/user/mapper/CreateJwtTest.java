package edu.ict.ex.user.mapper;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class CreateJwtTest {
	
    @Value("${custom.jwt.secretKey}")
    private String secretKeyPlain;

    @Test
    void 시크릿키_존재_확인() {
        assertThat(secretKeyPlain).isNotNull();
    }
	
}
