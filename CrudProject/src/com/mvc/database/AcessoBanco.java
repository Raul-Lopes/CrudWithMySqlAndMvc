package com.mvc.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * <p>
 * Title: Infocus ERP - Projeto Acadêmico</p>
 *
 * @version	versão
 * @param	parâmetro do método
 * @return	retorno do método
 * @exception	exceção
 * @see	veja também
 *
 * <p>
 * Class Description: Atributos de leitura de abastecimentos da placa da bomba
 * de combustível.</p>
 *
 * <p>
 * The MIT License</p>
 * <p>
 * Copyright: Copyright (C) 2011 Raul Lopes</p>
 *
 * @author
 * <p>
 * Raul Lopes The author </p>
 *
 */
public class AcessoBanco {

    private Connection con;
    private String url;
    private String usuario;
    private String senha;

    //==================================        
    public Connection conectar() throws ClassNotFoundException, IOException, SQLException, Exception {

        Class.forName("com.mysql.jdbc.Driver");

        /*
         * jdbc:mysql://137.189.94.129/slide_lai?autoReconnect=true
         */
        //comunicacao padrao
        url = "jdbc:mysql://localhost:3306/CrudWithMySqlAndMvc";
        usuario = "root";
        senha = "";

        try {
            //JOptionPane.showMessageDialog(this, "Configuração da conexão com banco de dados não encontrado. Verifique!", Constantes.AVISO_SISTEMA, JOptionPane.ERROR_MESSAGE);

            //con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/WORLD_CASH_DB?user=root&password=root");
            con = DriverManager.getConnection(url, usuario, senha);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na conexão com banco de dados: " + ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Falha de conexão com banco de dados.", ex);
        }

        return con;
    }

    //=========================================================
    public void desconectar() throws SQLException, Exception {
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na conexão com banco de dados: " + ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Falha na conexão com banco de dados", ex);
        }
    }
}
