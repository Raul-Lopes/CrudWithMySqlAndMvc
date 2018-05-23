/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.visao;

import com.mvc.controle.Controle;
import com.mvc.modelos.ClientesBean;
import java.util.List;

/**
 *
 * @author Raul
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ClientesBean clienteBean;
        Controle controle = new Controle();

        try {

            List<ClientesBean> lista;

            //Limpar o banco primeiro, caso haja registros
            lista = controle.tabelaClientes();
            if (lista != null && !lista.isEmpty()) {
                for (ClientesBean o : lista) {
                    controle.apagar(o);
                }
            }

            System.out.println("Registros inseridos ----------------------------------");
            //novos cadastros de registros
            clienteBean = new ClientesBean();
            clienteBean.setNome("Alisan Silver");
            clienteBean.setCpf("981.896.290-77");
            clienteBean.setEndereco("Rua Amazonas, 90");
            clienteBean.setBairro("Eugenia");
            clienteBean.setCidade("Moema");
            clienteBean.setEstado("MG");
            controle.inserir(clienteBean);

            clienteBean = new ClientesBean();
            clienteBean.setNome("Monica Silver");
            clienteBean.setCpf("896.081.280-30");
            clienteBean.setEndereco("Rua Santos, 90");
            clienteBean.setBairro("Eugenia");
            clienteBean.setCidade("Arcos");
            clienteBean.setEstado("MG");
            controle.inserir(clienteBean);

            clienteBean = new ClientesBean();
            clienteBean.setNome("Joao Silver");
            clienteBean.setCpf("571.566.940-57");
            clienteBean.setEndereco("Rua Sao Paulo, 90");
            clienteBean.setBairro("Eugenia");
            clienteBean.setCidade("Brasilia");
            clienteBean.setEstado("MG");
            controle.inserir(clienteBean);

            //----------------------------
            //lista registros cadastrados
            lista = controle.tabelaClientes();
            lista.forEach(item -> System.out.println(item));

            for (int i = 0; i < lista.size(); i++) {
                lista.get(i).setNome("Novo Nome Cliente " + i);
                controle.alterar(lista.get(i));
            }

            System.out.println("Registros alterados ----------------------------------");
            lista.forEach(item -> System.out.println(item));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //VisualizacaoClientes a = new VisualizacaoClientes();
        //a.setVisible(true);
    }

}
