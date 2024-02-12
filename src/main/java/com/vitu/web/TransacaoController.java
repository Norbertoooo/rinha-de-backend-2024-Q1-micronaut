package com.vitu.web;

import com.vitu.service.TransacaoService;
import com.vitu.web.dto.request.TransacaoRequestDto;
import com.vitu.web.dto.response.CriarNovaTransacaoResponseDto;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@Controller("/clientes")
public class TransacaoController {

    @Inject
    TransacaoService transacaoService;

    @Post(uri = "/{id}/transacoes", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<CriarNovaTransacaoResponseDto> criarNovaTransacao(@PathVariable Long id,
                                                                          @Body @Valid TransacaoRequestDto transacaoRequestDto) {
        log.info("Recendo requisição para criação de nova transação: {}", transacaoRequestDto);
        CriarNovaTransacaoResponseDto criarNovaTransacaoResponseDto = transacaoService.efetuarTransacao(id, transacaoRequestDto);
        return HttpResponse.ok(criarNovaTransacaoResponseDto);
    }

}
