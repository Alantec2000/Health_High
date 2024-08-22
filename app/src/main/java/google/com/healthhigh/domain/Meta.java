package google.com.healthhigh.domain;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Alan on 10/06/2017.
 */

public class Meta {
    private int id,
                tipo,
                qtde;
    private long tempo, data;
    private String
            nome,
            descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getTempo() {
        return tempo;
    }

    public void setTempo(long tempo) {
        this.tempo = tempo;
    }

    public long getData() {
        return data;
    }

    public void setData(long tempo) {
        this.data = tempo;
    }
}
