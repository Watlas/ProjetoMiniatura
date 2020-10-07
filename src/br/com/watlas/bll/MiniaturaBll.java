/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.watlas.bll;

import br.com.watlas.dal.MiniaturaDal;
import br.com.watlas.model.Miniatura;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author watla
 */
public class MiniaturaBll {

    MiniaturaDal dal;
    Miniatura miniatura;

    public MiniaturaBll() throws Exception {
        dal = new MiniaturaDal();

    }

    private void validabox(Miniatura miniatura) throws Exception {
        try {
            String fabnome = "" + miniatura.getFabricante().getFab_nome().toString();
            String tipo = "" + miniatura.getTipo_miniatura().getTipo_miniatura().toString();
            String tema = "" + miniatura.getTema().getTema_nome().toString();

            if (fabnome.equals("<SELECIONE>")) {
                throw new Exception("INSIRA ALGUMA FABRICA");

            }
            if (tipo.equals("<SELECIONE>")) {
                throw new Exception("NOME INVALIDO");
            }
            if (tema.equals("<SELECIONE>")) {
                throw new Exception("NOME INVALIDO");
            }
        } catch (Exception e) {
            throw e;
        }

    }

    private void validar(Miniatura miniatura) throws Exception {
        try {

            String edicao = miniatura.getMin_edicao().trim().toLowerCase();
            String escala = miniatura.getMin_escala().trim().toLowerCase();
            String modelo = miniatura.getMin_modelo().trim().toLowerCase();
            String ano = "" + miniatura.getMin_ano();
            int anO = miniatura.getMin_ano();
            String observacoes = miniatura.getMin_observacoes().trim().toLowerCase();
            String valor = "" + miniatura.getMin_valor();

            if (modelo.equals("")) {
                throw new Exception("Nome do modelo inválido!");
            }
            if (edicao.equals("")) {
                throw new Exception("Nome da edicao inválido!");
            }
            if (escala.equals("")) {
                throw new Exception("Nome do escala inválido!");
            }

            if (ano.equals("")) {
                throw new Exception("Nome do ano inválido!");
            }
            if (valor.equals("")) {
                throw new Exception("Nome do caminho inválido!");
            }
            if (observacoes.equals("")) {
                throw new Exception("Nome da observação inválido!");
            }
            if (anO > 2021 || anO < 1886) {

                throw new Exception("Informe um ano > 1886 e < 2021 ");

            }
        } catch (Exception e) {
            throw e;
        }

    }

    public void addMiniatura(Miniatura objeto) throws Exception {
        try {
            validabox(objeto);
            validar(objeto);
            dal.addMiniatura(objeto);
        } catch (Exception e) {
            throw e;

        }

    }

    public void deleteMiniatura(int miniId) throws Exception {
        try {
            dal.deleteMiniatura(miniId);
        } catch (Exception e) {
            throw e;
        }
    }

    public void updateminiatura(Miniatura objeto) throws Exception {
        try {
            validabox(objeto);
            dal.updateminiatura(objeto);
        } catch (Exception e) {
            throw e;
        }

    }

    public List<Miniatura> getAllMiniaturas() throws Exception {
        try {
            return dal.getAllMiniaturas();
        } catch (Exception e) {
            throw e;
        }
    }

    public Miniatura getMiniaturaById(int Minid) throws Exception {
        try {
            return dal.getMiniaturaById(Minid);
        } catch (Exception e) {
            throw e;
        }
    }

}
