package fabricas;

import estado_personagem.PersonagemMorto;
import personagem.Personagem;

public abstract class Jogo {
    public abstract Personagem criarPersonagem();

    public void jogar() {
        
        Personagem jogador = criarPersonagem();
        Personagem inimigo = criarPersonagem();

        int contador = 0;

        while(contador < 20) {

            inimigo.sofreAtaque(jogador.atacar());
            System.out.printf(" -> Jogador atacou o inimigo! %.2f de dano!\n",jogador.atacar());
            if (inimigo.getEstado() instanceof PersonagemMorto) {
                System.out.printf("\n -- O inimigo foi derrotado! -- \n -- Vitória! -- \n");
                return;
            }

            jogador.sofreAtaque(inimigo.atacar());
            System.out.printf(" -> Jogador sofreu um ataque! %.2f de dano!\n",inimigo.atacar());
            if (jogador.getEstado() instanceof PersonagemMorto) {
                System.out.printf("\n -- O jogador foi derrotado! -- \n -- GAME OVER -- \n");
                return;
            }

            double x1 = Math.random();
            double x2 = Math.random();

            if (x1 <= 0.5) {
                jogador.pegaRecompensa(20.0);
                System.out.printf(" -> Jogador se curou! 20.0 pontos de vida recuperados!\n");
            }

            if (x2 <= 0.3) {
                inimigo.pegaRecompensa(15.0);
                System.out.printf(" -> Inimigo se curou! 15.0 pontos de vida recuperados!\n");
            }

            contador++;
        }
        System.out.printf("\n -- Empate -- \n");
    }
}
