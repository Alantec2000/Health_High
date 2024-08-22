package google.com.healthhigh.dao;

import android.database.Cursor;

import google.com.healthhigh.domain.Meta;

public class MetaDAO {
    static String
            TABLE_NAME = "phh_meta",
            ID = "i_id",
            NOME = "s_nome",
            DESCRICAO = "s_descricao",
            TIPO = "i_tipo",
            QUANTIDADE = "i_qtde",
            TEMPO = "i_tempo",
            DATA = "i_data";

    public static String getCreateTableString(){
        return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY NOT NULL, " +
                NOME + " TEXT NOT NULL, " +
                DESCRICAO + " TEXT NOT NULL DEFAULT '', " +
                TIPO + " INTEGER NOT NULL DEFAULT 0, " +
                QUANTIDADE + " INTEGER NOT NULL DEFAULT 0, " +
                TEMPO + " INTEGER NOT NULL, " +
                DATA + " INTEGER NOT NULL);";
    }

    public static String getDropTableString(){
        return "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
    }

    public static Meta getMeta(Cursor c){
        Meta m = new Meta();
        m.setId(c.getInt(c.getColumnIndex(MetaDAO.ID)));
        m.setNome(c.getString(c.getColumnIndex(MetaDAO.NOME)));
        m.setDescricao(c.getString(c.getColumnIndex(MetaDAO.DESCRICAO)));
        m.setTipo(c.getInt(c.getColumnIndex(MetaDAO.TIPO)));
        m.setQtde(c.getInt(c.getColumnIndex(MetaDAO.QUANTIDADE)));
        m.setData(c.getLong(c.getColumnIndex(MetaDAO.DATA)));
        m.setTempo(c.getLong(c.getColumnIndex(MetaDAO.TEMPO)));
        return m;
    }
}
