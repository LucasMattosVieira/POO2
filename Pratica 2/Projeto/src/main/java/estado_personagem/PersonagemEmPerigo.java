package estado_personagem;

import ataque.AtaqueFraco;
import corre.CorreMedio;
import personagem.*;

public class PersonagemEmPerigo extends EstadoPersonagem {
    public PersonagemEmPerigo(Personagem personagem) {
        super(personagem);
        
        this.getPersonagem().setAtaque(new AtaqueFraco());
        this.getPersonagem().setCorre(new CorreMedio());
    }
    
    @Override
    protected void setLimites() {
        this.setLimiteInferior(0.0);
        this.setLimiteSuperior(30.0);
    }

    @Override
    protected void verificaEnergia() {
        if(this.getPersonagem().getEnergia() <= 0.0) {
           this.getPersonagem().setEstado(new PersonagemMorto(this.getPersonagem())).verificaEnergia(); 
        } else if(this.getPersonagem().getEnergia() >= 30.0) {
           this.getPersonagem().setEstado(new PersonagemNormal(this.getPersonagem())).verificaEnergia(); 
        }
    }
}
