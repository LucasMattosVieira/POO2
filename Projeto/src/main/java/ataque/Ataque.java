package ataque;

public abstract class Ataque {
    private double dano;
    
    public Ataque() {
        setDano(0.0);
    }
    
    public double atacar() {
        return dano;
    }

    public double getDano() {
        return dano;
    }

    public void setDano(double dano) {
        this.dano = dano;
    }
}
