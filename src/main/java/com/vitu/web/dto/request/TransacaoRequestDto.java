package com.vitu.web.dto.request;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Serdeable
public class TransacaoRequestDto {

    @NotNull
    @Positive
    private Long valor;

    @NotNull
    private Character tipo;

    @Size(min = 1, max = 10)
    @NotNull
    private String descricao;

}
