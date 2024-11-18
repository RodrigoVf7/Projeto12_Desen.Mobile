package br.edu.fateczl.timejogador.controller;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.timejogador.model.Time;
import br.edu.fateczl.timejogador.persistence.TimeDao;

/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/


public class TimeController {
    private final TimeDao timeDao;

    public TimeController(Context context) {
        this.timeDao = new TimeDao(context);
    }

    public long inserirTime(Time time) {
        timeDao.open();
        long id = timeDao.insert(time);
        timeDao.close();
        return id;
    }

    public int atualizarTime(Time time) {
        timeDao.open();
        int rowsAffected = timeDao.update(time);
        timeDao.close();
        return rowsAffected;
    }

    public int deletarTime(int codigo) {
        timeDao.open();
        int rowsAffected = timeDao.delete(codigo);
        timeDao.close();
        return rowsAffected;
    }

    public Time buscarTimePorCodigo(int codigo) {
        timeDao.open();
        Time time = timeDao.getById(codigo);
        timeDao.close();
        return time;
    }

    public List<Time> listarTodosTimes() {
        timeDao.open();
        List<Time> times = timeDao.getAll();
        timeDao.close();
        return times;
    }
}

