package google.com.healthhigh.activities;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

import google.com.healthhigh.dao.DesafioDAO;
import google.com.healthhigh.domain.Desafio;
import com.google.healthhigh.R;

public class DetalhesDesafios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_desafios);
        carregaDesafio();
    }

    private void carregaDesafio() {
        int id = getIntent().getIntExtra("desafio_id", 0);
        final AlertDialog ad=new AlertDialog.Builder(this).create();
        if(id > 0){
            DesafioDAO dao = new DesafioDAO(this);
            Desafio d = dao.getDesafio(id);
            if(d.getId() > 0){
                TextView titulo = (TextView) findViewById(R.id.tituloDetalhesDesafio);
                TextView descricao = (TextView) findViewById(R.id.descricaoDetalheDesafio);
                TextView data_criacao = (TextView) findViewById(R.id.dataCriacaoDetalheDesafio);
                Calendar oData = Calendar.getInstance();
                String data = "";
                data_criacao.setText(data);
                titulo.setText(d.getTitulo());
                descricao.setText(d.getDescricao());
            } else {
                ad.setTitle("Desafio não encontrado!");
                ad.setMessage("Desafio não foi encontrado no sistema, tente novamente!");
                ad.show();
            }
        } else {
            ad.setTitle("Desafio não encontrado!");
            ad.setMessage("Desafio não foi encontrado no sistema, tente novamente!");
            ad.show();
        }
    }
}
