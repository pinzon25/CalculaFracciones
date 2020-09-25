/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculafracciones;

import java.util.Scanner;

/*
Hay que introducir un nominador y un denominador, luego preguntar que operacion se desea realizar,
seguidamente pedimos otro nominador y otro denominador.

Luego hay que mostrar el resultado de la fraccion.
 */
/**
 *
 * @author Riki
 */
public class CalculaFracciones {

    private int nominador, denominador;
    CalculaFracciones r = null;

    public CalculaFracciones() {
        nominador = 0;
        denominador = 0;
    }

    public CalculaFracciones(int nominador, int denominador) {
        this.nominador = nominador;
        this.denominador = denominador;
    }

    public int getNominador() {
        return nominador;
    }

    public void setNominador(int nominador) {
        this.nominador = nominador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public CalculaFracciones sumaFracciones(CalculaFracciones nuevaFraccion) {

        int nominadorSuma = 0, minimoComunmultiple = 0, nuevoNominador = 0;

        if (denominador == nuevaFraccion.getDenominador()) {
            nominadorSuma = (nominador + nuevaFraccion.getNominador());
            r = new CalculaFracciones(nominadorSuma, denominador);

        } else if (denominador != nuevaFraccion.getDenominador()) {

            minimoComunmultiple = (denominador * nuevaFraccion.getDenominador());
            nuevoNominador = (minimoComunmultiple / denominador) * nominador;
            CalculaFracciones f1 = new CalculaFracciones(nuevoNominador, minimoComunmultiple);

            nuevoNominador = 0;
            nuevoNominador = (minimoComunmultiple / nuevaFraccion.getDenominador()) * nuevaFraccion.getNominador();

            CalculaFracciones f2 = new CalculaFracciones(nuevoNominador, minimoComunmultiple);

            r = new CalculaFracciones((f1.getNominador() + f2.getNominador()), minimoComunmultiple);
        }
        return r;
    }

    public CalculaFracciones restaFracciones(CalculaFracciones nuevaFraccion) {

        int nominadorResta = 0, minimoComunmultiple = 0, nuevoNominador1 = 0, nuevoNominador2 = 0;

        if (denominador == nuevaFraccion.getDenominador()) {
            nominadorResta = (nominador - nuevaFraccion.getNominador());
            r = new CalculaFracciones(nominadorResta, denominador);

        } else if (denominador != nuevaFraccion.getDenominador()) {

            minimoComunmultiple = (denominador * nuevaFraccion.getDenominador());
            nuevoNominador1 = (nominador * nuevaFraccion.getDenominador());
            CalculaFracciones f1 = new CalculaFracciones(nuevoNominador1, minimoComunmultiple);

            nuevoNominador2 = (denominador * nuevaFraccion.getNominador());
            r = new CalculaFracciones(nuevoNominador1 - nuevoNominador2, minimoComunmultiple);

        }
        return r;
    }

    public CalculaFracciones multiplicaFracciones(CalculaFracciones nuevaFraccion) {

        r = new CalculaFracciones(nominador * nuevaFraccion.getNominador(), denominador * nuevaFraccion.getDenominador());

        return r;
    }

    public CalculaFracciones divideFracciones(CalculaFracciones nuevaFraccion) {

        r = new CalculaFracciones(nominador * nuevaFraccion.getDenominador(), denominador * nuevaFraccion.getNominador());

        return r;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int nominador = 0, denominador = 0, opcion = 0;

        System.out.println("Introduce un nominador: ");
        nominador = a.nextInt();

        System.out.println("Introduce un denominador: ");
        denominador = a.nextInt();

        CalculaFracciones f = new CalculaFracciones(nominador, denominador);

        do {
            System.out.println("Escoge que operacion quieres hacer con la fraccion:\n1-Sumar.\n2-Restar.\n3-Multiplicar.\n4-Dividir.\n");
            opcion = a.nextInt();
            int n2 = 0, d2 = 0;
            CalculaFracciones fraccionResultante = null;

            switch (opcion) {

                case 1:
                    System.out.println("Introduce un nominador: ");
                    n2 = a.nextInt();

                    System.out.println("Introduce un denominador: ");
                    d2 = a.nextInt();

                    fraccionResultante = f.sumaFracciones(new CalculaFracciones(n2, d2));

                    System.out.println("\n\nLa fraccion resultante de la suma es: \n\n" + fraccionResultante.getNominador() + "\n---\n" + fraccionResultante.getDenominador());
                    break;
                case 2:
                    System.out.println("Introduce un nominador: ");
                    n2 = a.nextInt();

                    System.out.println("Introduce un denominador: ");
                    d2 = a.nextInt();

                    fraccionResultante = f.restaFracciones(new CalculaFracciones(n2, d2));

                    System.out.println("\n\nLa fraccion resultante de la resta es: \n\n" + fraccionResultante.getNominador() + "\n---\n" + fraccionResultante.getDenominador());
                    break;
                case 3:
                    System.out.println("Introduce un nominador: ");
                    n2 = a.nextInt();

                    System.out.println("Introduce un denominador: ");
                    d2 = a.nextInt();

                    fraccionResultante = f.multiplicaFracciones(new CalculaFracciones(n2, d2));
                    System.out.println("\n\nLa fraccion resultante de la multiplicacion es: \n\n" + fraccionResultante.getNominador() + "\n---\n" + fraccionResultante.getDenominador());
                    break;
                case 4:
                    System.out.println("Introduce un nominador: ");
                    n2 = a.nextInt();

                    System.out.println("Introduce un denominador: ");
                    d2 = a.nextInt();

                    fraccionResultante = f.divideFracciones(new CalculaFracciones(n2, d2));
                    System.out.println("\n\nLa fraccion resultante de la division es: \n\n" + fraccionResultante.getNominador() + "\n---\n" + fraccionResultante.getDenominador());
                    break;
                default:
                    System.out.println("\nNo has introducido una opcion valida.");
                    break;
            }

        } while (opcion < 1 | opcion > 4);

    }

}
