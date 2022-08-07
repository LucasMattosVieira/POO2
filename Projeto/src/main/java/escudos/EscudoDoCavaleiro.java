package escudos;

public class EscudoDoCavaleiro extends Escudo{

    public double sofreAtaque(double dano) {
        double danoBloqueado = 0;
        double danoNaoBloqueado = 0;
        
        if (dano <= 60.0) {
            danoBloqueado = dano;
        } else {
            danoBloqueado = 60.0;
            danoNaoBloqueado = dano - 60.0;
        }
            
        System.out.println("Escudo do Cavaleiro absorveu "+danoBloqueado+" de dano.");
        
        if (danoNaoBloqueado > 0 && getProximaCamada() != null) {
            return getProximaCamada().sofreAtaque(danoNaoBloqueado);
        }
        
        if (danoNaoBloqueado > 0 && getProximaCamada() == null) {
            return danoNaoBloqueado;
        }
        return 0;
    }
    
}
