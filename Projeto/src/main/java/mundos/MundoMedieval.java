package mundos;

import escudos.Escudo;
import escudos.EscudoDoCavaleiro;
import personagem.Arqueiro;
import personagem.Personagem;

public class MundoMedieval extends MundoAbstrato{

    private static MundoMedieval instancia = null;

    private MundoMedieval() {
        super();
    }

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
    
    public static synchronized MundoMedieval getInstancia() {
        if(instancia == null) {
            instancia = new MundoMedieval();
        }  
        return instancia;
    }

}
