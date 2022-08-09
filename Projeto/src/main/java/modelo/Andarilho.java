package modelo;

import java.util.ArrayList;

import ataque.AtaqueMedio;
import generico.Observador;
import personagem.Personagem;

public class Andarilho extends Personagem implements Observador {
    private int x;
    private int y;

    private ArrayList<Observador> lista = new ArrayList<Observador>();

    public Andarilho(int x, int y) {
        this.x = x;
        this.y = y;
        setAtaque(new AtaqueMedio());
    }

    public void atualizaPosicao(int x, int y) {
        if (x < 0) {this.x = 0;}
        else if (x > 700) {this.x = 680;}
        else {this.x = x;}
        
        if (y < 0) {this.y = 0;}
        else if (y > 700) {this.y = 680;}
        else {this.y = y;}
    }

    public void observar(Observador o) {
        lista.add(o);
    }

    public void deixarDeObservar(Observador o) {
        lista.remove(o);
    }

    public void notificar() {
        for (Observador o: lista) {
            o.atualizar(this);
        }
    }

    public void atualizar(Andarilho a) {
        if ((Math.abs(this.x - a.getX()) <= 5) && (Math.abs(this.y - a.getY()) <= 5)) {
            a.sofreAtaque(this.atacar());
        } else {
            if (a.getX() > this.x) 
            this.x = this.x+1;
            else if (a.getX() < this.x) this.x = this.x-1;

            if (a.getY() > this.y) 
            this.y = this.y+1;
            else if (a.getY() < this.y) this.y = this.y-1;
        }
    }

    public void moverEsquerda() {
        atualizaPosicao(getX()-10, getY());
    }

    public void moverDireita() {
        atualizaPosicao(getX()+10, getY());
    }

    public void moverCima() {
        atualizaPosicao(getX(), getY()-10);
    }

    public void moverBaixo() {
        atualizaPosicao(getX(), getY()+10);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}