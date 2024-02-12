package com.vitu.service;

import com.vitu.web.dto.response.ExtratoResponseDto;

public interface ExtratoService {

    ExtratoResponseDto obterExtratoPorClienteId(Long id);
}
