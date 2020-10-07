package br.com.watlas.bll;

import br.com.watlas.dal.Tipo_MiniaturaDal;
import br.com.watlas.model.Tipo_Miniatura;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author watla
 */
public class Tipo_MiniaturaBll {

    private Tipo_MiniaturaDal tipoDal;

    public Tipo_MiniaturaBll() throws Exception {
        tipoDal = new Tipo_MiniaturaDal();
    }
    

    public void validarNome(Tipo_Miniatura miniatura) throws Exception {
        String nome = miniatura.getTipo_miniatura().trim().toLowerCase();
        String invalidos = "1234567890'\"!@#$%¨&*()-_+={[}]/?><;:";
      
        for (int i = 0; i < invalidos.length(); i++) {
            if (nome.contains("" + invalidos.charAt(i))) {
                throw new Exception("Nome do tipo de miniatura inválido!");
            }
        }
        if (nome.equals("")) {
            throw new Exception("Informe o nome do tipo de miniaura");
        }
    }

    public void addTipoMiniatura(Tipo_Miniatura tipo) throws Exception {
        try {
            validarNome(tipo);
            tipoDal.addTipoMiniatura(tipo);

        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe um tipo de miniatura com este nome";
            }

            throw new Exception(mensagem);
        }
    }

    public void deleteTipoMiniatura(int tipoId) throws Exception {
        try {
            tipoDal.deleteTipoMiniatura(tipoId);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("update")) {
                mensagem = "EXISTE UMA MINIATURA COM ESSE TIPO CADASTRADA";
            }

            throw new Exception(mensagem);
        }
    }

    public void updateTipoMiniatura(Tipo_Miniatura tipo) throws Exception {
        try {
            validarNome(tipo);
            tipoDal.updateTipoMiniatura(tipo);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe um tipo de miniatura com este nome";
            }

            throw new Exception(mensagem);
        }
    }

    public List<Tipo_Miniatura> getallTiposMiniatura() throws Exception {
        try {
            return tipoDal.getallTiposMiniatura();
        } catch (Exception e) {
            throw e;
        }
    }

    public Tipo_Miniatura getTipoMiniaturaById(int tipoId) throws Exception {
        try {
            return tipoDal.getTipoMiniaturaById(tipoId);
        } catch (Exception e) {
            throw e;
        }
    }

    public Tipo_Miniatura getTipoMiniaturaByNome(String nome) throws Exception {
        try {
            return tipoDal.getTipoMiniaturaByNome(nome);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Tipo_Miniatura> getallTiposMiniaturaalfabetic() throws Exception {
        try {
            return tipoDal.getallTiposMiniaturaalfabetic();
        } catch (Exception e) {
            throw e;
        }
    }

}
