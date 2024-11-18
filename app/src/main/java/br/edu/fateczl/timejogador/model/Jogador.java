package br.edu.fateczl.timejogador.model;

import android.os.Build;
import androidx.annotation.RequiresApi;
import java.time.LocalDate;

/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class Jogador {
    private int id;
    private String nome;
    private String dataNasc; // Usaremos String no SQLite
    private double altura;
    private double peso;
    private int timeCodigo;

    // Construtor padrão
    public Jogador() {}

    // Construtor com parâmetros
    public Jogador(int id, String nome, String dataNasc, double altura, double peso, int timeCodigo) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.altura = altura;
        this.peso = peso;
        this.timeCodigo = timeCodigo;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getTimeCodigo() {
        return timeCodigo;
    }

    public void setTimeCodigo(int timeCodigo) {
        this.timeCodigo = timeCodigo;
    }

    // Métodos auxiliares para manipular LocalDate
    @RequiresApi(api = Build.VERSION_CODES.O)
    public LocalDate getDataNascAsLocalDate() {
        return LocalDate.parse(dataNasc);
    }

    public void setDataNascFromLocalDate(LocalDate localDate) {
        this.dataNasc = localDate.toString();
    }
}

