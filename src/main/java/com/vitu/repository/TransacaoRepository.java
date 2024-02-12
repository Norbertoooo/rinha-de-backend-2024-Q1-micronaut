package com.vitu.repository;

import com.vitu.domain.Cliente;
import com.vitu.domain.Transacao;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, Long> {

    Page<Transacao> findAllByClienteOrderByRealizadaEmDesc(Cliente cliente, Pageable pageable);
}
