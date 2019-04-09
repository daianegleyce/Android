package br.com.bossini.usjt_ccp3anmca_lista_chamados_helpdesk;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

public class Chamado implements Serializable {
    private Fila fila;
    private String descricao;
    private Date dataAbertura;
    private Date dataFechamento;
    private String status;

    public Chamado (Fila f, String d, Date dA, Date dF, String s){
        setFila(f);
        setDescricao(d);
        setDataAbertura(dA);
        setDataFechamento(dF);
        setStatus(s);
    }
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

    @NonNull
    @Override
    public String toString() {
        return String.format(
                Locale.getDefault(),
                "%s:%s",
                getFila().getNome(),
                getDescricao());
    }
}
