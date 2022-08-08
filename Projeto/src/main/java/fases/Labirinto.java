package fases;

import personagem.*;

public abstract class Labirinto {
    public final void jogar(Personagem p) {
        lutar(p);
    }

    public abstract int selecionarCaminho();
    public abstract void lutar(Personagem p);
}
