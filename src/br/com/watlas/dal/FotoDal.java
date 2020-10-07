/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.watlas.dal;

import br.com.watlas.model.Foto;
import br.com.watlas.model.Miniatura;
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
 *
 * @author watla //
 */
public class FotoDal {

    private Connection conexao;

    public FotoDal() throws Exception {
        conexao = ConexaoDal.getConexao();
    }

    public void addFoto(Foto objeto) throws Exception {
        String sql = "INSERT INTO fotos(fot_iden, fot_caminho, fot_descricao, fot_min_iden) VALUES(DEFAULT, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objeto.getFoto_caminho());
            preparedStatement.setString(2, objeto.getFoto_descricao());
            preparedStatement.setInt(3, objeto.getMiniatura().getMin_iden());
            preparedStatement.execute();
        } catch (Exception e) {
             throw e;
        }

    }

    public void deleteFoto(int fotoId) throws Exception {
        String sql = "DELETE FROM fotos WHERE fot_min_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, fotoId);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
             throw e;
        }
    }

    public void updateFoto(Foto objeto) throws Exception {
        String sql = "UPDATE fotos SET fot_caminho =?, fot_descricao=?, fot_min_iden=? WHERE fot_iden =?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objeto.getFoto_caminho());
            preparedStatement.setString(2, objeto.getFoto_descricao());
            preparedStatement.setInt(3, objeto.getMiniatura().getMin_iden());
            preparedStatement.setInt(4, objeto.getFoto_iden());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
             throw e;

        }
    }

    public List<Foto> getallFotos(Miniatura miniatura) throws Exception {
        List<Foto> retorno = new ArrayList<Foto>();
        String sql = "SELECT * FROM fotos WHERE fot_min_iden=?";

        try {

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, miniatura.getMin_iden());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Foto foto = new Foto();
                foto.setFoto_iden(rs.getInt("fot_iden"));
                foto.setFoto_caminho(rs.getString("fot_caminho"));
                foto.setFoto_descricao(rs.getString("fot_descricao"));

                foto.setMiniatura(miniatura);
                retorno.add(foto);
            }
        } catch (Exception e) {
              throw e;
        }
        return retorno;
    }

    public Foto getTipoFotosById(int fotoId) throws Exception {
        Foto foto = new Foto();
        MiniaturaDal miniaturadal = new MiniaturaDal();
        String sql = "SELECT * FROM fotos WHERE fot_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, fotoId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                foto.setFoto_iden(rs.getInt("fot_iden"));
                foto.setFoto_caminho(rs.getString("fot_caminho"));
                foto.setFoto_descricao(rs.getString("fot_descricao"));
                Miniatura miniatura = miniaturadal.getMiniaturaById(rs.getInt("fot_min_iden"));
                foto.setMiniatura(miniatura);
            }
        } catch (Exception e) {
            throw e;
        }
        return foto;
    }

}
