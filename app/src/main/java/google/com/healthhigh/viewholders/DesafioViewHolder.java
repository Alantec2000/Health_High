package google.com.healthhigh.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.healthhigh.R;

import google.com.healthhigh.domain.Desafio;

/**
 * Created by Alan on 09/07/2017.
 */

public class DesafioViewHolder extends RecyclerView.ViewHolder {
    final TextView titulo;
    final TextView descricao;
    final ImageView foto;
    final TextView tentativas;
    private Desafio d;

    public DesafioViewHolder(View v){
        super(v);
        foto = (ImageView) v.findViewById(R.id.iconeDesafio);
        titulo = (TextView) v.findViewById(R.id.tituloDesafio);
        tentativas = (TextView) v.findViewById(R.id.contadorTentativas);
        descricao = (TextView) v.findViewById(R.id.descricaoDesafio);
    }
    public TextView getTitulo() {
        return titulo;
    }
    public TextView getDescricao() {
        return descricao;
    }
    public ImageView getFoto() {
        return foto;
    }
    public TextView getTentativas() {
        return tentativas;
    }
    public void setD(Desafio d) {
        this.d = d;
    }
}
