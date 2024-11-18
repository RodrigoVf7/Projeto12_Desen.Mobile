package br.edu.fateczl.timejogador.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.timejogador.model.Time;

public class TimeDao {
    private SQLiteDatabase db;
    private final DatabaseHelper dbHelper;

    // Nome da tabela e colunas no banco de dados
    private static final String TABLE_NAME = "Time";
    private static final String COLUMN_CODIGO = "codigo";
    private static final String COLUMN_NOME = "nome";
    private static final String COLUMN_CIDADE = "cidade";

    public TimeDao(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // Inserir um Time
    public long insert(Time time) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_CODIGO, time.getCodigo());
        values.put(COLUMN_NOME, time.getNome());
        values.put(COLUMN_CIDADE, time.getCidade());

        return db.insert(TABLE_NAME, null, values);
    }

    // Atualizar um Time
    public int update(Time time) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOME, time.getNome());
        values.put(COLUMN_CIDADE, time.getCidade());

        String whereClause = COLUMN_CODIGO + " = ?";
        String[] whereArgs = {String.valueOf(time.getCodigo())};

        return db.update(TABLE_NAME, values, whereClause, whereArgs);
    }

    // Deletar um Time
    public int delete(int codigo) {
        String whereClause = COLUMN_CODIGO + " = ?";
        String[] whereArgs = {String.valueOf(codigo)};

        return db.delete(TABLE_NAME, whereClause, whereArgs);
    }

    // Buscar um Time por código
    public Time getById(int codigo) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_CODIGO + " = ?";
        String[] whereArgs = {String.valueOf(codigo)};

        Cursor cursor = db.rawQuery(query, whereArgs);

        if (cursor != null && cursor.moveToFirst()) {
            Time time = new Time();
            time.setCodigo(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_CODIGO)));
            time.setNome(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOME)));
            time.setCidade(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CIDADE)));

            cursor.close();
            return time;
        }
        return null;
    }

    // Listar todos os Times
    public List<Time> getAll() {
        List<Time> times = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Time time = new Time();
                time.setCodigo(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_CODIGO)));
                time.setNome(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOME)));
                time.setCidade(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CIDADE)));

                times.add(time);
            } while (cursor.moveToNext());

            cursor.close();
        }
        return times;
    }
}

