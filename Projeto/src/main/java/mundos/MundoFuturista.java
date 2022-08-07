package mundos;

import escudos.CampoMagnetico;
import escudos.Escudo;
import personagem.Personagem;
import personagem.Robo;

public class MundoFuturista extends MundoAbstrato{

    @Override
    public Personagem criarPersonagem() {
        Personagem p = new Robo();
        return p;
    }

    @Override
    public void criarDefesa(Personagem p) {
        Escudo e = new CampoMagnetico();
        e.setProximaCamada(null);
        p.setEscudo(e);
    }
    
}
