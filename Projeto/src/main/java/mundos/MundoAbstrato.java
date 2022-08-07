package mundos;

import personagem.Personagem;

public abstract class MundoAbstrato {
    
    public abstract Personagem criarPersonagem();

    public abstract void criarDefesa(Personagem p);

}
