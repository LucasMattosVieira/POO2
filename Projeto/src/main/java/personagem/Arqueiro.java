package personagem;

import ataque.AtaqueFraco;
import corre.CorreRapido;
import pulo.PuloAlto;

public class Arqueiro extends Personagem{
    
    public Arqueiro() {
        setAtaque(new AtaqueFraco());
        setCorre(new CorreRapido());
        setPulo(new PuloAlto());
    }

}
