/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.watlas.model;


import java.util.List;

/**
 * @author watla
 */
public class Miniatura {
    private int min_iden;
    private String min_modelo;
    private int min_ano;
    private String min_observacoes;
    private String min_edicao;
    private String min_escala;
    private double min_valor;
    private Fabricante fabricante;
    private Tipo_Miniatura tipo_miniatura;
    private Tema tema;
    private List<Foto> fotos;

    public int getMin_iden() {
        return min_iden;
    }

    public void setMin_iden(int min_iden) {
        this.min_iden = min_iden;
    }

    public String getMin_modelo() {
        return min_modelo;
    }

    public void setMin_modelo(String min_modelo) {
        this.min_modelo = min_modelo;
    }

    public int getMin_ano() {
        return min_ano;
    }

    public void setMin_ano(int min_ano) {
        this.min_ano = min_ano;
    }

    public String getMin_observacoes() {
        return min_observacoes;
    }

    public void setMin_observacoes(String min_observacoes) {
        this.min_observacoes = min_observacoes;
    }

    public String getMin_edicao() {
        return min_edicao;
    }

    public void setMin_edicao(String min_edicao) {
        this.min_edicao = min_edicao;
    }

    public String getMin_escala() {
        return min_escala;
    }

    public void setMin_escala(String min_escala) {
        this.min_escala = min_escala;
    }

    public double getMin_valor() {
        return min_valor;
    }

    public void setMin_valor(double min_valor) {
        this.min_valor = min_valor;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Tipo_Miniatura getTipo_miniatura() {
        return tipo_miniatura;
    }

    public void setTipo_miniatura(Tipo_Miniatura tipo_miniatura) {
        this.tipo_miniatura = tipo_miniatura;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }


    public Miniatura() {
    }

}
