package google.com.healthhigh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import google.com.healthhigh.db.CreateDB;
import google.com.healthhigh.domain.Item;

public abstract class DAO extends CreateDB{
    protected final String SQLITE_ERROR = "SQLITE ERROR";
    public String TABLE_NAME;
    protected SQLiteDatabase write_db = null;
    protected SQLiteDatabase read_db = null;//Não tem diferença do write_db, somente na legibilidade do código...
    protected Context context;
    public DAO(Context context) {
        super(context);
        this.context = context;
        write_db = CreateDB.getDBInstance(context).getWritableDatabase();
        read_db = CreateDB.getDBInstance(context).getReadableDatabase();
    }
    protected Cursor executeSelect(String select) {
        return read_db.rawQuery(select, null);
    }

    protected void getSelectQueryContent(String select) {
        prepareContentReceiver();
        Cursor c = executeSelect(select);
        try {
            if (c.moveToFirst()) {
                do {
                    setContent(c);
                } while (c.moveToNext());
            }
        } catch (Exception e){
           Log.e(SQLITE_ERROR, e.getMessage());
        } finally {
            c.close();
        }
    }

    protected abstract void setContent(Cursor c);

    protected abstract void prepareContentReceiver();


}
