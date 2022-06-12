package poderes;

import ataque.Ataque;

public class PoderEletrico extends Poder {
    public PoderEletrico(Ataque ataque) {
        super(ataque);
        this.setDano(16.0);
    }
}
