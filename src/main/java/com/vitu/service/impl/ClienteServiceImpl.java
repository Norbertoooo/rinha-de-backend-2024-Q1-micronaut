package com.vitu.service.impl;

import com.vitu.domain.Cliente;
import com.vitu.exception.ClienteNaoEncontradoException;
import com.vitu.repository.ClienteRepository;
import com.vitu.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    @Override
    public Cliente obterClientePorId(Long id) {
        log.info("Procurando cliente pelo id: {}", id);
        return clienteRepository.findByIdForUpdate(id).orElseThrow(ClienteNaoEncontradoException::new);
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        log.info("Salvando cliente: {}", cliente);
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Cliente cliente) {
        log.info("Atualizando cliente: {}", cliente);
        return clienteRepository.update(cliente);
    }


}
