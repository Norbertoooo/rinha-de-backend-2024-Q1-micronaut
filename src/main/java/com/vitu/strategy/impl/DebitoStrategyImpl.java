package com.vitu.strategy.impl;

import com.vitu.domain.Cliente;
import com.vitu.exception.SaldoInconsistenteException;
import com.vitu.strategy.TransacaoStrategy;
import com.vitu.web.dto.request.TransacaoRequestDto;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@Named("D")
public class DebitoStrategyImpl implements TransacaoStrategy {
    @Override
    public void efetuarTransacao(Cliente cliente, TransacaoRequestDto transacaoRequestDto) {
        log.info("Efetuando transação de débito: {} - clienteId: {}", transacaoRequestDto, cliente.getId());

        if (cliente.getSaldo() - transacaoRequestDto.getValor().longValue() < cliente.getLimite() * -1) {
            throw new SaldoInconsistenteException();
        }

        cliente.setSaldo(cliente.getSaldo() - transacaoRequestDto.getValor().longValue());
    }
}
