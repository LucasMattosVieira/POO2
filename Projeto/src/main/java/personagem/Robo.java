package personagem;

import ataque.AtaqueForte;
import corre.CorreMedio;
import pulo.PuloBaixo;

public class Robo extends Personagem{
    
    public Robo() {
        setAtaque(new AtaqueForte());
        setCorre(new CorreMedio());
        setPulo(new PuloBaixo());
    }

}
