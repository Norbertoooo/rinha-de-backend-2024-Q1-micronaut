package com.vitu.service;

import com.vitu.domain.Transacao;
import com.vitu.web.dto.request.TransacaoRequestDto;
import com.vitu.web.dto.response.CriarNovaTransacaoResponseDto;

import java.util.List;

public interface TransacaoService {

    CriarNovaTransacaoResponseDto efetuarTransacao(Long clienteId, TransacaoRequestDto transacaoRequestDto);


    List<Transacao> obterTransacoesPorDataDesc(Long clienteId);
}
