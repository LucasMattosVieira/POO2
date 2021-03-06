package main;

import personagem.*;
import escudos.*;
import fabricas.*;
import poderes.*;

public class Principal {
    public static void main(String[] args) {
        Personagem personagem = new Personagem01();
        
        System.out.printf("%f - %s\n", personagem.getEnergia(), personagem.getEstado().getClass().getName());
        personagem.pegaRecompensa(10);
        System.out.printf("%f - %s\n", personagem.getEnergia(), personagem.getEstado().getClass().getName());
        personagem.sofreAtaque(50);
        System.out.printf("%f - %s\n", personagem.getEnergia(), personagem.getEstado().getClass().getName());
        personagem.pegaRecompensa(50);
        System.out.printf("%f - %s\n", personagem.getEnergia(), personagem.getEstado().getClass().getName());
//        personagem.sofreAtaque(50);
//        System.out.printf("%f - %s\n", personagem.getEnergia(), personagem.getEstado().getClass().getName());

        //instancia os escudos
        Escudo escudoAbencoado = new EscudoAbencoado();
        Escudo escudoReforcado = new EscudoReforcado();
        Escudo escudoBrilhante = new EscudoBrilhante();
        
        //encadeia os escudos entre si e o primeiro ao personagem
        escudoAbencoado.setProximaCamada(escudoReforcado);
        escudoReforcado.setProximaCamada(escudoBrilhante);
        escudoBrilhante.setProximaCamada(null);
        personagem.setEscudo(escudoAbencoado);
        
        personagem.sofreAtaque(115);
        System.out.printf("%f - %s\n", personagem.getEnergia(), personagem.getEstado().getClass().getName());
        
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
        // Testes do padrão Decorator
        
        Personagem personagemDecorado = new Personagem02();
        
        System.out.printf("Valor do dano sem ataque decorado: %.2f\n", personagemDecorado.atacar());
        personagemDecorado.setAtaque(new PoderMagia(personagemDecorado.getAtaque()));
        System.out.printf("Valor do dano com ataque decorado por magia: %.2f\n", personagemDecorado.atacar());
        personagemDecorado.setAtaque(new PoderFogo(personagemDecorado.getAtaque()));
        System.out.printf("Valor do dano com ataque decorado por magia e fogo: %.2f\n", personagemDecorado.atacar());
        personagemDecorado.setAtaque(new PoderEletrico(personagemDecorado.getAtaque()));
        System.out.printf("Valor do dano com ataque decorado por magia, fogo e eletricidade: %.2f\n", personagemDecorado.atacar());

        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
        // Testes do padrão Factory

        JogoSimples jogoS = new JogoSimples();
        JogoAvancado jogoA = new JogoAvancado();

        Personagem personagemS1 = jogoS.criarPersonagem();
        Personagem personagemS2 = jogoS.criarPersonagem();

        System.out.printf("Personagem simples 1:\n - %s, %s\n", personagemS1.getClass().getName(), personagemS1.getAtaque().getClass().getName());
        System.out.printf("Personagem simples 2:\n - %s, %s\n", personagemS2.getClass().getName(), personagemS2.getAtaque().getClass().getName());

        Personagem personagemA1 = jogoA.criarPersonagem();
        Personagem personagemA2 = jogoA.criarPersonagem();

        System.out.printf("Personagem avançado 1:\n - %s, ataque: %.2f\n", personagemA1.getClass().getName(), personagemA1.getAtaque().getDano());
        System.out.printf("Personagem avançado 2:\n - %s, ataque: %.2f\n", personagemA2.getClass().getName(), personagemA2.getAtaque().getDano());


        Jogo jogo1 = new JogoSimples();
        Jogo jogo2 = new JogoAvancado();

        System.out.println("\n\nJogo simples:\n");
        jogo1.jogar();
        System.out.println("\n\nJogo avançado:\n");
        jogo2.jogar();

    }
}
