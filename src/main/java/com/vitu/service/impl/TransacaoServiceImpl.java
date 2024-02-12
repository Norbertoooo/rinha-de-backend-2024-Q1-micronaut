package com.vitu.service.impl;

import com.vitu.domain.Cliente;
import com.vitu.domain.TipoTransacao;
import com.vitu.domain.Transacao;
import com.vitu.exception.SaldoInconsistenteException;
import com.vitu.repository.TransacaoRepository;
import com.vitu.service.ClienteService;
import com.vitu.service.TransacaoService;
import com.vitu.web.dto.request.TransacaoRequestDto;
import com.vitu.web.dto.response.CriarNovaTransacaoResponseDto;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@Singleton
public class TransacaoServiceImpl implements TransacaoService {

    @Inject
    TransacaoRepository transacaoRepository;

    @Inject
    ClienteService clienteService;

    @Override
    public CriarNovaTransacaoResponseDto efetuarTransacao(Long clienteId, TransacaoRequestDto transacaoRequestDto) {

        Cliente cliente = clienteService.obterClientePorId(clienteId);

        if (TipoTransacao.C.getValor().equals(transacaoRequestDto.getTipo())) {

            cliente.setSaldoInicial(cliente.getSaldoInicial() + (transacaoRequestDto.getValor() * 100));

            this.salvar(transacaoRequestDto,cliente);

            clienteService.atualizar(cliente);

            return CriarNovaTransacaoResponseDto.builder()
                    .saldo(cliente.getSaldoInicial())
                    .limite(cliente.getLimite())
                    .build();
        }

        if (cliente.getLimite() < (transacaoRequestDto.getValor() * 100) + cliente.getSaldoInicial()) {
            throw new SaldoInconsistenteException();
        }

        cliente.setSaldoInicial(cliente.getSaldoInicial() - (transacaoRequestDto.getValor() * 100));

        this.salvar(transacaoRequestDto, cliente);

        clienteService.atualizar(cliente);

        return CriarNovaTransacaoResponseDto.builder()
                .saldo(cliente.getSaldoInicial())
                .limite(cliente.getLimite())
                .build();
    }

    @Override
    public List<Transacao> obterTransacoesPorDataDesc(Long clienteId) {
        Cliente cliente = clienteService.obterClientePorId(clienteId);
        return transacaoRepository
                .findAllByClienteOrderByRealizadaEmDesc(cliente, Pageable.from(0, 10))
                .getContent();
    }

    private Transacao salvar(TransacaoRequestDto transacaoRequestDto, Cliente cliente) {

        Transacao build = Transacao.builder()
                .valor(transacaoRequestDto.getValor())
                .tipo(TipoTransacao.getTipo(transacaoRequestDto.getTipo()))
                .descricao(transacaoRequestDto.getDescricao())
                .realizadaEm(ZonedDateTime.now())
                .cliente(cliente)
                .build();

        return transacaoRepository.save(build);
    }
}
