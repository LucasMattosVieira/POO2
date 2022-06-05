package escudos;

public class EscudoReforcado extends Escudo {
    
    public double sofreAtaque(double dano) {
        double danoBloqueado;
        double danoNaoBloqueado = 0;
        
        if (dano < 10.0) {
            danoBloqueado = dano;
        } else {
            danoBloqueado = 10.0;
            danoNaoBloqueado = dano - 10.0;
        }
            
        System.out.println("Escudo Reforçado absorveu "+danoBloqueado+" de dano.");
        
        if (danoNaoBloqueado > 0 && getProximaCamada() != null) {
            return getProximaCamada().sofreAtaque(danoNaoBloqueado);
        }
        
        if (danoNaoBloqueado > 0 && getProximaCamada() == null) {
            return danoNaoBloqueado;
        }
        
        return 0.0;
    }
    
}
