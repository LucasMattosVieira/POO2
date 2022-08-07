package mundos;

import escudos.Escudo;
import escudos.EscudoDoCavaleiro;
import personagem.Arqueiro;
import personagem.Personagem;

public class MundoMedieval extends MundoAbstrato{

    @Override
    public Personagem criarPersonagem() {
        Personagem p = new Arqueiro();
        return p;
    }

    @Override
    public void criarDefesa(Personagem p) {
        Escudo e = new EscudoDoCavaleiro();
        e.setProximaCamada(null);
        p.setEscudo(e);  
    }
    
}
