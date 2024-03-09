package com.vitu.repository;

import com.vitu.domain.Cliente;
import com.vitu.domain.Transacao;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface TransacaoRepository extends CrudRepository<Transacao, Long> {

    Page<Transacao> findAllByClienteOrderByDataDesc(Cliente cliente, Pageable pageable);
}
