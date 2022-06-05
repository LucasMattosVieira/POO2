package personagem;

import pulo.PuloBaixo;
import ataque.AtaqueForte;
import corre.*;

public class Personagem03 extends Personagem{
        
    public Personagem03() {
        setAtaque(new AtaqueForte());
        setPulo(new PuloBaixo());
        setCorre(new CorreRapido());
    }
      
    // Implementa metodos especificos do personagem 3
}
