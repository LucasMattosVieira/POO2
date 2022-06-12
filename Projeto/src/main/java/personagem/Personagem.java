package personagem;

import pulo.*;
import ataque.*;
import corre.*;
import estado_personagem.*;
import escudos.*;

public abstract class Personagem {
    private Ataque ataque;
    private Pulo pulo;
    private Corre corre;
    private EstadoPersonagem estado;
    private double energia;
    private Escudo escudo;
    
    public Personagem() {
        this.setEnergia(70.0);
        this.setEstado(new PersonagemNormal(this));
    }
    
    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }
    
    public Ataque getAtaque() {
        return this.ataque;
    }

    public void setPulo(Pulo pulo) {
        this.pulo = pulo;
    }

    public void setCorre(Corre corre) {
        this.corre = corre;
    }
    
    public void setEnergia(double energia) {
        this.energia = energia > 0.0 ? (energia <= 100.0 ? energia : 100.0) : 0.0;
    }
    
    public double getEnergia() {
        return energia;
    }
    
    public EstadoPersonagem getEstado() {
        return this.estado;
    }

    public EstadoPersonagem setEstado(EstadoPersonagem estado) {
        this.estado = estado;
        return this.estado;
    }

    public double atacar() {
        return this.ataque.atacar();
    }
    
    public void pular() {
        this.pulo.pular();
    }

    public void correr() {
        this.corre.correr();
    }
    
    public void sofreAtaque(double dano) {
        double danoNaoBloqueado = dano;
        
        if (this.getEscudo() != null) {
            danoNaoBloqueado = this.getEscudo().sofreAtaque(danoNaoBloqueado);
        }
        
        this.getEstado().sofreAtaque(danoNaoBloqueado);
    }
    
    public void pegaRecompensa(double cura) {
        this.getEstado().pegaRecompensa(cura);
    }
    
    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }
    
    public Escudo getEscudo() {
        return this.escudo;
    } 
}
