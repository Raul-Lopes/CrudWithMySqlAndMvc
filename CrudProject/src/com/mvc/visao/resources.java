/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.visao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Raul
 */
public class resources {

    public static String dataExtenso() {

        //JLabel rotulo, rotulo2;
        Integer ds, dia, mes, ano;
        Calendar data;
        String diasemana[] = {"Domingo", "Segunda - Feira", "Terça - Feira", "Quarta - Feira", "Quinta - Feira", "Sexta - Feira", "Sábado"};
        String meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        //super("Exemplo de Data");
        //Container tela = getContentPane();
        //tela.setLayout(null);
        /*
         * rotulo = new JLabel(""); rotulo2 = new JLabel("");
         * rotulo.setBounds(20, 30, 280, 20); rotulo2.setBounds(20, 60, 280, 20);
         */
        data = Calendar.getInstance();
        ds = data.get(Calendar.DAY_OF_WEEK);
        dia = data.get(Calendar.DAY_OF_MONTH);
        mes = data.get(Calendar.MONTH);
        ano = data.get(Calendar.YEAR);

        //rotulo.setText("Data: " + ds + " " + dia + "/" + (mes + 1) + "/" + ano);
        //rotulo2.setText("Data: " + diasemana[ds - 1] + ", " + dia + " de " + meses[mes] + " de " + ano);
        //tela.add(rotulo);
        //tela.add(rotulo2);
        //setSize(300, 200);
        //setVisible(true);
        //setLocationRelativeTo(null);
        return diasemana[ds - 1] + ", " + dia + " de " + meses[mes] + " de " + ano;
    }

    //======================================================================
    public static String horaAtual(int modo) {

        DateFormat FORMATO = null;

        if (modo == 0) {
            FORMATO = new SimpleDateFormat("HH:mm");
        }

        if (modo == 1) {
            FORMATO = new SimpleDateFormat("HH:mm:ss");
        }

        if (modo == 3) {
            FORMATO = new SimpleDateFormat("HHmmss");
        }

        if (modo == 4) {
            FORMATO = new SimpleDateFormat("HH mm ss");
        }

        if (modo == 5) {
            FORMATO = new SimpleDateFormat("HH");
        }

        if (modo == 6) {
            FORMATO = new SimpleDateFormat("mm");
        }

        if (modo == 7) {
            FORMATO = new SimpleDateFormat("ss");
        }

        Date date = new Date();
        return FORMATO.format(date).trim();
    }
}
