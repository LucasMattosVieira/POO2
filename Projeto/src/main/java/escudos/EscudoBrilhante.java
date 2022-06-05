package escudos;

public class EscudoBrilhante extends Escudo {
    
    public double sofreAtaque(double dano) {
        double danoBloqueado;
        double danoNaoBloqueado = 0;
        
        if (dano < 1.0) {
            danoBloqueado = dano;
        } else {
            danoBloqueado = 1.0;
            danoNaoBloqueado = dano - 1.0;
        }
            
        System.out.println("Escudo Abençoado absorveu "+danoBloqueado+" de dano.");
        
        if (danoNaoBloqueado > 0 && getProximaCamada() != null) {
            return getProximaCamada().sofreAtaque(danoNaoBloqueado);
        }
        
        if (danoNaoBloqueado > 0 && getProximaCamada() == null) {
            return danoNaoBloqueado;
        }
        
        return 0.0;
    }
    
}
