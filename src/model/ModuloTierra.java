package model;

public class ModuloTierra extends Modulo {

    private final int capacidadDescarga;
    private final int consumoEnergia;

    public ModuloTierra(int id, String nombre, int salud, int saludMaxima, int costo, Posicion posicion, boolean construido, Recursos recursos, int capacidadDescarga, int consumoEnergia){
        super(id, nombre, salud, saludMaxima, costo, posicion, construido, recursos);

        if (capacidadDescarga <= 0){
            throw new IllegalArgumentException(
                "La capacidad de descarga no puede ser negativa ni 0"
            );
        }

        if (consumoEnergia <= 0){
            throw new IllegalArgumentException(
                "El consumo de energia no puede ser negativo ni 0"
            );
        }

        this.capacidadDescarga = capacidadDescarga;
        this.consumoEnergia = consumoEnergia;
    }


    @Override
    public void procesarCiclo() {
        if (!getConstruido() || estaDestruido()){//Solo procesa si el modulo no esta destruido y esta construido (valga la redundancia)
            return;
        }

        if (getRecursos().getDatosPendientes() == 0){
            return;
        }

        if (getRecursos().consumirEnergia(consumoEnergia)){
            getRecursos().descargarDatos(capacidadDescarga);
        }
    }

    public int getCapacidadDescarga() {
        return capacidadDescarga;
    }

    public int getConsumoEnergia() {
        return consumoEnergia;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Tierra" + " | Capacidad de descarga: " + capacidadDescarga + " | Consumo de energia: " + consumoEnergia;
    }
    
}
