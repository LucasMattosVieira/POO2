package estado_personagem;

import ataque.AtaqueFraco;
import corre.CorreMedio;
import personagem.*;

public class PersonagemEmPerigo extends EstadoPersonagem {
    private static PersonagemEmPerigo instancia = null;
    
    private PersonagemEmPerigo(Personagem personagem) {
        super(personagem);
    }
    
    @Override
    protected void setLimites() {
        this.setLimiteInferior(0.0);
        this.setLimiteSuperior(30.0);
    }

    @Override
    protected void verificaEnergia() {
        if(this.getPersonagem().getEnergia() <= 0.0) {
           this.getPersonagem().setEstado(PersonagemMorto.getInstancia(this.getPersonagem())).verificaEnergia(); 
        } else if(this.getPersonagem().getEnergia() >= 30.0) {
           this.getPersonagem().setEstado(PersonagemNormal.getInstancia(this.getPersonagem())).verificaEnergia(); 
        }
    }
    
    public static synchronized PersonagemEmPerigo getInstancia(Personagem personagem) {
        if(instancia == null && personagem != null) {
            instancia = new PersonagemEmPerigo(personagem);
        } 
        
        if(instancia != null) {
            instancia.getPersonagem().setAtaque(new AtaqueFraco());
            instancia.getPersonagem().setCorre(new CorreMedio());
        }
        
        return instancia;
    }
}
