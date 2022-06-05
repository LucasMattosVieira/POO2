package estado_personagem;

import personagem.*;


public abstract class EstadoPersonagem {
    private Personagem personagem;
    private double limiteInferior;
    private double limiteSuperior;
    
    
    public EstadoPersonagem(Personagem personagem) {
        this.setPersonagem(personagem);
        setLimites();
    }

    protected abstract void setLimites();
    
    public void sofreAtaque(double dano){
        this.getPersonagem().setEnergia(this.getPersonagem().getEnergia() - dano);
        this.verificaEnergia();
    }
    
    public void pegaRecompensa(double cura){
        this.getPersonagem().setEnergia(this.getPersonagem().getEnergia() + cura);
        this.verificaEnergia();
    }
    
    protected abstract void verificaEnergia();

    public Personagem getPersonagem() {
        return this.personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
    
    public double getLimiteInferior() {
        return this.limiteInferior;
    }

    public void setLimiteInferior(double limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public double getLimiteSuperior() {
        return this.limiteSuperior;
    }

    public void setLimiteSuperior(double limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }
}
