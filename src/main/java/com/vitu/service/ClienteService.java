package com.vitu.service;

import com.vitu.domain.Cliente;

public interface ClienteService {

    Cliente obterClientePorId(Long id);

    Cliente salvar(Cliente cliente);

    Cliente atualizar(Cliente cliente);

}
