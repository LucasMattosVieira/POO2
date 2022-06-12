package poderes;

import ataque.Ataque;

public abstract class Poder extends Ataque {
    private Ataque ataque;
    
    public Poder(Ataque ataque) {
        this.ataque = ataque;
    }
    
    public double atacar() {
        return ataque.atacar() + super.atacar();
    }
}
