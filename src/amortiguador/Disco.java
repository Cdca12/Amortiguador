package amortiguador;

import java.util.Random;

/**
 *
 * @author Carlos Contreras
 */
public class Disco {
    public int numeroDisco;
    public int vidaUtilInicial;
    public double vidaUtil;
    
    public Disco(int numeroDisco) {
        this.numeroDisco = numeroDisco;
        this.vidaUtilInicial = new Random().nextInt(5) + 95;
        this.vidaUtil = vidaUtilInicial;
    }

    public String toString() {
        return "Número disco: " + numeroDisco 
                + " | Vida útil inicial: " + vidaUtilInicial 
                + " | Vida útil actual: " + vidaUtil;
    }
    
}
