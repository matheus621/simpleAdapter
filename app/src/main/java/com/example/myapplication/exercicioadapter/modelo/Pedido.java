package com.example.myapplication.exercicioadapter.modelo;

import java.math.BigDecimal;

public class Pedido {

    protected Long id;
    protected String cliente;
    protected String produto;
    protected String data;
    protected BigDecimal valor;


    public Pedido(Long id, String cliente, String produto, String data, BigDecimal valor) {

        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
        this.data = data;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
