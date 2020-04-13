/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionlista;

import java.util.Scanner;

/**
 *
 * @author jhanc
 */
public class AplicacionLista {

    /**
     * @param args the command line arguments
     */
    private Lista lst;
    private final String menuOpciones;
    private final String opcion;
    private int numero;
    private int dato;
    private int datoInicio;
    private final Scanner input; // importar scanner

    public AplicacionLista() {
        this.lst = new Lista();
        this.menuOpciones = "Listas Enlazadas Simples\n" + "=========================\n" + "1. Crear lista\n2. Imprimir lista" + "\n3. Anexar nodos Inicio \n4. Anexar nodos final\n5. Buscar nodos\n6. Borrar nodo inicio" + "\n7. Borrar nodo final\n8. Salir";
        this.opcion = "";
        this.dato = 0;
        this.numero = 0;
        this.datoInicio = 0;
        this.input = new Scanner(System.in);

    }

    public void leerMenu() {
        do {
            listarMenu(menuOpciones);
            numero = input.nextInt();
            switch (numero) {
                case 1:
                    crearLista();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    anexarNodoInicio();
                    break;
                case 4:
                    anexarNodoFinal();
                    break;
                case 5:
                    buscarNodo();
                    break;
                case 6:
                    borrarDatoInicio();
                    break;
                case 7:
                    borrarDatoFinal();
                    break;
            }
        } while (numero != 8);
    }

    public void listarMenu(String menu) {
        System.out.println(menu);
    }

    public void crearLista() {
        lst = new Lista();
        for (int datos = 1; datos <= 10; datos++) {// renombrar la variable a datos
            lst.anexarFinalLista(datos);
            this.dato = datos;
        }
        listar();
    }

    public void anexarNodoInicio() {
        lst.anexarInicioLista(datoInicio);
        --datoInicio;
        listar();
    }

    public void anexarNodoFinal() {
        dato++;
        lst.anexarFinalLista(dato);
        listar();
    }

    public void listar() {
        String laLista = lst.imprimirLista();
        System.out.println(laLista);
    }

    public void buscarNodo() {
        int n = 0;
        System.out.println("digite el numero a buscar");
        n = input.nextInt();
        if (lst.buscarNodo(n)) {
            System.out.println("valor encontrado");
        } else {
            System.out.println("valor no encontrado");
        }
        listar();
    }

    public void borrarDatoInicio() {
        if (lst.borrarNodoInicio()) {// faltaba el lst
            System.out.println("nodo borrado");
        } else {
            System.out.println("valor no borrado");
        }
        listar();
    }

    public void borrarDatoFinal() {
        if (lst.borrarNodoFinal()) {
            System.out.println("nodo borrado");
        } else {
            System.out.println("valor no borrado");
        }
        listar();
    }

    public static void main(String[] args) {
        AplicacionLista lista = new AplicacionLista(); // faltaba el new
        lista.leerMenu();

        // TODO code application logic here
    }

}
