package main;

import personagem.*;
import escudos.*;
import fabricas.*;
import fases.*;
import mundos.*;
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

        JogoSimples jogoS = JogoSimples.getInstancia();
        JogoAvancado jogoA = JogoAvancado.getInstancia();

        Personagem personagemS1 = jogoS.criarPersonagem();
        Personagem personagemS2 = jogoS.criarPersonagem();

        System.out.printf("Personagem simples 1:\n - %s, %s\n", personagemS1.getClass().getName(), personagemS1.getAtaque().getClass().getName());
        System.out.printf("Personagem simples 2:\n - %s, %s\n", personagemS2.getClass().getName(), personagemS2.getAtaque().getClass().getName());

        Personagem personagemA1 = jogoA.criarPersonagem();
        Personagem personagemA2 = jogoA.criarPersonagem();

        System.out.printf("Personagem avançado 1:\n - %s, ataque: %.2f\n", personagemA1.getClass().getName(), personagemA1.getAtaque().getDano());
        System.out.printf("Personagem avançado 2:\n - %s, ataque: %.2f\n", personagemA2.getClass().getName(), personagemA2.getAtaque().getDano());


        Jogo jogo1 = JogoSimples.getInstancia();
        Jogo jogo2 = JogoAvancado.getInstancia();

        System.out.println("\n\nJogo simples:\n");
        jogo1.jogar();
        System.out.println("\n\nJogo avançado:\n");
        jogo2.jogar();

        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
        // Testes do padrão Abstract Factory
        MundoAbstrato mundo1 = MundoMedieval.getInstancia();
        MundoAbstrato mundo2 = MundoFuturista.getInstancia();

        Personagem arqueiro = mundo1.criarPersonagem();
        mundo1.criarDefesa(arqueiro);

        Personagem robo = mundo2.criarPersonagem();
        mundo2.criarDefesa(robo);

        System.out.printf("\n\nMundo Medieval:\n - %s, escudo: %s\n", arqueiro.getClass().getName(), arqueiro.getEscudo().getClass().getName());
        System.out.printf("Mundo Futurista:\n - %s, escudo: %s\n", robo.getClass().getName(), robo.getEscudo().getClass().getName());
    
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
        // Testes dos padrões Composite e Template Method
        System.out.println("\n\n");
        
        Personagem heroi = new Robo();
        Personagem inimigo1 = new Personagem02();
        Personagem inimigo2 = new Personagem04();
        Personagem inimigo3 = new Arqueiro();
        
        Saida saida = new Saida();
        Abismo abismo = new Abismo();
        
        Sala1 sala1 = new Sala1(saida, abismo, inimigo3);
        Sala1 sala2 = new Sala1(sala1, abismo, inimigo1);
        Sala1 sala3 = new Sala1(sala2, sala1, inimigo2);
        
        System.out.println("--- ENTRANDO NO LABIRINTO 1");
        
        sala3.jogar(heroi);


        System.out.println("\n\n");

        Personagem vision = new Robo();
        Personagem ultron_minion_1 = new Robo();
        Personagem ultron_minion_2 = new Robo();
        Personagem ultron_minion_3 = new Robo();

        Sala2 room1 = new Sala2(abismo, saida, ultron_minion_1);
        Sala2 room2 = new Sala2(room1, saida, ultron_minion_2);
        Sala2 room3 = new Sala2(room1, room2, ultron_minion_3);

        System.out.println("--- ENTRANDO NO LABIRINTO 2");

        room3.jogar(vision);
        
        //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
        // Testes em relação a Threads
        System.out.println("\n\n");
        
        System.out.println("--- INÍCIO DO JOGO"); 
        
        Personagem frodo = new Personagem01();
        Personagem sam = new Personagem02();
        Personagem anao = new Personagem03();
        Personagem elfo = new Personagem04();
        Personagem gandalf = new Personagem05();
        
        Thread t1 = new Thread(new DungeonExplorer(sala3, frodo));
        Thread t2 = new Thread(new DungeonExplorer(sala3, sam));
        Thread t3 = new Thread(new DungeonExplorer(sala3, anao));
        Thread t4 = new Thread(new DungeonExplorer(sala3, elfo));
        Thread t5 = new Thread(new DungeonExplorer(sala3, gandalf));
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch(Exception e) {
            System.out.println("Algo de errado não está certo...");
        }

        System.out.println("--- FIM DO JOGO, TODOS OS PERSONAGENS TERMINARAM");    
    }
}
