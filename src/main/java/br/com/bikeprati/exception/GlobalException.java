package br.com.bikeprati.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorDetail> noSuchElementException(NoSuchElementException e, HttpServletRequest request) {
        ErrorDetail erro = new ErrorDetail(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorDetail> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request) {
        ErrorDetail erro = new ErrorDetail(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetail> argumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        ErrorDetail erro = new ErrorDetail(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getFieldError().getDefaultMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

}
