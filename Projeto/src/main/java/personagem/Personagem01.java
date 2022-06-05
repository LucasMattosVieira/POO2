package personagem;

import pulo.PuloMedio;
import ataque.AtaqueForte;
import corre.*;

public class Personagem01 extends Personagem{
    
    public Personagem01() {
        setAtaque(new AtaqueForte());
        setPulo(new PuloMedio());
        setCorre(new CorreMedio());
    }
      
    // Implementa metodos especificos do personagem 1
}
