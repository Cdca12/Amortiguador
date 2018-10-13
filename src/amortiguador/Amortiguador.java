package amortiguador;

import java.util.Random;

/**
 *
 * @author Carlos Contreras
 */
public class Amortiguador {

    private Pila<Disco> discos;
    private Pila<Disco> discosAux;
    int contador = 0;
    Disco dato1 = null;
    Disco dato2 = null;
    int numeroDiscos = 0;

    public Amortiguador(int numeroDiscos) {
        this.discos = new Pila(numeroDiscos);
        this.discosAux = new Pila(numeroDiscos);
        this.numeroDiscos = numeroDiscos;
        for (int i = 1; i <= numeroDiscos; discos.inserta(new Disco(i)), i++);
    }

    public Amortiguador() {
        this(new Random().nextInt(35) + 15);
    }

    public void bache() {
        while (!discos.vacia()) {
            // Primer caso, tope
            if (contador == 0) {
                discos.retira();
                contador++;
                desgaste(discos.DR);
                dato1 = discos.DR;
            } // Segundo caso, disco del fondo
            else if (contador == numeroDiscos - 1) {
                discos.retira();
                contador++;
                desgaste(discos.DR);
                dato2 = discos.DR;
            } // Si no es ninguno de esos casos, son los discos del centro. No se desgastan.
            else {
                discos.retira();
                contador++;
                discosAux.inserta(discos.DR);
            }
        }
    }

    public void desgaste(Disco disco) {
        double desgaste = (new Random().nextInt(3) + 1);
        desgaste /= 100;
        disco.vidaUtil = disco.vidaUtil - desgaste;
    }

    public void acomodar() {
        for (int i = 0; i < contador / 2; i++) {
            discosAux.retira();
            discos.inserta(discosAux.DR);
        }
        // Validar que la vida útil inicial sea mayor que 30%
        if (dato2.vidaUtil >= (dato2.vidaUtilInicial * .30)) {
            discos.inserta(dato2);
        } else {
            numeroDiscos--;
        }
        if (dato1.vidaUtil >= (dato1.vidaUtilInicial * .30)) { //30) {
            discos.inserta(dato1);
        } else {
            numeroDiscos--;
        }
        contador = 0;
        // Termino de insertar los datos restantes
        while (discosAux.retira() && discos.inserta(discosAux.DR));
    }

    public void mostrarDatos(int numeroBache) {
        System.out.println("\nBache número: " + numeroBache);
        System.out.println("Discos dañados:"
                + "\n" + dato1.toString()
                + "\n" + dato2.toString()
                + "\n\n");
    }

}
