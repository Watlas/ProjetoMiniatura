/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.watlas.model;

/**
 *
 * @author watla
 */
public class Tipo_Miniatura {

    private int tipo_idem;
    private String tipo_miniatura;

    public Tipo_Miniatura() throws Exception {
    }

    public int getTipo_idem() {
        return tipo_idem;
    }

    public void setTipo_idem(int tipo_idem) {
        this.tipo_idem = tipo_idem;
    }

    public String getTipo_miniatura() {
        return tipo_miniatura;
    }

    public void setTipo_miniatura(String tipo_miniatura) {
        this.tipo_miniatura = tipo_miniatura;
    }

}
