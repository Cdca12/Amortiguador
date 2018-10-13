package amortiguador;

/**
 *
 * @author Carlos Contreras
 */
public class Pila<T> {

    private int tope, max;
    private T[] P;
    public T DR;

    public Pila() {
        this(10);
    }

    public Pila(int max) {
        this.max = max;
        tope = -1;
        P = (T[]) new Object[max];
    }

    public boolean inserta(T dato) {
        if(llena())
            return false;
        tope++;
        P[tope] = dato; // P[++tope] = dato;
        return true;
    }
    
    public boolean retira() {
       if(vacia())
           return false;
       DR = P[tope];
       P[tope] = null; // DR = P[--tope];
       tope--;
       return true;
    }
    
    public boolean vacia() {
        return tope == -1;
    }

    public boolean llena() {
        return tope == max - 1;
    }

}
