package com.vitu.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Serdeable
@NoArgsConstructor
@AllArgsConstructor
public class ExtratoResponseDto {

    private SaldoResponseDto saldo;

    @JsonProperty("ultimas_transacoes")
    private List<TransacaoResponseDto> ultimasTransacoes;

}
