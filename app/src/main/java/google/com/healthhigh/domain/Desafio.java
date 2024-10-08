package google.com.healthhigh.domain;

import java.util.Date;

/**
 * Created by Alan on 16/05/2017.
 */

public class Desafio {
    private long id;
    private String titulo;
    private String descricao;
    private int tipo;
    private boolean aceito;
    private int tentativas;
    private long data_criacao;
    private long data_aceito;

    public Desafio() {}

    public Desafio(long id, String t, String d, int td, boolean fa, int tn) {
        this.id = id;
        this.titulo = t;
        this.descricao = d;
        this.tipo = td;
        this.tentativas = tn;
    }

    public boolean isAceito() {return aceito;}

    public void setAceito(boolean aceito) {this.aceito = aceito;}

    public long getData_criacao() {return data_criacao;}

    public void setData_criacao(long data_criacao) {this.data_criacao = data_criacao;}

    public long getData_aceito() {return data_aceito;}

    public void setData_aceito(long data_aceito) {this.data_aceito = data_aceito;}

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

    public int getTipo() {return tipo;}

    public void setTipo(int tipo) {this.tipo = tipo;}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
