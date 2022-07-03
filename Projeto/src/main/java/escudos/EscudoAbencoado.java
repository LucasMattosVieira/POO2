package escudos;

public class EscudoAbencoado extends Escudo {
    
    public double sofreAtaque(double dano) {
        double danoBloqueado = 0;
        double danoNaoBloqueado = 0;
        
        if (dano <= 100.0) {
            danoBloqueado = dano;
        } else {
            danoBloqueado = 100.0;
            danoNaoBloqueado = dano - 100.0;
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
