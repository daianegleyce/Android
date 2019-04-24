package br.usjt.filaChamados;

import java.io.Serializable;
import java.util.List;

public class Fila implements Serializable {
    private int id;
    private String nome;
    private int iconId;
    private List<Chamado> chamados;

    public Fila(String nome, int iconId) {
        this.nome = nome;
        this.iconId = iconId;
    }

    public Fila(int id, String nome, int iconId) {
        this.id = id;
        this.nome = nome;
        this.iconId = iconId;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }
    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
    public int getId() {return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIconId() {
        return iconId;
    }
    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

}