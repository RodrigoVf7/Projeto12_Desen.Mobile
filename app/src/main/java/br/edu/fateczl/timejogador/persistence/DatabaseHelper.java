package br.edu.fateczl.timejogador.persistence;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/


public class DatabaseHelper extends SQLiteOpenHelper {
    // Informações do banco de dados
    private static final String DATABASE_NAME = "app_database.db";
    private static final int DATABASE_VERSION = 1;

    // Scripts para criação das tabelas
    private static final String CREATE_TABLE_TIME =
            "CREATE TABLE Time (" +
                    "codigo INTEGER PRIMARY KEY, " +
                    "nome TEXT NOT NULL, " +
                    "cidade TEXT NOT NULL);";

    private static final String CREATE_TABLE_JOGADOR =
            "CREATE TABLE Jogador (" +
                    "id INTEGER PRIMARY KEY, " +
                    "nome TEXT NOT NULL, " +
                    "data_nasc TEXT NOT NULL, " +
                    "altura REAL NOT NULL, " +
                    "peso REAL NOT NULL, " +
                    "timeCodigo INTEGER NOT NULL, " +
                    "FOREIGN KEY (timeCodigo) REFERENCES Time(codigo));";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Cria as tabelas no banco de dados
        db.execSQL(CREATE_TABLE_TIME);
        db.execSQL(CREATE_TABLE_JOGADOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Atualiza as tabelas (se necessário)
        db.execSQL("DROP TABLE IF EXISTS Jogador");
        db.execSQL("DROP TABLE IF EXISTS Time");
        onCreate(db);
    }
}

