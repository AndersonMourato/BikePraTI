package br.com.bikeprati.exception;

import java.time.LocalDateTime;

public class ErrorDetail {
    private LocalDateTime timestemp;
    private Integer status;
    private String menssage;
    private String path;

    public LocalDateTime getTimestemp() {
        return timestemp;
    }

    public void setTimestemp(LocalDateTime timestemp) {
        this.timestemp = timestemp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMenssage() {
        return menssage;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ErrorDetail() {
    }

    public ErrorDetail(LocalDateTime timestemp, Integer status, String menssage, String path) {
        this.timestemp = timestemp;
        this.status = status;
        this.menssage = menssage;
        this.path = path;
    }
}
