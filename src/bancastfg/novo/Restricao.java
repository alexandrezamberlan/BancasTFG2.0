package bancastfg.novo;

public class Restricao {
    
    private int dia, hora;

    public Restricao(int dia, int hora) {
        this.dia = dia;
        this.hora = hora;
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
    
}
