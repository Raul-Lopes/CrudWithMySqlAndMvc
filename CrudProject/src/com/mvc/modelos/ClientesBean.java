/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.modelos;

import java.util.Objects;

/**
 *
 * @author Raul
 */
public class ClientesBean {

    /*  Estrutura da tabela no banco
        CREATE TABLE `clients` (
          `ID` int(11) NOT NULL AUTO_INCREMENT,
          `NOME` varchar(120) NOT NULL,
          `CPF` varchar(14) NOT NULL,
          `ENDERECO` varchar(150) NOT NULL,
          `BAIRRO` varchar(50) NOT NULL,
          `CIDADE` varchar(50) NOT NULL,
          `ESTADO` varchar(2) NOT NULL,
          PRIMARY KEY (`ID`)
        ) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;  
    */
    
    private Integer id;
    private String nome;
    private String cpf;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;

    @Override
    public String toString() {
        return "ClientesBean{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado+ '}';
    }
        
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.getId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClientesBean other = (ClientesBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the Cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param Cidade the cidade to set
     */
    public void setCidade(String Cidade) {
        this.cidade = Cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

}
