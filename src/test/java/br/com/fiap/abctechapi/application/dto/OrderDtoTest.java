package br.com.fiap.abctechapi.application.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrderDtoTest {

    private Validator validator;

    public OrderDtoTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Test
    public void testOrderDtoValidation_Success() {
        OrderDto orderDto = new OrderDto(1L, Collections.singletonList(2L), new OrderLocationDto(), new OrderLocationDto());

        var violations = validator.validate(orderDto);

        assertThat(violations).isEmpty();
    }

    @Test
    public void testOrderDtoValidation_Failure() {
        OrderDto orderDto = new OrderDto(null, Collections.singletonList(2L), new OrderLocationDto(), new OrderLocationDto());

        var violations = validator.validate(orderDto);

        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getPropertyPath().toString()).isEqualTo("operatorId");
    }
}
