package br.usjt.filaChamados;

import java.io.Serializable;
import java.util.Date;

public class Chamado implements Serializable {
    private int id;
    private Fila fila;
    private String descricao;
    private Date dataAbertura;
    private Date dataFechamento;
    private String status;

    /*public Chamado(Fila fila, String descricao, Date dataAbertura, Date dataFechamento, String status) {
        this.fila = fila;
        this.descricao = descricao;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.status = status;
    }*/

    public Chamado(int id, Fila fila, String descricao, Date dataAbertura, Date dataFechamento, String status) {
        this.id = id;
        this.fila = fila;
        this.descricao = descricao;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Fila getFila() {
        return fila;
    }
    public void setFila(Fila fila) {
        this.fila = fila;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getDataAbertura() {
        return dataAbertura;
    }
    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
    public Date getDataFechamento() {
        return dataFechamento;
    }
    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }
}