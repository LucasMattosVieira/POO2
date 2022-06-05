package personagem;

import pulo.PuloAlto;
import ataque.AtaqueMedio;
import corre.*;

public class Personagem02 extends Personagem{
        
    public Personagem02() {
        setAtaque(new AtaqueMedio());
        setPulo(new PuloAlto());
        setCorre(new CorreRapido());
    }
      
    // Implementa metodos especificos do personagem 2
}
