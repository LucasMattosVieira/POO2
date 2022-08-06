package estado_personagem;

import ataque.AtaqueMedio;
import corre.CorreMedio;
import personagem.*;

public class PersonagemNormal extends EstadoPersonagem {
    private static PersonagemNormal instancia = null;
    
    private PersonagemNormal(Personagem personagem) {
        super(personagem);
    }
    
    @Override
    protected void setLimites() {
        this.setLimiteInferior(30.0);
        this.setLimiteSuperior(70.0);
    }

    @Override
    protected void verificaEnergia() {
        if(this.getPersonagem().getEnergia() < 30.0) {
            this.getPersonagem().setEstado(PersonagemEmPerigo.getInstancia(this.getPersonagem())).verificaEnergia();
        } else if(this.getPersonagem().getEnergia() > 70.0) {
            // Não precisa, de fato, chamar `verificaEnergia()` pois não há mais "estados superiores"
            this.getPersonagem().setEstado(PersonagemForte.getInstancia(this.getPersonagem()));
        }
    }
    
    public static synchronized PersonagemNormal getInstancia(Personagem personagem) {
        if(instancia == null && personagem != null) {
            instancia = new PersonagemNormal(personagem);
        }
        
        if(instancia != null) {
            instancia.getPersonagem().setAtaque(new AtaqueMedio());
            instancia.getPersonagem().setCorre(new CorreMedio());
        }
        
        return instancia;
    }
}
