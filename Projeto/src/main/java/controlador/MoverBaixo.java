package controlador;

import modelo.Andarilho;

public class MoverBaixo implements Comando {
    
    private Andarilho personagem;

    public MoverBaixo(Andarilho personagem) {
        this.personagem = personagem;
    }

    @Override
    public void executar() {
        personagem.moverBaixo();
    }

}
