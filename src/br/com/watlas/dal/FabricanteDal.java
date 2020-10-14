/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.watlas.dal;

import br.com.watlas.model.Fabricante;
import br.com.watlas.model.Tema;
import br.com.watlas.util.ConexaoDal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author watla
 */
public class FabricanteDal {

    private Connection conexao;

    public FabricanteDal() throws Exception {
        conexao = ConexaoDal.getConexao();
    }

    public void addFabricante(Fabricante objeto) throws Exception {
        String sql = "INSERT INTO fabricantes(fab_iden, fab_nome) VALUES(DEFAULT, ?)";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objeto.getFab_nome());
            preparedStatement.executeUpdate();
        } catch (Exception e) {

            throw e;
        }

    }

    public void deleteFabricante(int fabId) throws Exception {
        String sql = "DELETE FROM fabricantes WHERE fab_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, fabId);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }

    public void updateFabricante(Fabricante objeto) throws Exception {
        String sql = "UPDATE fabricantes SET fab_nome =? WHERE fab_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objeto.getFab_nome());
            preparedStatement.setInt(2, objeto.getFab_iden());
            preparedStatement.executeUpdate();
        } catch (Exception e) {

            throw e;
        }
    }

    public List<Fabricante> getallFabricante() throws Exception {
        List<Fabricante> lista = new ArrayList<Fabricante>();
        String sql = "SELECT * FROM fabricantes";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setFab_iden(rs.getInt("fab_iden"));
                fabricante.setFab_nome(rs.getString("fab_nome"));
                lista.add(fabricante);
            }

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public Fabricante getFabricantebyId(int fabId) throws Exception {
        Fabricante fab = new Fabricante();
        String sql = "SELECT * FROM fabricantes WHERE fab_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, fabId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                fab.setFab_iden(rs.getInt("fab_iden"));
                fab.setFab_nome(rs.getString("fab_nome"));

            }
        } catch (Exception e) {
            throw e;
        }
        return fab;
    }

    public Fabricante getFabricantebyNome(String nome) throws Exception {
        Fabricante fab = new Fabricante();
        String sql = "SELECT * FROM fabricantes WHERE fab_nome=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                fab.setFab_iden(rs.getInt("fab_iden"));
                fab.setFab_nome(rs.getString("fab_nome"));

            }
        } catch (Exception e) {
            throw e;
        }
        return fab;
    }

    public List<Fabricante> getallFabricanteAlfabeth() throws Exception {
        List<Fabricante> lista = new ArrayList<Fabricante>();
        String sql = "SELECT * FROM fabricantes";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setFab_iden(rs.getInt("fab_iden"));
                fabricante.setFab_nome(rs.getString("fab_nome"));
                lista.add(fabricante);
            }
            for (int i = 0; i < lista.size(); i++) {
                for (int j = i; j < lista.size(); j++) {
                    if (lista.get(i).getFab_nome().compareToIgnoreCase(lista.get(j).getFab_nome()) >= 0) {
                        Fabricante temp = lista.get(j);
                        lista.set(j, lista.get(i));
                        lista.set(i, temp);
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
