package escudos;

public abstract class Escudo {
    
    private Escudo proximaCamada;
    
    public void setProximaCamada(Escudo proximaCamada) {
        this.proximaCamada = proximaCamada;
    }
    
    public Escudo getProximaCamada() {
        return this.proximaCamada;
    }
        
    public abstract double sofreAtaque(double dano);
    
}
