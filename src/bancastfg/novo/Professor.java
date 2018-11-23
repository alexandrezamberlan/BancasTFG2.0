package bancastfg.novo;

import java.util.ArrayList;

public class Professor {
    private String nome;
    private ArrayList<Restricao> listaRestricoes;

    public Professor(String nome) {
        this.nome = nome;
        listaRestricoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Restricao> getListaRestricoes() {
        return listaRestricoes;
    }

    public void setListaRestricoes(ArrayList<Restricao> listaRestricoes) {
        this.listaRestricoes = listaRestricoes;
    }
    
    public void addRestricao(Restricao r){
        listaRestricoes.add(r);
    }
    
}
