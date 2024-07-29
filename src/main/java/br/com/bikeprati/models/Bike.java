package br.com.bikeprati.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String descricao;
    String modelo;
    String dataCadastro;
    Double preco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Bike() {
    }

    public Bike(Integer id, String descricao, String modelo, String dataCadastro, Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.modelo = modelo;
        this.dataCadastro = dataCadastro;
        this.preco = preco;
    }
}
