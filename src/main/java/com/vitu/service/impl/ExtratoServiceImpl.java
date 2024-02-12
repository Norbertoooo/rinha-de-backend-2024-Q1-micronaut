package com.vitu.service.impl;

import com.vitu.domain.Cliente;
import com.vitu.domain.Transacao;
import com.vitu.service.ClienteService;
import com.vitu.service.ExtratoService;
import com.vitu.service.TransacaoService;
import com.vitu.web.dto.response.SaldoResponseDto;
import com.vitu.web.dto.response.ExtratoResponseDto;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@Singleton
public class ExtratoServiceImpl implements ExtratoService {

    @Inject
    TransacaoService transacaoService;

    @Inject
    ClienteService clienteService;

    @Override
    public ExtratoResponseDto obterExtratoPorClienteId(Long id) {

        Cliente cliente = clienteService.obterClientePorId(id);

        List<Transacao> transacoes = transacaoService.obterTransacoesPorDataDesc(id);

        SaldoResponseDto saldoResponseDto = this.criarSaldoDto(cliente);

        return ExtratoResponseDto.builder()
                .saldo(saldoResponseDto)
                .ultimasTransacoes(transacoes)
                .build();
    }

    private SaldoResponseDto criarSaldoDto(Cliente cliente) {
        return SaldoResponseDto.builder()
                .dataExtrato(ZonedDateTime.now())
                .total(cliente.getSaldoInicial())
                .limite(cliente.getLimite())
                .build();
    }
}
