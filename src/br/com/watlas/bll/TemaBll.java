/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.watlas.bll;

import br.com.watlas.dal.TemaDal;
import br.com.watlas.model.Tema;
import java.util.List;

/**
 *
 * @author watla
 */
public class TemaBll {

    TemaDal temaDal;

    public TemaBll() throws Exception {
        temaDal = new TemaDal();
    }

    private void validarNome(Tema tema) throws Exception {
        String nome = tema.getTema_nome().trim().toLowerCase();
        String invalidos = "1234567890'\"!@#$%¨&*()-_+={[}]/?><;:";
        for (int i = 0; i < invalidos.length(); i++) {
            if (nome.contains("" + invalidos.charAt(i))) {
                throw new Exception("Nome do tema inválido!");
            }
        }
        if (nome.equals("")) {
            throw new Exception("Informe o nome do tema");
        }
    }

    public void addTema(Tema tema) throws Exception {
        try {
            validarNome(tema);
            temaDal.addTema(tema);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe um fabricante com este nome";
            }

            throw new Exception(mensagem);
        }
    }

    public void deleteTema(int temaId) throws Exception {
        try {
            temaDal.deleteTema(temaId);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("update")) {
                mensagem = "EXISTE UMA MINIATURA COM ESSE TEMA CADASTRADA";
            }

            throw new Exception(mensagem);

        }
    }

    public void updateTema(Tema tema) throws Exception {
        try {
            validarNome(tema);
            temaDal.updateTema(tema);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe um fabricante com este nome";
            }

            throw new Exception(mensagem);
        }
    }

    public List<Tema> getallTemas() throws Exception {
        try {
            return temaDal.getallTemas();

        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    public Tema getTemaById(int temaId) throws Exception {
        try {
            return temaDal.getTemaById(temaId);

        } catch (Exception e) {
            throw e;
        }

    }

    public Tema getTemaByNome(String temaNome) throws Exception {
        try {
            return temaDal.getTemaByNome(temaNome);
        } catch (Exception e) {
            throw e;
        }

    }

    public List<Tema> getallTemasAfabetic() throws Exception {
        try {
            return temaDal.getallTemasAfabetic();
        } catch (Exception e) {
            throw e;
        }

    }

}
