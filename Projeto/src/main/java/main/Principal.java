package main;


import personagem.*;

public class Principal {
    public static void main(String[] args) {
        Personagem personagem = new Personagem01();
        
        System.out.printf("%f - %s\n", personagem.getEnergia(), personagem.getEstado().getClass().getName());
        personagem.pegaRecompensa(10);
        System.out.printf("%f - %s\n", personagem.getEnergia(), personagem.getEstado().getClass().getName());
        personagem.sofreAtaque(50);
        System.out.printf("%f - %s\n", personagem.getEnergia(), personagem.getEstado().getClass().getName());
        personagem.pegaRecompensa(10);
        System.out.printf("%f - %s\n", personagem.getEnergia(), personagem.getEstado().getClass().getName());
        personagem.sofreAtaque(50);
        System.out.printf("%f - %s\n", personagem.getEnergia(), personagem.getEstado().getClass().getName());
    }
}
