/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.watlas.dal;

import br.com.watlas.model.Fabricante;
import br.com.watlas.model.Tema;
import br.com.watlas.model.Tipo_Miniatura;
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
public class Tipo_MiniaturaDal {

    private Connection conexao;

    public Tipo_MiniaturaDal() throws Exception {
        this.conexao = ConexaoDal.getConexao();
    }

    public void addTipoMiniatura(Tipo_Miniatura tipo) throws Exception {
        String sql = "INSERT INTO tipo_miniaturas(tm_iden, tm_tipo) VALUES(DEFAULT, ?)";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, tipo.getTipo_miniatura());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }

    public void deleteTipoMiniatura(int tipoId) throws Exception {
        String sql = "DELETE FROM tipo_miniaturas WHERE tm_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, tipoId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public void updateTipoMiniatura(Tipo_Miniatura tipo) throws Exception {
        String sql = "UPDATE tipo_miniaturas SET tm_tipo =? WHERE tm_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, tipo.getTipo_miniatura());
            preparedStatement.setInt(2, tipo.getTipo_idem());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Tipo_Miniatura> getallTiposMiniatura() throws Exception {
        List<Tipo_Miniatura> lista = new ArrayList<Tipo_Miniatura>();
        String sql = "SELECT * FROM tipo_miniaturas";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Tipo_Miniatura tipo = new Tipo_Miniatura();
                tipo.setTipo_idem(rs.getInt("tm_iden"));
                tipo.setTipo_miniatura(rs.getString("tm_tipo"));
                lista.add(tipo);
            }

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public Tipo_Miniatura getTipoMiniaturaById(int tipoId) throws Exception {
        Tipo_Miniatura tipo = new Tipo_Miniatura();
        String sql = "SELECT * FROM tipo_miniaturas WHERE tm_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, tipoId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tipo.setTipo_idem(rs.getInt("tm_iden"));
                tipo.setTipo_miniatura(rs.getString("tm_tipo"));
            }
        } catch (Exception e) {
            throw e;
        }
        return tipo;
    }

    public Tipo_Miniatura getTipoMiniaturaByNome(String nome) throws Exception {
        Tipo_Miniatura tipo = new Tipo_Miniatura();
        String sql = "SELECT * FROM tipo_miniaturas WHERE tm_tipo=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tipo.setTipo_idem(rs.getInt("tm_iden"));
                tipo.setTipo_miniatura(rs.getString("tm_tipo"));
            }
        } catch (Exception e) {
            throw e;
        }
        return tipo;
    }

    public List<Tipo_Miniatura> getallTiposMiniaturaalfabetic() throws Exception {
        List<Tipo_Miniatura> lista = new ArrayList<Tipo_Miniatura>();
        String sql = "SELECT * FROM tipo_miniaturas";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Tipo_Miniatura tipo = new Tipo_Miniatura();
                tipo.setTipo_idem(rs.getInt("tm_iden"));
                tipo.setTipo_miniatura(rs.getString("tm_tipo"));
                lista.add(tipo);
            }
            for (int i = 0; i < lista.size(); i++) {
                for (int j = i; j < lista.size(); j++) {
                    if (lista.get(i).getTipo_miniatura().compareToIgnoreCase(lista.get(j).getTipo_miniatura()) >= 0) {
                        Tipo_Miniatura temp = lista.get(j);
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
