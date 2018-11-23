/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancastfg.novo;

import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class Banca implements Comparable<Banca> {

    private ArrayList<Restricao> listaRestricoes;
    private ArrayList<Professor> listaProfessores;
    private String aluno;
    private String sala;

    public Banca() {
        listaRestricoes = new ArrayList<>();
        listaProfessores = new ArrayList<>();
        aluno = null;
        sala = null;
    }

    public ArrayList<Restricao> getListaRestricoes() {
        return listaRestricoes;
    }

    public void setListaRestricoes(ArrayList<Restricao> listaRestricoes) {
        this.listaRestricoes = listaRestricoes;
    }

    public ArrayList<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public void setListaProfessores(ArrayList<Professor> listaProfessores) {
        this.listaProfessores = listaProfessores;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void addProfessor(Professor p) {
        listaProfessores.add(p);
    }

    public void addRestricao(Restricao _r) {
        boolean flag = false;
        //antes de adicionar, verifica se essa restrição já não existe na banca
        for (Restricao r : listaRestricoes) {
            if (r.getDia() == _r.getDia() && r.getHora() == _r.getHora()) {
                flag = true;//add break
            }
        }
        if (!flag) {
            listaRestricoes.add(_r);
        }
    }

    //ordena dee forma DECRESCENTE
    public int compareTo(Banca b) {
        int qtdRestricoesComparar = b.getListaRestricoes().size();
        //ascending order
        return qtdRestricoesComparar - this.listaRestricoes.size();
    }
}
