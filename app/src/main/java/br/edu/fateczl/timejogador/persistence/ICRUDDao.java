package br.edu.fateczl.timejogador.persistence;

import java.util.List;

/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public interface ICRUDDao<T> {
    void open();
    void close();
    long insert(T obj);
    int update(T obj);
    int delete(int id);
    T getById(int id);
    List<T> getAll();
}
