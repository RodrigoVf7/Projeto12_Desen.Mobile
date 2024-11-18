package br.edu.fateczl.timejogador.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.timejogador.model.Jogador;

/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class JogadorDao implements ICRUDDao<Jogador> {
    private SQLiteDatabase db;
    private final DBHelper dbHelper;

    public JogadorDao(Context context) {
        dbHelper = new DBHelper(context);
    }

    @Override
    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public void close() {
        dbHelper.close();
    }

    @Override
    public long insert(Jogador jogador) {
        ContentValues values = new ContentValues();
        values.put("nome", jogador.getNome());
        values.put("data_nasc", jogador.getDataNasc());
        values.put("altura", jogador.getAltura());
        values.put("peso", jogador.getPeso());
        values.put("timeCodigo", jogador.getTimeCodigo());
        return db.insert("Jogador", null, values);
    }

    @Override
    public int update(Jogador jogador) {
        ContentValues values = new ContentValues();
        values.put("nome", jogador.getNome());
        values.put("data_nasc", jogador.getDataNasc());
        values.put("altura", jogador.getAltura());
        values.put("peso", jogador.getPeso());
        values.put("timeCodigo", jogador.getTimeCodigo());
        return db.update("Jogador", values, "id = ?", new String[]{String.valueOf(jogador.getId())});
    }

    @Override
    public int delete(int id) {
        return db.delete("Jogador", "id = ?", new String[]{String.valueOf(id)});
    }

    @Override
    public Jogador getById(int id) {
        Cursor cursor = db.query("Jogador", null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Jogador jogador = cursorToJogador(cursor);
            cursor.close();
            return jogador;
        }
        return null;
    }

    @Override
    public List<Jogador> getAll() {
        List<Jogador> jogadores = new ArrayList<>();
        Cursor cursor = db.query("Jogador", null, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                jogadores.add(cursorToJogador(cursor));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return jogadores;
    }

    private Jogador cursorToJogador(Cursor cursor) {
        Jogador jogador = new Jogador();
        jogador.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
        jogador.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
        jogador.setDataNasc(cursor.getString(cursor.getColumnIndexOrThrow("data_nasc")));
        jogador.setAltura(cursor.getDouble(cursor.getColumnIndexOrThrow("altura")));
        jogador.setPeso(cursor.getDouble(cursor.getColumnIndexOrThrow("peso")));
        jogador.setTimeCodigo(cursor.getInt(cursor.getColumnIndexOrThrow("timeCodigo")));
        return jogador;
    }
}
