package personagem;

import ataque.AtaqueForte;
import corre.CorreRapido;
import pulo.PuloAlto;

public class Personagem05 extends Personagem{
    
    public Personagem05() {
        setAtaque(new AtaqueForte());
        setPulo(new PuloAlto());
        setCorre(new CorreRapido());
    }
      
    // Implementa metodos especificos do personagem 5
}
