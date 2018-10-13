package amortiguador;

import java.util.Random;

/**
 *
 * @author Carlos Contreras
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Amortiguador amortiguador = new Amortiguador();
        int numeroBache = 0;

        while (amortiguador.numeroDiscos > 4) {
            System.out.print("Manejando en carretera.");
            for (int i = 0; i < new Random().nextInt(6) + 2; i++) {
                Thread.sleep(800);
                System.out.print(".");
            }
            Thread.sleep(500);
            System.out.println("");
            System.out.println("¡Has pasado por un bache! Tu amortiguador se ha dañado.");
            Thread.sleep(1500);
            numeroBache++;
            amortiguador.bache();
            amortiguador.acomodar();
            amortiguador.mostrarDatos(numeroBache);
        }
        System.out.println("\n\nTu amortiguador tiene 4 o menos discos disponibles. "
                + "Ha quedado demasiado dañado para continuar.");
    }

}
