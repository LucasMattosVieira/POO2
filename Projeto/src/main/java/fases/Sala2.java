package fases;

import java.util.Scanner;

import personagem.Personagem;

public class Sala2 extends Labirinto{
    private Labirinto caminho1;
    private Labirinto caminho2;
    private Personagem inimigo;

    public Sala2(Labirinto caminho1, Labirinto caminho2, Personagem inimigo) {
        this.caminho1 = caminho1;
        this.caminho2 = caminho2;
        this.inimigo = inimigo;
    }

    @Override
    public int selecionarCaminho() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite 1 ou 2 para escolher o caminho a seguir.");
        int c = entrada.nextInt();

        if (c < 1) {
            c = 1;
        }
        if (c > 2) {
            c = 2;
        }
        return c;
    }

    @Override
    public void lutar(Personagem p) {
        System.out.println("--- SALA");
        System.out.println("Personagem: " + p.toString());
        System.out.println("Nível de vida: " + p.getEnergia());
        System.out.println("Inimigo: " + inimigo.toString());
        
        int valor = (int) (Math.random()*10 + 1);
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite um inteiro de 1 a 10.");
        int lido = entrada.nextInt();

        if (lido < 1) {
            lido = 1;
        }
        if (lido > 10) {
            lido = 10;
        }

        if (lido == valor) {
            inimigo.sofreAtaque(inimigo.getEnergia());
            System.out.println("Inimigo derrotado! Jogador não sofreu dano!");
        } else {
            inimigo.sofreAtaque((double) lido);
            p.sofreAtaque(Math.floor(Math.random()*10 + 1));
        }

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
