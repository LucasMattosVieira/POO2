package estado_personagem;

import ataque.AtaqueMedio;
import corre.CorreMedio;
import personagem.*;

public class PersonagemNormal extends EstadoPersonagem {
    public PersonagemNormal(Personagem personagem) {
        super(personagem);
        
        this.getPersonagem().setAtaque(new AtaqueMedio());
        this.getPersonagem().setCorre(new CorreMedio());
    }
    
    @Override
    protected void setLimites() {
        this.setLimiteInferior(30.0);
        this.setLimiteSuperior(70.0);
    }

    @Override
    protected void verificaEnergia() {
        if(this.getPersonagem().getEnergia() < 30.0) {
            this.getPersonagem().setEstado(new PersonagemEmPerigo(this.getPersonagem())).verificaEnergia();
        } else if(this.getPersonagem().getEnergia() > 70.0) {
            // Não precisa, de fato, chamar `verificaEnergia()` pois não há mais "estados superiores"
            this.getPersonagem().setEstado(new PersonagemForte(this.getPersonagem()));
        }
    }
}
