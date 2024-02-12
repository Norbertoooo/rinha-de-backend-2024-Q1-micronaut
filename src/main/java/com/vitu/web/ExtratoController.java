package com.vitu.web;

import com.vitu.service.ExtratoService;
import com.vitu.web.dto.response.ExtratoResponseDto;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("/clientes")
public class ExtratoController {

    @Inject
    ExtratoService extratoService;

    @Get(uri = "/{id}/extrato", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<ExtratoResponseDto> obterExtrato(@PathVariable Long id) {

        ExtratoResponseDto extratoResponseDto = extratoService.obterExtratoPorClienteId(id);

        return HttpResponse.ok(extratoResponseDto);
    }
}
