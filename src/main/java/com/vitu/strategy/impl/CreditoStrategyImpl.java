package com.vitu.strategy.impl;

import com.vitu.domain.Cliente;
import com.vitu.strategy.TransacaoStrategy;
import com.vitu.web.dto.request.TransacaoRequestDto;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@Named("C")
public class CreditoStrategyImpl implements TransacaoStrategy {
    @Override
    public void efetuarTransacao(Cliente cliente, TransacaoRequestDto transacaoRequestDto) {
        log.info("Efetuando transação de crédito: {} - clienteId: {}", transacaoRequestDto, cliente.getId());
        cliente.setSaldo(cliente.getSaldo() + (transacaoRequestDto.getValor().longValue()));
    }
}
