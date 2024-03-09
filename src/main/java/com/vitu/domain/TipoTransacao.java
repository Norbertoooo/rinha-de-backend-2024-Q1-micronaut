package com.vitu.domain;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;

@Getter
@Serdeable
public enum TipoTransacao {
    C, D
}
