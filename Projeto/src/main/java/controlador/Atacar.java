package controlador;

import modelo.Andarilho;

public class Atacar implements Comando {

    private Andarilho personagem;
    private Andarilho inimigo;

    public Atacar(Andarilho personagem, Andarilho inimigo) {
        this.personagem = personagem;
        this.inimigo = inimigo;
    }

    @Override
    public void executar() {
        if ((Math.abs(personagem.getX() - inimigo.getX())) <= 5 && (Math.abs(personagem.getY() - inimigo.getY())) <= 5)
            inimigo.sofreAtaque(personagem.atacar());
    }
    
}
