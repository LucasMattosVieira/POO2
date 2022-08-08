package fases;

import personagem.*;

public class DungeonExplorer implements Runnable {
    private Personagem p;
    private Labirinto l;
    
    public DungeonExplorer(Labirinto l, Personagem p) {
        this.l = l;
        this.p = p;
    }

    @Override
    public void run() {
        l.jogar(p);
    }
 }
