package com.vitu.domain;

import lombok.Getter;


public enum TipoTransacao {
    C("crédito", 'c'),
    D("débito", 'd');

    private String descricao;

    @Getter
    private Character valor;

    TipoTransacao(String descricao, char valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public static TipoTransacao getTipo(Character character) {
        if (C.valor.equals(character)){
            return C;
        }
        return D;
    }

}
