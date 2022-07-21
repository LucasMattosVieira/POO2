package fabricas;

import personagem.*;

public class JogoSimples extends Jogo{

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

        return p;

    }

}