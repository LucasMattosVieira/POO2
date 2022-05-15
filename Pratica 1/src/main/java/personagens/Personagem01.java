package personagens;

import corre.*;
import pulos.*;
import ataques.*;

public class Personagem01 extends Personagem{
    
    public Personagem01() {
        setAtaque(new AtaqueForte());
        setPulo(new PuloMedio());
        setCorre(new CorreMedio());
    }
      
    // implementa metodos especificos do personagem 1
}
