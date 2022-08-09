package controlador;

import modelo.Andarilho;

public class MoverEsquerda implements Comando {
    
    private Andarilho personagem;

    public MoverEsquerda(Andarilho personagem) {
        this.personagem = personagem;
    }

    @Override
    public void executar() {
        personagem.moverEsquerda();
    }

}
