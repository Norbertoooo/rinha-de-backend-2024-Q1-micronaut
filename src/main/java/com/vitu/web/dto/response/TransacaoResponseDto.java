package com.vitu.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vitu.domain.TipoTransacao;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@Serdeable
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoResponseDto {

    private Long valor;

    private TipoTransacao tipo;

    private String descricao;

    @JsonProperty("realizada_em")
    private ZonedDateTime realizadaEm;

}
