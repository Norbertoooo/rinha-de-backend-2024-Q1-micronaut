package com.vitu.domain;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedEntity
@Builder
@Serdeable
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    private Long id;

    private Long limite;

    private Long saldo;

}
