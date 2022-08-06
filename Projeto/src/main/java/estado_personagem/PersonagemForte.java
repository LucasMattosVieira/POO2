package estado_personagem;

import ataque.AtaqueForte;
import corre.CorreRapido;
import personagem.*;

public class PersonagemForte extends EstadoPersonagem {
    private static PersonagemForte instancia = null;
    
    private PersonagemForte(Personagem personagem) {
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
           this.getPersonagem().setEstado(PersonagemNormal.getInstancia(this.getPersonagem())).verificaEnergia();
        }
    }
    
    public static synchronized PersonagemForte getInstancia(Personagem personagem) {
        if(instancia == null && personagem != null) {
            instancia = new PersonagemForte(personagem);
        } 
        
        if(instancia != null) {
            instancia.getPersonagem().setAtaque(new AtaqueForte());
            instancia.getPersonagem().setCorre(new CorreRapido());
        }
        
        return instancia;
    }
}
