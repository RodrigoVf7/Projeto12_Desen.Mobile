package br.edu.fateczl.timejogador.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "app.db";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Jogador (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(100), data_nasc VARCHAR(10), altura REAL, peso REAL, timeCodigo INTEGER)");
        db.execSQL("CREATE TABLE Time (codigo INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(50), cidade VARCHAR(80))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Jogador");
        db.execSQL("DROP TABLE IF EXISTS Time");
        onCreate(db);
    }
}

