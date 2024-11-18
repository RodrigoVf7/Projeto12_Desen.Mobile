package br.edu.fateczl.timejogador.controller;


import android.content.Context;
import java.util.List;
import br.edu.fateczl.timejogador.model.Jogador;
import br.edu.fateczl.timejogador.persistence.JogadorDao;

/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/


public class JogadorController {
    private final JogadorDao jogadorDao;

    public JogadorController(Context context) {
        this.jogadorDao = new JogadorDao(context);
    }

    public long inserirJogador(Jogador jogador) {
        jogadorDao.open();
        long id = jogadorDao.insert(jogador);
        jogadorDao.close();
        return id;
    }

    public int atualizarJogador(Jogador jogador) {
        jogadorDao.open();
        int rowsAffected = jogadorDao.update(jogador);
        jogadorDao.close();
        return rowsAffected;
    }

    public int deletarJogador(int id) {
        jogadorDao.open();
        int rowsAffected = jogadorDao.delete(id);
        jogadorDao.close();
        return rowsAffected;
    }

    public Jogador buscarJogadorPorId(int id) {
        jogadorDao.open();
        Jogador jogador = jogadorDao.getById(id);
        jogadorDao.close();
        return jogador;
    }

    public List<Jogador> listarTodosJogadores() {
        jogadorDao.open();
        List<Jogador> jogadores = jogadorDao.getAll();
        jogadorDao.close();
        return jogadores;
    }
}

