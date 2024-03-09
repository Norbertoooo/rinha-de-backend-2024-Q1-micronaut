package com.vitu.service;

import com.vitu.domain.Transacao;
import com.vitu.web.dto.request.TransacaoRequestDto;
import com.vitu.web.dto.response.NovaTransacaoResponseDto;

import java.util.List;

public interface TransacaoService {

    NovaTransacaoResponseDto efetuarTransacao(Long clienteId, TransacaoRequestDto transacaoRequestDto);

    List<Transacao> obterTransacoesPorDataDesc(Long clienteId);
}
