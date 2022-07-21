package fabricas;

import personagem.*;
import poderes.*;

public class JogoAvancado extends Jogo{
    
    public Personagem criarPersonagem() {

        Personagem p = null;

        double n = Math.random();

        if (n <= 0.2) {
            p = new Personagem01();
        } else if (n <= 0.4) {
            p = new Personagem02();
        } else if (n <= 0.6) {
            p = new Personagem03();
        } else if (n <= 0.8) {
            p = new Personagem04();
        } else {
            p = new Personagem05();
        }

        double x = Math.random();

        if (x <= 0.4) {
            p.setAtaque(new PoderFogo(p.getAtaque()));
        } else if (x <= 0.7) {
            p.setAtaque(new PoderEletrico(p.getAtaque()));
        } else {
            p.setAtaque(new PoderMagia(p.getAtaque()));
        }

        return p;

    }

}
