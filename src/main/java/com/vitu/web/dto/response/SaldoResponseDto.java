package com.vitu.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
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
public class SaldoResponseDto {

    private Long total;

    @JsonProperty("data_extrato")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
    private ZonedDateTime dataExtrato;

    private Long limite;
}
