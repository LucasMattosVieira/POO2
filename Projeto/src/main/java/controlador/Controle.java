package controlador;

public class Controle {
    private Comando[] c = new Comando[10];

    public void addComando(Comando c, int i){
        this.c[i] = c;
    }
    
    public void pressionar(int i){
        this.c[i].executar();
    }
    
    public void executar(Comando c){
        c.executar();
    }  
}
