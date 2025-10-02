package com.example.meusgastos.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.meusgastos.common.ConversorData;
import com.example.meusgastos.domain.excption.ResourceBadRequestException;
import com.example.meusgastos.domain.excption.ResourceNotFoundException;
import com.example.meusgastos.domain.model.ErrorResposta;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResposta> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        String dataHora = ConversorData.converterDateParaDataEHora((java.sql.Date) new Date());

        ErrorResposta erro = new ErrorResposta(dataHora, "Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<ErrorResposta> handlerResourceBadRequestException(ResourceBadRequestException ex) {
        String dataHora = ConversorData.converterDateParaDataEHora((java.sql.Date) new Date());

        ErrorResposta erro = new ErrorResposta(dataHora, "Bad Request", HttpStatus.BAD_REQUEST.value(),
                ex.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResposta> handlerRequestException(Exception ex) {
        String dataHora = ConversorData.converterDateParaDataEHora((java.sql.Date) new Date());

        ErrorResposta erro = new ErrorResposta(dataHora, "Internal Server Error",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
