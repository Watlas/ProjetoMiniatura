/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.watlas.model;

/**
 * @author watla
 */
public class Foto {
    private int foto_iden;
    private String foto_caminho;
    private String foto_descricao;
    private Miniatura miniatura;

    public int getFoto_iden() {
        return foto_iden;
    }

    public void setFoto_iden(int foto_iden) {
        this.foto_iden = foto_iden;
    }

    public String getFoto_caminho() {
        return foto_caminho;
    }

    public void setFoto_caminho(String foto_caminho) {
        this.foto_caminho = foto_caminho;
    }

    public String getFoto_descricao() {
        return foto_descricao;
    }

    public void setFoto_descricao(String foto_descricao) {
        this.foto_descricao = foto_descricao;
    }

    public Miniatura getMiniatura() {
        return miniatura;
    }

    public void setMiniatura(Miniatura miniatura) {
        this.miniatura = miniatura;
    }


}
