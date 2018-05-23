/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controle;

import com.mvc.modelos.ClientesBean;
import com.mvc.modelos.ClientesDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raul
 */
public class Controle {

    //Aqui vc adiciona todos os metodos cliado nas classes "bean". 
    //Essa a classe de vinculo com a camada de dados e a camada de 
    //telas de visualizacoes ela é a camada do meio do MVC.
    ClientesDAO clientesDAO = new ClientesDAO();

    public ClientesBean inserir(ClientesBean obj) throws SQLException, ClassNotFoundException, IOException, Exception {
        return clientesDAO.inserir(obj);
    }

    public ClientesBean alterar(ClientesBean obj) throws SQLException, ClassNotFoundException, IOException, Exception {
        return clientesDAO.alterar(obj);
    }

    public ClientesBean apagar(ClientesBean obj) throws SQLException, ClassNotFoundException, IOException, Exception {
        return clientesDAO.apagar(obj);
    }

    public ClientesBean listarClienteId(int id) throws SQLException, ClassNotFoundException, IOException, Exception {
        return clientesDAO.listarClienteId(id);
    }

    public List<ClientesBean> tabelaClientes() throws SQLException, ClassNotFoundException, IOException, Exception {
        return clientesDAO.tabelaClientes();
    }

}
