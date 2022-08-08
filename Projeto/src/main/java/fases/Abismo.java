package fases;

import personagem.*;

public class Abismo extends Labirinto {

    @Override
    public int selecionarCaminho() {
        return 0;
    }

    @Override
    public void lutar(Personagem p) {
        System.out.println("--- ABISMO");
        System.out.println("Personagem: " + p.toString());
        System.out.println("Nível de vida: " + p.getEnergia());
        System.out.println("--- FIM DE JOGO");
    }
}
