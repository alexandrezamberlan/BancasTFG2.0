/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancastfg.novo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class Horario implements Comparable<Horario>{

    private int ano,mes,dia,hora;
    private ArrayList<Banca> listaBancas;

    public Horario(int ano, int mes, int dia, int hora) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        listaBancas = new ArrayList<>();
    }

    public String getStrData(){
        return dia+"/"+mes+"/"+ano;
    }
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public ArrayList<Banca> getListaBancas() {
        return listaBancas;
    }

    public void setListaBancas(ArrayList<Banca> listaBancas) {
        this.listaBancas = listaBancas;
    }

    public void addBancaHorario(Banca b) {
        listaBancas.add(b);
    }

    @Override
    public int compareTo(Horario hc) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM:kk");
        int mesComparar = hc.getMes();
        int diaComparar = hc.getDia();
        int horaComparar = hc.getHora();
        try {
            Date dataComparar = format.parse(diaComparar+"/"+mesComparar+":"+horaComparar);
            Date data = format.parse(dia+"/"+mes+":"+hora);
            if(dataComparar.after(data)){
                return -1;
            }
            else if(dataComparar.before(data)){
                return 1;
            }
            else{
                return 0;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Horario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
