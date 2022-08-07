package br.com.andrereliquias.api.controller;

import java.lang.reflect.Executable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.andrereliquias.api.ApiErrors;
import br.com.andrereliquias.exception.PedidoNaoEncontradoException;
import br.com.andrereliquias.exception.RegraNegocioException;

@RestControllerAdvice
public class ApplicationControllerAdvice {


  @ExceptionHandler(RegraNegocioException.class) //toda vez que for lancada uma RegraNegocioException ele vai cair aqui
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiErrors handleRegraNegocioException(RegraNegocioException exception) {
    String mensagemErro = exception.getMessage();

    System.out.println("Entrou aqui cara");

    return new ApiErrors(mensagemErro);
  }

  @ExceptionHandler(PedidoNaoEncontradoException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ApiErrors handlePedidoNotFoundException(PedidoNaoEncontradoException exception) {
    return new ApiErrors(exception.getMessage());
  }
}
