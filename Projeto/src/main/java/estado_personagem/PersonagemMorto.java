package estado_personagem;

import personagem.*;

public class PersonagemMorto extends EstadoPersonagem {
    private static PersonagemMorto instancia = null;
    
    private PersonagemMorto(Personagem personagem) {
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
           this.getPersonagem().setEstado(PersonagemEmPerigo.getInstancia(this.getPersonagem())).verificaEnergia();
        }
    }
    
    public static synchronized PersonagemMorto getInstancia(Personagem personagem) {
        if(instancia == null && personagem != null) {
            instancia = new PersonagemMorto(personagem);
        }
        
        return instancia;
    }
}
