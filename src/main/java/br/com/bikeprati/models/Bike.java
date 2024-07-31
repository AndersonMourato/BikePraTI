package br.com.bikeprati.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "O ID não pode ser null.")
    Integer id;

    String descricao;
    String modelo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    Date dataCadastro;
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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
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

    public Bike(Integer id, String descricao, String modelo, Date dataCadastro, Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.modelo = modelo;
        this.dataCadastro = dataCadastro;
        this.preco = preco;
    }
}
