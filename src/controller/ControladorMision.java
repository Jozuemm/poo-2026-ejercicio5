package controller;

import model.Mision;
import model.Recursos;
import view.VistaConsola;

public class ControladorMision {
    private Mision modelo;
    private VistaConsola vista;
    public ControladorMision(Mision modelo, VistaConsola vista) {
        if (modelo == null || vista == null) {
            throw new IllegalArgumentException(
                "El modelo y la vista no pueden ser nulos."
            );
        }

        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;

        do {
            vista.mostrarMenu();
            opcion = vista.leerEntero("Selecciona una opcion: ");

            switch (opcion) {
                case 1:
                    listarModulos();
                    break;

                case 2:
                    buscarPorId();
                    break;

                case 3:
                    buscarPorNombre();
                    break;

                case 4:
                    ordenarModulos();
                    break;

                case 5:
                    procesarCiclo();
                    break;

                case 6:
                    mostrarEstado();
                    break;

                case 0:
                    vista.mostrarMensaje("Programa finalizado.");
                    break;

                default:
                    vista.mostrarMensaje("La opcion no es valida.");
                    break;
            }

        } while (opcion != 0);
    }

    private void listarModulos() {
        vista.mostrarModulos(modelo.listarModulos());
    }

    private void buscarPorId() {
        int id = vista.leerEntero("Ingresa el ID del modulo: ");

        vista.mostrarModulo(modelo.buscarModulo(id));
    }

    private void buscarPorNombre() {
        String nombre = vista.leerTexto(
                "Ingresa el nombre o parte del nombre: "
        );

        try {
            vista.mostrarModulos(modelo.buscarModulo(nombre));
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

    private void ordenarModulos() {
        vista.mostrarMensaje("Modulos ordenados de menor a mayor costo:");
        vista.mostrarModulos(modelo.ordenarPorCosto());
    }

    private void procesarCiclo() {
        modelo.procesarCiclo();
        vista.mostrarMensaje("Ciclo procesado conexito.");
        mostrarEstado();
    }

    private void mostrarEstado() {
        Recursos recursos = modelo.getRecursos();

        vista.mostrarEstado(
                modelo.getCiclosProcesados(),
                recursos.getEnergia(),
                recursos.getDatosPendientes(),
                recursos.getDatosDescargados()
        );
    }
}