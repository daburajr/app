package br.com.jr.infra;

public class PageException extends RuntimeException {
    public PageException(String msg) {
        super(msg);
    }
}
