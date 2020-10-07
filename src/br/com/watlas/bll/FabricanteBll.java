/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.watlas.bll;

import br.com.watlas.dal.FabricanteDal;
import br.com.watlas.model.Fabricante;
import static java.nio.file.Files.list;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author watla
 */
public class FabricanteBll {

    private FabricanteDal dal;

    public FabricanteBll() throws Exception {
        this.dal = new FabricanteDal();
    }

    public static void validarNome(Fabricante fabricante) throws Exception {
        String nome = fabricante.getFab_nome().trim().toLowerCase();
        String invalidos = "1234567890'\"!@#$%¨&*()-_+={[}]/?><;:";
        if (nome.equals("")) {
            throw new Exception("Informe o nome do fabricante");
        }
        for (int i = 0; i < invalidos.length(); i++) {
            if (nome.contains("" + invalidos.charAt(i))) {
                throw new Exception("Nome do fabricante inválido!");
            }
        }

    }

    public void addFabrica(Fabricante fab) throws Exception {
        try {
            validarNome(fab);
            dal.addFabricante(fab);
        } catch (Exception e) {
            //ate aqui a exception e tem a String "duplicate bla bla bla"
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe um fabricante com este nome";
            }

            throw new Exception(mensagem);
        }
    }

    public void deleteFabrica(int fab) throws Exception {
        try {

            dal.deleteFabricante(fab);

        } catch (Exception e) {
               String mensagem = e.getMessage();
            if (mensagem.contains("update")) {
                mensagem = "EXISTE UMA MINIATURA COM ESSA FABRICA CADASTRADA";
            }

            throw new Exception(mensagem);

        }
    }

    public void updateFabricante(Fabricante fab) throws Exception {
        try {
            validarNome(fab);
            dal.updateFabricante(fab);

        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe um fabricante com este nome";
            }
            throw new Exception(mensagem);

        }
    }

    public List<Fabricante> getallFabricante() throws Exception {
        try {
            return dal.getallFabricante();

        } catch (Exception e) {
          throw new Exception(e);

        }
       
    }

    public Fabricante getFabricantebyId(int fab) throws Exception {
        try {
            return dal.getFabricantebyId(fab);

        } catch (Exception e) {
          throw new Exception(e);

        }
        
    }

    public Fabricante getFabricantebyNome(String nome) throws Exception {
        try {
            return dal.getFabricantebyNome(nome);

        } catch (Exception e) {
           throw new Exception(e);

        }
   
    }

    public List<Fabricante> getallFabricanteAlfa() throws Exception {
        try {
            return dal.getallFabricanteAlfabeth();

        } catch (Exception e) {
            throw new Exception(e);

        }
       
    }

}
