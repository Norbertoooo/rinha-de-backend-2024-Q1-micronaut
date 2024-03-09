package com.vitu.domain;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@Serdeable
@MappedEntity
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {

    @Id
    @GeneratedValue(value = GeneratedValue.Type.IDENTITY)
    private Long id;

    private Long valor;

    private TipoTransacao tipo;

    private String descricao;

    private ZonedDateTime data;

    @Relation(Relation.Kind.MANY_TO_ONE)
    private Cliente cliente;
}
