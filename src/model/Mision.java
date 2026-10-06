package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Mision {
    
    private final ArrayList<Modulo> modulos;
    private final Recursos recursos;
    private int ciclosProcesados;

    public Mision() {
        modulos = new ArrayList<>();
        recursos = new Recursos(100);
        ciclosProcesados = 0;

        cargarInicial();

    }

    public void cargarInicial() {
        if (!modulos.isEmpty()) {//Evitamos repetir carga a una mision que ya tiene modulos
            return;
        }
// 4 modulos de energia
        agregarModulo(new ModuloEnergia(1, "Panel solar", 100, 100, 50, new Posicion(0, 0), true, recursos, 20));
        
        agregarModulo(new ModuloEnergia(2, "Panel solar extra", 80, 100, 40, new Posicion(1, 0), true, recursos, 15));
    
        agregarModulo(new ModuloEnergia(3, "Bateria principal", 100, 100, 70, new Posicion(2, 0), true, recursos, 25));

        agregarModulo(new ModuloEnergia(4, "Panel solar de respaldo", 90, 100, 30, new Posicion(3, 0), true, recursos, 10));

// 3 de vuelo
        agregarModulo(new ModuloVuelo(5, "Camara principal", 100, 100, 120, new Posicion(0, 1), true, recursos, 15, 10));

        agregarModulo(new ModuloVuelo(6, "Sensor de temperatura", 85, 100, 80, new Posicion(1, 1), true, recursos, 10, 5));

        agregarModulo(new ModuloVuelo(7, "Sensor de radiacion", 100, 100, 100, new Posicion(2, 1), true, recursos, 12, 8));
    
// 3 de tierra
    
        agregarModulo(new ModuloTierra(8, "Antena principal", 100, 100, 150, new Posicion(0, 2), true, recursos, 20, 10));

        agregarModulo(new ModuloTierra(9, "Antena secundaria", 75, 100, 90, new Posicion(1, 2), true, recursos, 10, 5));

        agregarModulo(new ModuloTierra(10, "Antena de respaldo", 100, 100, 110, new Posicion(2, 2), true, recursos, 15, 8));
    }

    public boolean agregarModulo(Modulo modulo) {
        if (modulo == null) {
            throw new IllegalArgumentException("El modulo no puede ser nulo");
        }

        if (modulo.getRecursos() != recursos) {
            throw new IllegalArgumentException("El modulo debe compartir los recursos de la mision");
        }

        if(buscarModulo(modulo.getId()) != null) {
            return false; // No deja agregar un modulo con el mismo ID
        }
        modulos.add(modulo);
        return true;
    }

    public List<Modulo> listarModulos() {
        return new ArrayList<>(modulos);
    }

    public Modulo buscarModulo(int id) {
        for (Modulo modulo : modulos) {
            if (modulo.getId() == id) {
                return modulo;
            }
        }
        return null;
    }

    public List<Modulo> buscarModulo(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }

        String textoBuscado = nombre.trim().toLowerCase(java.util.Locale.ROOT);

        List<Modulo> resultado = new ArrayList<>();

        for (Modulo modulo : modulos) {
            String nombreModulo = modulo.getNombre().toLowerCase(java.util.Locale.ROOT);
            if (nombreModulo.contains(textoBuscado)) {
                resultado.add(modulo);
            }
        }
        return resultado;
    }

    public List<Modulo> ordenarPorCosto() {
        List<Modulo> ordenados = new ArrayList<>(modulos);
        Collections.sort(ordenados);
        return ordenados;
    }

    public void procesarCiclo() {
        for(Modulo modulo : modulos) {
            modulo.procesarCiclo();
        }
        ciclosProcesados++;
    }

    public Recursos getRecursos() {
        return recursos;
    }

    public int getCiclosProcesados() {
        return ciclosProcesados;
    }

}
