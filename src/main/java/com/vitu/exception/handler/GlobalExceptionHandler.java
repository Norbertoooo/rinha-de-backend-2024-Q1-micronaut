package com.vitu.exception.handler;

import com.vitu.exception.ClienteNaoEncontradoException;
import com.vitu.exception.OperacaoInvalidaException;
import com.vitu.exception.SaldoInconsistenteException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Singleton;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Produces
@Controller
public class GlobalExceptionHandler {

    @Error(global = true, exception = ClienteNaoEncontradoException.class)
    public HttpResponse<Void> clienteNaoEncontradoHandler(HttpRequest request, ClienteNaoEncontradoException exception) {
        log.error("Error: {} - endpoint: {}",exception.getMessage(), request.getPath());
        return HttpResponse.notFound();
    }

    @Error(global = true, exception = SaldoInconsistenteException.class)
    public HttpResponse<Void> saldoInconsistenteExceptionHandler(HttpRequest request, SaldoInconsistenteException exception) {
        log.error("Error: {} - endpoint: {}",exception.getMessage(), request.getPath());
        return HttpResponse.unprocessableEntity();
    }

    @Error(global = true, exception = ConstraintViolationException.class)
    public HttpResponse<Void> constraintViolationExceptionHandler(HttpRequest request, ConstraintViolationException exception) {
        log.error("Error: {} - endpoint: {}", exception, request.getPath());
        return HttpResponse.unprocessableEntity();
    }

    @Error(global = true, exception = OperacaoInvalidaException.class)
    public HttpResponse<Void> operacaoInvalidaExceptionHandler(HttpRequest request, OperacaoInvalidaException exception) {
        log.error("Error: {} - endpoint: {}", exception, request.getPath());
        return HttpResponse.unprocessableEntity();
    }

    @Error(global = true, exception = Exception.class)
    public HttpResponse<Void> exceptionHandler(HttpRequest request, Exception exception) {
        log.error("Error: {} - endpoint: {}", exception, request.getPath());
        return HttpResponse.unprocessableEntity();
    }

}
