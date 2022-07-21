package personagem;

import ataque.AtaqueFraco;
import pulo.PuloBaixo;
import corre.CorreDevagar;

public class Personagem04 extends Personagem{
    
    public Personagem04() {
        setAtaque(new AtaqueFraco());
        setPulo(new PuloBaixo());
        setCorre(new CorreDevagar());
    }
      
    // Implementa metodos especificos do personagem 4

}
