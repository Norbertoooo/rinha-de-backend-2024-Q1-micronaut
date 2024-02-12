package com.vitu.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vitu.domain.Transacao;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Serdeable
public class ExtratoResponseDto {

    private SaldoResponseDto saldo;

    @JsonProperty("ultimas_transacoes")
    private List<Transacao> ultimasTransacoes;

}
