package com.vitu.web.dto.response;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Serdeable
public class CriarNovaTransacaoResponseDto {

    private Long limite;
    private Long saldo;

}
