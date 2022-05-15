package personagens;

import corre.*;
import pulos.*;
import ataques.*;

public abstract class Personagem {

    private Ataque a;
    private Pulo p;
    private Corre c;
    
    public Personagem() {
        
    }
    
    public void setAtaque(Ataque a) {
        this.a = a;
    }

    public void setPulo(Pulo p) {
        this.p = p;
    }

    public void setCorre(Corre c) {
        this.c = c;
    }

    public void atacar() {
        a.atacar();
    }
    
    public void pular() {
        p.pular();
    }

    public void correr() {
        c.correr();
    }
}
