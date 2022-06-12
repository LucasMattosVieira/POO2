package poderes;

import ataque.Ataque;

public class PoderFogo extends Poder {
    public PoderFogo(Ataque ataque) {
        super(ataque);
        this.setDano(12.0);
    }
}