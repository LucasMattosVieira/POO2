package fases;

import personagem.*;

public class Sala1 extends Labirinto {
    private Labirinto caminho1;
    private Labirinto caminho2;
    private Personagem inimigo;
    
    public Sala1(Labirinto caminho1, Labirinto caminho2, Personagem inimigo) {
        this.caminho1 = caminho1;
        this.caminho2 = caminho2;
        this.inimigo = inimigo;
    }

    @Override
    public int selecionarCaminho() {
        if(Math.random() > 0.5) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public void lutar(Personagem p) {
        System.out.println("--- SALA");
        System.out.println("Personagem: " + p.toString());
        System.out.println("Nível de vida: " + p.getEnergia());
        System.out.println("Inimigo: " + inimigo.toString());
        
        inimigo.sofreAtaque(Math.floor(Math.random()*10 + 1));
        p.sofreAtaque(Math.floor(Math.random()*10 + 1));

        if(p.getEnergia() > 0) { 
            int c = selecionarCaminho();
            if(c == 1) {
                caminho1.jogar(p);
            } else if(c == 2) {
                caminho2.jogar(p);
            }
        } else {
            System.out.println("Personagem morreu lutando bravamente.");
            System.out.println("--- FIM DE JOGO");
        }
    }

    public Labirinto getCaminho1() {
        return caminho1;
    }

    public Labirinto getCaminho2() {
        return caminho2;
    }

    public Personagem getInimigo() {
        return inimigo;
    }
}
