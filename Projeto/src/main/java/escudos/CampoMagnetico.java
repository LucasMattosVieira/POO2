package escudos;

public class CampoMagnetico extends Escudo{

    public double sofreAtaque(double dano) {
        double danoBloqueado = 0;
        double danoNaoBloqueado = 0;
        
        if (dano <= 120.0) {
            danoBloqueado = dano;
        } else {
            danoBloqueado = 120.0;
            danoNaoBloqueado = dano - 120.0;
        }
            
        System.out.println("Campo Magnético absorveu "+danoBloqueado+" de dano.");
        
        if (danoNaoBloqueado > 0 && getProximaCamada() != null) {
            return getProximaCamada().sofreAtaque(danoNaoBloqueado);
        }
        
        if (danoNaoBloqueado > 0 && getProximaCamada() == null) {
            return danoNaoBloqueado;
        }
        return 0;
    }
    
}
