package controlador;

import modelo.Andarilho;

public class MoverDireita implements Comando {
    
    private Andarilho personagem;

    public MoverDireita(Andarilho personagem) {
        this.personagem = personagem;
    }

    @Override
    public void executar() {
        personagem.moverDireita();
    }

}
