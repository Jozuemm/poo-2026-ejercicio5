package view;

import java.util.List;
import java.util.Scanner;

import model.Modulo;

public class VistaConsola {
    private Scanner entrada;
    public VistaConsola(){
        this.entrada = new Scanner(System.in);
    }

    public void mostrarMenu(){
        System.out.println();
        System.out.println("--- Quetzal 2 - Defense ---");
        System.out.println("1. Listar los modulos");
        System.out.println("2. Buscar modulos por ID");
        System.out.println("3. Buscar modulos por nombre");
        System.out.println("4. Ordenar modulos por el costo");
        System.out.println("5. Procesamiento de un ciclo");
        System.out.println("6. Enseñar estado de la mision");
        System.out.println("0. Salir");
    }
    public int leerEntero(String mensaje){
        while (true){
            System.out.print(mensaje);
            String texto = entrada.nextLine();
            try {
                return Integer.parseInt(texto.trim());//Integer.parseInt convierte valores de texto como 10 a un valor numerico entero
            } catch (NumberFormatException e){
                mostrarMensaje("Tienes que ingresar un numero valido");
            }   
        }
    }
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return entrada.nextLine().trim(); // .nextLine para leer una linea completa - trim para eliminar espacios al inicio y final
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarModulo(Modulo modulo) {
        if (modulo == null) {
            mostrarMensaje("No se encontro el modulo.");
            return;
        }

        System.out.println(modulo);
    }

    public void mostrarModulos(List<Modulo> modulos) {
        if (modulos.isEmpty()) {
            mostrarMensaje("No hay modulos para mostrar.");
            return;
        }

        for (Modulo modulo : modulos) {
            mostrarModulo(modulo);
        }
    }

    public void mostrarEstado(int ciclo, int energia,
                              int pendientes, int descargados) {

        System.out.println();
        System.out.println("========== ESTADO DE LA MISION ==========");
        System.out.println("Ciclosprocesados: " + ciclo);
        System.out.println("Energia disponible: " + energia);
        System.out.println("Datos pendientes: " + pendientes);
        System.out.println("Datos descargados: " + descargados);
    }
}
