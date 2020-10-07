/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.watlas.dal;

import br.com.watlas.model.Tema;
import br.com.watlas.model.Tipo_Miniatura;
import java.sql.Connection;
import br.com.watlas.util.ConexaoDal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author watla
 */
public class TemaDal {

    private Connection conexao;

    public TemaDal() throws Exception {
        conexao = ConexaoDal.getConexao();
    }

    public void addTema(Tema tema) throws Exception {
        String sql = "INSERT INTO temas(tem_iden, tem_nome) VALUES(DEFAULT, ?)";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, tema.getTema_nome());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;

        }

    }

    public void deleteTema(int temaId) throws Exception {
        String sql = "DELETE FROM temas WHERE tem_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, temaId);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }

    public void updateTema(Tema tema) throws Exception {
        String sql = "UPDATE temas SET tem_nome = '" + tema.getTema_nome() + "' WHERE tem_iden = " + tema.getTema_iden();
        //     String sql = "UPDATE temas SET tem_nome = ? WHERE tem_iden = ?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            //    preparedStatement.setString(1, tema.getTema_nome());
            //    preparedStatement.setInt(2, tema.getTema_iden());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Tema> getallTemas() throws Exception {
        List<Tema> lista = new ArrayList<Tema>();
        String sql = "SELECT * FROM temas";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Tema tema = new Tema();
                tema.setTema_iden(rs.getInt("tem_iden"));
                tema.setTema_nome(rs.getString("tem_nome"));
                lista.add(tema);
            }

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public Tema getTemaById(int temaId) throws Exception {
        Tema tema = new Tema();
        String sql = "SELECT * FROM temas WHERE tem_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, temaId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tema.setTema_iden(rs.getInt("tem_iden"));
                tema.setTema_nome(rs.getString("tem_nome"));

            }
        } catch (Exception e) {
            throw e;
        }
        return tema;
    }

    public Tema getTemaByNome(String temaNome) throws Exception {
        Tema tema = new Tema();
        String sql = "SELECT * FROM temas WHERE tem_nome=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, temaNome);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tema.setTema_iden(rs.getInt("tem_iden"));
                tema.setTema_nome(rs.getString("tem_nome"));

            }
        } catch (Exception e) {
            throw e;
        }
        return tema;
    }

    public List<Tema> getallTemasAfabetic() throws Exception {
        List<Tema> lista = new ArrayList<Tema>();
        String sql = "SELECT * FROM temas";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Tema tema = new Tema();
                tema.setTema_iden(rs.getInt("tem_iden"));
                tema.setTema_nome(rs.getString("tem_nome"));
                lista.add(tema);
            }
            for (int i = 0; i < lista.size(); i++) {
                for (int j = i; j < lista.size(); j++) {
                    if (lista.get(i).getTema_nome().compareToIgnoreCase(lista.get(j).getTema_nome()) >= 0) {
                        Tema temp = lista.get(j);
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
