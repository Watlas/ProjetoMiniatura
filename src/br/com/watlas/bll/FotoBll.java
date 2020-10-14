/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.watlas.bll;

import br.com.watlas.dal.FotoDal;
import br.com.watlas.model.Foto;
import br.com.watlas.model.Miniatura;

import java.util.List;


/**
 * @author watla
 */
public class FotoBll {

    FotoDal dal;

    public FotoBll() throws Exception {
        dal = new FotoDal();
    }

    public static void validarNome(Foto foto) throws Exception {
        String nome = foto.getFoto_caminho().trim().toLowerCase();
        String invalidos = "'\"!@#$%¨&*+={[}]";
        for (int i = 0; i < invalidos.length(); i++) {
            if (nome.contains("" + invalidos.charAt(i))) {
                throw new Exception("Nome do caminho inválido!");
            }
        }
        if (nome.equals("")) {
            throw new Exception("Informe o caminho");
        }

    }

    public void addFoto(Foto objeto) throws Exception {
        try {
            dal.addFoto(objeto);
        } catch (Exception e) {

        }

    }

    public void deleteFoto(int fotoId) throws Exception {
        try {
            dal.deleteFoto(fotoId);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("update")) {
                mensagem = "EXISTE UMA MINIATURA COM ESSA FOTO CADASTRADA";
            }

            throw new Exception(mensagem);
        }

    }

    public void updateFoto(Foto objeto) throws Exception {
        try {
            dal.updateFoto(objeto);
        } catch (Exception e) {
            throw e;

        }
    }

    public List<Foto> getallFotos(Miniatura miniatura) throws Exception {
        try {
            return dal.getallFotos(miniatura);
        } catch (Exception e) {
            throw e;
        }

    }

    public Foto getTipoFotosById(int fotoId) throws Exception {
        try {
            return dal.getTipoFotosById(fotoId);
        } catch (Exception e) {
            throw e;
        }
    }

}
