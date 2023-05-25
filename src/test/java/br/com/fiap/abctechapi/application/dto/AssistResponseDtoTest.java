package br.com.fiap.abctechapi.application.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AssistResponseDtoTest {

    @Test
    public void testAssistResponseDto() {
        AssistResponseDto dto = new AssistResponseDto(1L, "Assist", "Description");

        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getName()).isEqualTo("Assist");
        assertThat(dto.getDescription()).isEqualTo("Description");
    }
}
