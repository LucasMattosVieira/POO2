package personagens;

import corre.*;
import pulos.*;
import ataques.*;

public class Personagem02 extends Personagem{
        
    public Personagem02() {
        setAtaque(new AtaqueMedio());
        setPulo(new PuloAlto());
        setCorre(new CorreRapido());
    }
      
    // implementa metodos especificos do personagem 2
}
