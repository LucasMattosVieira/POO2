package estado_personagem;

import ataque.AtaqueForte;
import corre.CorreRapido;
import personagem.*;

public class PersonagemForte extends EstadoPersonagem {
    public PersonagemForte(Personagem personagem) {
        super(personagem);
        
        this.getPersonagem().setAtaque(new AtaqueForte());
        this.getPersonagem().setCorre(new CorreRapido());
    }
    
    @Override
    protected void setLimites() {
        this.setLimiteInferior(70.0);
        this.setLimiteSuperior(100.0);
    }

    @Override
    protected void verificaEnergia() {
        if(this.getPersonagem().getEnergia() <= 70.0) {
           this.getPersonagem().setEstado(new PersonagemNormal(this.getPersonagem())).verificaEnergia();
        }
    }
}
