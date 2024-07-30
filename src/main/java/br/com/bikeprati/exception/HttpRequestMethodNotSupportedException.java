package br.com.bikeprati.exception;

public class HttpRequestMethodNotSupportedException extends RuntimeException{
    public HttpRequestMethodNotSupportedException(String message) {
        super(message);
    }
}
