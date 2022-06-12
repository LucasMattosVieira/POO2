package main;

import personagem.*;
import escudos.*;
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
    }
}
