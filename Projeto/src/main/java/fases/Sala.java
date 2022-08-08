package fases;

import personagem.*;

public class Sala implements Labirinto {
    private Labirinto caminho1;
    private Labirinto caminho2;
    private Personagem inimigo;
    
    public Sala(Labirinto caminho1, Labirinto caminho2, Personagem inimigo) {
        this.caminho1 = caminho1;
        this.caminho2 = caminho2;
        this.inimigo = inimigo;
    }
    
    @Override
    public void jogar(Personagem p) {
        System.out.println("--- SALA");
        System.out.println("Personagem: " + p.toString());
        System.out.println("Nível de vida: " + p.getEnergia());
        System.out.println("Inimigo: " + inimigo.toString());
        
        while(inimigo.getEnergia() != 0 && p.getEnergia() != 0) {
            if(Math.random() > 0.2) {
                inimigo.sofreAtaque(p.atacar());
            }
            
            if(Math.random() > 0.8) {
                p.sofreAtaque(inimigo.atacar());
            }
        }
        
        if(p.getEnergia() > 0) { 
            if(Math.random() > 0.5) {
                caminho2.jogar(p);
            } else {
                caminho1.jogar(p);
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
