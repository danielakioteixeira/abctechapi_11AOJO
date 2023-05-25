package br.com.fiap.abctechapi.application.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Date;

@SpringBootTest
public class OrderLocationDtoTest {

    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    @Test
    public void testOrderLocationDtoValidation_Success() {
        OrderLocationDto orderLocationDto = new OrderLocationDto();
        orderLocationDto.setLatitude(37.7749);
        orderLocationDto.setLongitude(-122.4194);
        orderLocationDto.setDate(new Date());

        assertThat(validator.validate(orderLocationDto)).isEmpty();
    }

    @Test
    public void testOrderLocationDtoValidation_InvalidDate() {
        OrderLocationDto orderLocationDto = new OrderLocationDto();
        orderLocationDto.setLatitude(37.7749);
        orderLocationDto.setLongitude(-122.4194);

        orderLocationDto.setDate(new Date(System.currentTimeMillis() + 100000));

        assertThat(validator.validate(orderLocationDto)).isNotEmpty();
    }
}
