package com.vitu.strategy;

import com.vitu.domain.Cliente;
import com.vitu.web.dto.request.TransacaoRequestDto;

public interface TransacaoStrategy {

    void efetuarTransacao(Cliente cliente, TransacaoRequestDto transacaoRequestDto);

}
