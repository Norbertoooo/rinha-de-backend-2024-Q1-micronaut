package com.vitu.web.dto.request;

import com.vitu.domain.TipoTransacao;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Serdeable
@Introspected
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoRequestDto {

    @NotNull
    @Positive
    @Digits(integer = 10, fraction = 0, message = "deve ser um numero inteiro")
    private BigDecimal valor;

    @NotNull
    private TipoTransacao tipo;

    @Size(min = 1, max = 10)
    @NotBlank
    private String descricao;

}
