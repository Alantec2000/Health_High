package google.com.healthhigh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import google.com.healthhigh.db.CreateDB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import google.com.healthhigh.domain.Desafio;
import google.com.healthhigh.domain.Item;
public class DesafioDAO extends DAO {
    public static String
            TABLE_NAME = "phh_desafio",
            ID = "id_desafio",
            TITULO = "s_titulo_desafio",
            DESCRICAO = "s_descricao_desafio",
            TENTATIVAS = "i_tentativas",
            TIPO = "i_tipo",
            ACEITO = "b_aceito",
            DATA_CRIACAO = "s_data_criacao",
            DATA_ACEITO = "s_data_aceito";
    private List<Desafio> desafios;
    private SQLiteDatabase write_db = null;

    public DesafioDAO(Context context) {
        super(context);
        CreateDB db = CreateDB.getDBInstance(context);
        write_db = db.getWritableDatabase();
    }

    public static String getCreateTableString() {
        return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY NOT NULL, " +
                TITULO + " text NOT NULL, " +
                DESCRICAO + " text NOT NULL, " +
                ACEITO + " INTEGER DEFAULT 0, " +
                TIPO + " INTEGER NOT NULL DEFAULT 1, " +
                DATA_ACEITO + " text DEFAULT '', " +
                DATA_CRIACAO + " text NOT NULL, " +
                TENTATIVAS + " INTEGER DEFAULT 0);";
    }

    public static String getDropTableString() {
        return "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
    }

    public Cursor executeSelect(String select) {
        return write_db.rawQuery(select, null);
    }

    @Override
    protected void setContent(Cursor c) {
        Desafio d = new Desafio();
        d.setId(c.getInt(c.getColumnIndex(ID)));
        d.setDescricao(c.getString(c.getColumnIndex(DESCRICAO)));
        d.setTentativas(c.getInt(c.getColumnIndex(TENTATIVAS)));
        d.setTitulo(c.getString(c.getColumnIndex(TITULO)));
        d.setTipo(c.getInt(c.getColumnIndex(TIPO)));
//                    d.setData_criacao(new Date(c.getString(c.getColumnIndex(DATA_CRIACAO))));
                    /*boolean b_aceito = c.getInt(c.getColumnIndex(ACEITO)) == 0 ? false : true;
                    if(b_aceito){
                        d.setData_aceito(new Date(c.getString(c.getColumnIndex(DATA_ACEITO))));
                    } else {
                        d.setData_aceito(null);
                    }*/
        desafios.add(d);
    }

    @Override
    protected void prepareContentReceiver() {
        desafios = new ArrayList<Desafio>();
    }

    public List<Desafio> getDesafiosList(int limit){
        String LIMIT = "";
        if(limit > 0){
            LIMIT = " LIMIT " + limit;
        }
        getSelectQueryContent("SELECT * FROM " + DesafioDAO.getTableName() + " " +
                              "ORDER BY " + DesafioDAO.getID() + " " + LIMIT + ";");
        return desafios;
    }

    public Desafio getDesafio(int id) {
        getSelectQueryContent("SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = " + id + ";");
        Desafio d = null;
        Iterator iT = desafios.iterator();
        if(iT.hasNext()){
            d =(Desafio) iT.next();
        }
        return d;
    }

    public void insereDesafio(Desafio d) {
        write_db.insert(TABLE_NAME, null, createInsertDesafio(d));
    }

    private ContentValues createInsertDesafio(Desafio d) {
        ContentValues cv = new ContentValues();
        cv.put(TITULO, d.getTitulo());
        cv.put(DESCRICAO, d.getDescricao());
        cv.put(TENTATIVAS, d.getTentativas());
        cv.put(ACEITO, 0);
        cv.put(TIPO, d.getTipo());
        cv.put(DATA_CRIACAO, "");
        cv.put(DATA_ACEITO, "");
        return cv;
    }

    public static String getID() {
        return ID;
    }

    public static String getTITULO() {
        return TITULO;
    }

    public static String getDESCRICAO() {
        return DESCRICAO;
    }

    public static String getTENTATIVAS() {
        return TENTATIVAS;
    }

    public static String getTIPO() {
        return TIPO;
    }

    public static String getACEITO() {
        return ACEITO;
    }

    public static String getDataCriacao() {
        return DATA_CRIACAO;
    }

    public static String getDataAceito() {
        return DATA_ACEITO;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }
}
