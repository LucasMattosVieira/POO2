package fases;

import personagem.*;

public class Saida implements Labirinto {
    @Override
    public void jogar(Personagem p) {
        System.out.println("--- SAÍDA");
        System.out.println("Personagem: " + p.toString());
        System.out.println("Nível de vida: " + p.getEnergia());
        System.out.println("--- FIM DE JOGO");
    }
}
