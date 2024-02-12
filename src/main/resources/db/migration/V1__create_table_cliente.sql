create table cliente
(
    id           SERIAL  primary key,
    limite       integer not null,
    saldo_inicial integer not null
);