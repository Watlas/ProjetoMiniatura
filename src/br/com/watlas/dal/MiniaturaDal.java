/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.watlas.dal;

import br.com.watlas.model.Fabricante;
import br.com.watlas.model.Foto;
import br.com.watlas.model.Miniatura;
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
public class MiniaturaDal {

    private Connection conexao;

    public MiniaturaDal() throws Exception {
        conexao = ConexaoDal.getConexao();
    }

    public void addMiniatura(Miniatura objeto) throws Exception {

        String sql = "INSERT INTO miniaturas(min_iden, min_modelo, min_ano, min_observacoes, min_edicao, min_escala, min_valor, min_fab_iden, min_tm_iden, min_tem_iden)"
                + " VALUES (DEFAULT, ?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setObject(1, objeto.getMin_modelo());
            preparedStatement.setObject(2, objeto.getMin_ano());
            preparedStatement.setObject(3, objeto.getMin_observacoes());
            preparedStatement.setObject(4, objeto.getMin_edicao());
            preparedStatement.setObject(5, objeto.getMin_escala());
            preparedStatement.setObject(6, objeto.getMin_valor());
            preparedStatement.setObject(7, objeto.getFabricante().getFab_iden());
            preparedStatement.setObject(8, objeto.getTipo_miniatura().getTipo_idem());
            preparedStatement.setObject(9, objeto.getTema().getTema_iden());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;

        }
    }

    public void deleteMiniatura(int miniId) throws Exception {
        String sql = "DELETE FROM miniaturas WHERE min_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, miniId);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }

    public void updateminiatura(Miniatura objeto) throws Exception {

        String sql = "UPDATE miniaturas SET min_modelo=?, min_ano=?, min_observacoes=?, min_edicao=?, min_escala=?, min_valor=?, min_fab_iden=?, min_tm_iden=?, min_tem_iden=? WHERE min_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, objeto.getMin_modelo());
            preparedStatement.setInt(2, objeto.getMin_ano());
            preparedStatement.setString(3, objeto.getMin_observacoes());
            preparedStatement.setString(4, objeto.getMin_edicao());
            preparedStatement.setString(5, objeto.getMin_escala());
            preparedStatement.setDouble(6, objeto.getMin_valor());
            preparedStatement.setInt(7, objeto.getFabricante().getFab_iden());
            preparedStatement.setInt(8, objeto.getTipo_miniatura().getTipo_idem());
            preparedStatement.setInt(9, objeto.getTema().getTema_iden());
            preparedStatement.setInt(10, objeto.getMin_iden());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;

        }
    }

    public List<Miniatura> getAllMiniaturas() throws Exception {
        FabricanteDal fabricanteDal = new FabricanteDal();
        Tipo_MiniaturaDal tipoDal = new Tipo_MiniaturaDal();
        TemaDal temasDal = new TemaDal();
        List<Miniatura> miniaturas = new ArrayList<Miniatura>();
        String sql = "SELECT * FROM miniaturas";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Miniatura miniatura = new Miniatura();
                miniatura.setMin_iden(rs.getInt("min_iden"));
                miniatura.setMin_modelo(rs.getString("min_modelo"));
                miniatura.setMin_ano(rs.getInt("min_ano"));
                miniatura.setMin_observacoes(rs.getString("min_observacoes"));
                miniatura.setMin_edicao(rs.getString("min_edicao"));
                miniatura.setMin_escala(rs.getString("min_escala"));
                miniatura.setMin_valor(rs.getDouble("min_valor"));

                int idfabricante = rs.getInt("min_fab_iden");
                Fabricante fabricante = fabricanteDal.getFabricantebyId(idfabricante);
                miniatura.setFabricante(fabricante);

                int idtipoMiniatura = rs.getInt("min_tm_iden");
                Tipo_Miniatura tipo_miniatura = tipoDal.getTipoMiniaturaById(idtipoMiniatura);
                miniatura.setTipo_miniatura(tipo_miniatura);

                int idtema = rs.getInt("min_tem_iden");
                Tema tema = temasDal.getTemaById(idtema);
                miniatura.setTema(tema);
                miniaturas.add(miniatura);

            }
        } catch (Exception e) {
            throw e;

        }

        return miniaturas;
    }

    public Miniatura getMiniaturaById(int Minid) throws Exception {

        Miniatura miniatura = new Miniatura();
        String sql = "SELECT * FROM miniaturas WHERE min_iden=?";
        try {
            FabricanteDal fabricanteDal = new FabricanteDal();
            Tipo_MiniaturaDal tipoDal = new Tipo_MiniaturaDal();
            TemaDal temasDal = new TemaDal();
            FotoDal fotodal = new FotoDal();

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, Minid);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                miniatura.setMin_iden(rs.getInt("min_iden"));
                miniatura.setMin_modelo(rs.getString("min_modelo"));
                miniatura.setMin_ano(rs.getInt("min_ano"));
                miniatura.setMin_observacoes(rs.getString("min_observacoes"));
                miniatura.setMin_edicao(rs.getString("min_edicao"));
                miniatura.setMin_escala(rs.getString("min_escala"));
                miniatura.setMin_valor(rs.getDouble("min_valor"));

                int idfabricante = rs.getInt("min_fab_iden");
                Fabricante fabricante = fabricanteDal.getFabricantebyId(idfabricante);
                miniatura.setFabricante(fabricante);

                int idtipoMiniatura = rs.getInt("min_tm_iden");
                Tipo_Miniatura tipo_miniatura = tipoDal.getTipoMiniaturaById(idtipoMiniatura);
                miniatura.setTipo_miniatura(tipo_miniatura);

                int idtema = rs.getInt("min_tem_iden");
                Tema tema = temasDal.getTemaById(idtema);
                miniatura.setTema(tema);

                List<Foto> fotos = fotodal.getallFotos(miniatura);
                miniatura.setFotos(fotos);

            }

        } catch (Exception e) {

            throw e;
        }
        return miniatura;
    }
}
