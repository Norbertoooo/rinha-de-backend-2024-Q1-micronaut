package com.vitu.service.impl;

import com.vitu.domain.Cliente;
import com.vitu.exception.ClienteNaoEncontradoException;
import com.vitu.repository.ClienteRepository;
import com.vitu.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class ClienteServiceImpl implements ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    @Override
    public Cliente obterClientePorId(Long id) {
        log.info("Procurando cliente pelo id: {}", id);
        return clienteRepository.findById(id).orElseThrow(ClienteNaoEncontradoException::new);
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Cliente cliente) {
        return clienteRepository.update(cliente);
    }


}
