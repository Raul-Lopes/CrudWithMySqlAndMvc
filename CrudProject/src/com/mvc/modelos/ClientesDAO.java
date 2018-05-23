/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.modelos;

import com.mvc.database.AcessoBanco;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raul
 */
public class ClientesDAO {

    private Connection conn = null;
    private Statement stm;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ClientesBean registro;
    private final AcessoBanco conectarBanco = new AcessoBanco();

    public ClientesBean inserir( ClientesBean obj) throws SQLException, ClassNotFoundException, IOException, Exception {

        try {
            String consultaSQL = "Insert into Clients "
                    + " ( NOME, "
                    + " CPF, "
                    + " ENDERECO, "
                    + " BAIRRO, "
                    + " CIDADE,"
                    + " ESTADO ) "
                    + " values ( ?, ?, ?, ?, ?, ? ) ";
            
            conn = conectarBanco.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, obj.getNome());
            pstm.setString(2, obj.getCpf());
            pstm.setString(3, obj.getEndereco());
            pstm.setString(4, obj.getBairro());
            pstm.setString(5, obj.getCidade());
            pstm.setString(6, obj.getEstado());            
            pstm.executeUpdate();

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    //pConn.rollback();
                }
            } catch (Exception ex) {
                System.out.println("merda: " + ex.getMessage());
            }
        }
        return null;
    }

    public ClientesBean alterar( ClientesBean obj) throws SQLException, ClassNotFoundException, IOException, Exception {

        try {
            String consultaSQL = "update clients set "
                    + " NOME = ?, "
                    + " CPF = ?, "
                    + " ENDERECO = ?, "
                    + " BAIRRO = ?, "
                    + " CIDADE = ?, "
                    + " ESTADO = ? "
                    + " where ID = ? ";
            
            conn = conectarBanco.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, obj.getNome());
            pstm.setString(2, obj.getCpf());
            pstm.setString(3, obj.getEndereco());
            pstm.setString(4, obj.getBairro());
            pstm.setString(5, obj.getCidade());
            pstm.setString(6, obj.getEstado());            
            pstm.setInt(7, obj.getId());
            pstm.executeUpdate();

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    //pConn.rollback();
                }
            } catch (Exception ex) {
                System.out.println("merda: " + ex.getMessage());
            }
        }
        return null;
    }


    public ClientesBean apagar( ClientesBean obj) throws SQLException, ClassNotFoundException, IOException, Exception {

        try {
            String consultaSQL = "delete from clients where ID = ? ";
            
            conn = conectarBanco.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, obj.getId());
            pstm.executeUpdate();

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    //pConn.rollback();
                }
            } catch (Exception ex) {
                System.out.println("merda: " + ex.getMessage());
            }
        }
        return null;
    }

    
    
    //----------------------------------------------------------------------------------------------------------------------------
    public ClientesBean listarClienteId(int id) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from clients where ID = ?";

        try {

            conn = conectarBanco.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                registro = new ClientesBean();
                registro.setId(rs.getInt("ID"));
                registro.setNome(rs.getString("NOME"));
                registro.setCpf(rs.getString("CPF"));
                registro.setEndereco(rs.getString("ENDERECO"));
                registro.setBairro(rs.getString("BAIRRO"));
                registro.setCidade(rs.getString("CIDADE"));
                registro.setCidade(rs.getString("ESTADO"));                
                break;
            }

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    //conn.rollback();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println("merda: " + ex.getMessage());
            }
        }
        return registro;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<ClientesBean> tabelaClientes() throws SQLException, ClassNotFoundException, IOException, Exception {

        List<ClientesBean> listaClientesBean = new ArrayList<ClientesBean>();
        String consultaSQL = "select * from clients order by NOME";

        try {
            conn = conectarBanco.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                registro = new ClientesBean();
                registro.setId(rs.getInt("ID"));
                registro.setNome(rs.getString("NOME"));
                registro.setCpf(rs.getString("CPF"));
                registro.setEndereco(rs.getString("ENDERECO"));
                registro.setBairro(rs.getString("BAIRRO"));
                registro.setCidade(rs.getString("CIDADE"));
                registro.setEstado(rs.getString("ESTADO"));
                listaClientesBean.add(registro);
            }

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    //conn.rollback();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println("Ops: " + ex.getMessage());
            }
        }
        return listaClientesBean;
    }

}
