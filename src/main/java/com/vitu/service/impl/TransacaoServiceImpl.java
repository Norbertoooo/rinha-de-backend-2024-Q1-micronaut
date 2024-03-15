package com.vitu.service.impl;

import com.vitu.domain.Cliente;
import com.vitu.domain.Transacao;
import com.vitu.repository.TransacaoRepository;
import com.vitu.service.ClienteService;
import com.vitu.service.TransacaoService;
import com.vitu.strategy.TransacaoStrategy;
import com.vitu.web.dto.request.TransacaoRequestDto;
import com.vitu.web.dto.response.NovaTransacaoResponseDto;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@Singleton
@Transactional
public class TransacaoServiceImpl implements TransacaoService {

    @Inject
    TransacaoRepository transacaoRepository;

    @Inject
    ClienteService clienteService;

    @Inject
    Map<String, TransacaoStrategy> transacaoStrategyMap;

    @Override
    public NovaTransacaoResponseDto efetuarTransacao(Long clienteId, TransacaoRequestDto transacaoRequestDto) {

        log.info("Processando nova transação: {} - clienteId: {}", transacaoRequestDto, clienteId);

        Cliente cliente = clienteService.obterClientePorId(clienteId);

        transacaoStrategyMap.get(transacaoRequestDto.getTipo().name())
                .efetuarTransacao(cliente, transacaoRequestDto);

        this.salvar(transacaoRequestDto, cliente);

        clienteService.atualizar(cliente);

        return NovaTransacaoResponseDto.builder()
                .saldo(cliente.getSaldo())
                .limite(cliente.getLimite())
                .build();
    }

    @Override
    public List<Transacao> obterTransacoesPorDataDesc(Long clienteId) {
        Cliente cliente = clienteService.obterClientePorId(clienteId);
        return transacaoRepository
                .findAllByClienteOrderByDataDesc(cliente, Pageable.from(0, 10))
                .getContent();
    }

    private Transacao salvar(TransacaoRequestDto transacaoRequestDto, Cliente cliente) {

        log.info("Salvando transacao: {} - clienteId: {}", transacaoRequestDto, cliente);
        Transacao build = Transacao.builder()
                .valor(transacaoRequestDto.getValor().longValue())
                .tipo(transacaoRequestDto.getTipo())
                .descricao(transacaoRequestDto.getDescricao())
                .data(ZonedDateTime.now())
                .cliente(cliente)
                .build();

        return transacaoRepository.save(build);
    }
}
