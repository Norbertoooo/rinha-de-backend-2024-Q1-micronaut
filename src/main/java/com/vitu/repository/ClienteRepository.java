package com.vitu.repository;

import com.vitu.domain.Cliente;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;


import java.util.Optional;


@JdbcRepository(dialect = Dialect.POSTGRES)
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    Optional<Cliente> findByIdForUpdate(Long id);

}
