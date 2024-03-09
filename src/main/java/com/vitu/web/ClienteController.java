package com.vitu.web;

import com.vitu.domain.Cliente;
import com.vitu.service.ClienteService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("/clientes")
public class ClienteController {

    @Inject
    ClienteService clienteService;

    @Get(uri = "/{id}", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Cliente> obterClientePorId(@PathVariable Long id) {
        Cliente cliente = clienteService.obterClientePorId(id);
        return HttpResponse.ok(cliente);
    }

}
