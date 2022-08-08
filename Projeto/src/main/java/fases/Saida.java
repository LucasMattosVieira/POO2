package fases;

import personagem.*;

public class Saida extends Labirinto {

    @Override
    public int selecionarCaminho() {    
        return 0;
    }

    @Override
    public void lutar(Personagem p) {
        System.out.println("--- SAÍDA");
        System.out.println("Personagem: " + p.toString());
        System.out.println("Nível de vida: " + p.getEnergia()); 
        System.out.println("--- FIM DE JOGO");
    }
}
