package com.vitu.exception.handler;

import com.vitu.exception.ClienteNaoEncontradoException;
import com.vitu.exception.SaldoInconsistenteException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Singleton;

@Produces
@Controller
public class GlobalExceptionHandler {

    @Error(global = true, exception = ClienteNaoEncontradoException.class)
    public HttpResponse<?> clienteNaoEncontradoHandler(HttpRequest request, ClienteNaoEncontradoException exception) {
        return HttpResponse.notFound();
    }

    @Error(global = true, exception = SaldoInconsistenteException.class)
    public HttpResponse<?> saldoInconsistenteExceptionHandler(HttpRequest request, SaldoInconsistenteException exception) {
        return HttpResponse.unprocessableEntity();
    }


}
