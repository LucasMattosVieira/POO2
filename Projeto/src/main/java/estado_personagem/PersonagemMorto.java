package estado_personagem;

import personagem.*;

public class PersonagemMorto extends EstadoPersonagem {
    public PersonagemMorto(Personagem personagem) {
        super(personagem);
    }
    
    @Override
    protected void setLimites() {
        this.setLimiteInferior(0.0);
        this.setLimiteSuperior(0.0);
    }

    @Override
    protected void verificaEnergia() {
        if(this.getPersonagem().getEnergia() > 0.0) {
           this.getPersonagem().setEstado(new PersonagemEmPerigo(this.getPersonagem())).verificaEnergia();
        }
    }
}
