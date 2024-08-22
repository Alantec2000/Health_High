package google.com.healthhigh.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import google.com.healthhigh.adapter.DesafioAdapter;
import google.com.healthhigh.dao.DesafioDAO;
import google.com.healthhigh.domain.Desafio;
import com.google.healthhigh.R;

import java.util.List;

public class ListaDesafiosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_desafios);
//        setDesafioList();
    }

    /*private void setDesafioList() {
        RecyclerView rv = (RecyclerView) findViewById(R.id.listaCompletaDesafios);
        DesafioDAO dDao = new DesafioDAO(this);
        List<Desafio> desafios = dDao.getDesafiosList(0);
        rv.setAdapter(new DesafioAdapter(desafios,this));
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        rv.setNestedScrollingEnabled(false);
    }*/
}
