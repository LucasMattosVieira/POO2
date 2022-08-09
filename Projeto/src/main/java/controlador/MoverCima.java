package controlador;

import modelo.Andarilho;

public class MoverCima implements Comando {
    
    private Andarilho personagem;

    public MoverCima(Andarilho personagem) {
        this.personagem = personagem;
    }

    @Override
    public void executar() {
        personagem.moverCima();
    }

}
