package personagens;

import corre.*;
import pulos.*;
import ataques.*;

public class Personagem03 extends Personagem{
        
    public Personagem03() {
        setAtaque(new AtaqueForte());
        setPulo(new PuloBaixo());
        setCorre(new CorreRapido());
    }
      
    // implementa metodos especificos do personagem 3
}
