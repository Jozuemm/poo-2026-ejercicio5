package model;

public class ModuloVuelo extends Modulo{

    private final int datosPorCiclo;
    private final int consumoEnergia;

    public ModuloVuelo(int id, String nombre, int salud, int saludMaxima, int costo, Posicion posicion, boolean construido, Recursos recursos, int datosPorCiclo, int consumoEnergia){
        super(id, nombre, salud, saludMaxima, costo, posicion, construido, recursos);

        if (datosPorCiclo <= 0){
            throw new IllegalArgumentException(
                "Los datos por ciclo no pueden ser negativos ni 0"
            );
        }

        if (consumoEnergia <= 0){
            throw new IllegalArgumentException(
                "El consumo de energia no puede ser negativo ni 0"
            );
        }

        this.datosPorCiclo = datosPorCiclo;
        this.consumoEnergia = consumoEnergia;
    }

    @Override 
    public void procesarCiclo() {
        if (!getConstruido() || estaDestruido()){//Solo procesa si el modulo no esta destruido y esta construido (valga la redundancia)
            return;
        }

        if (getRecursos().consumirEnergia(consumoEnergia)){
            getRecursos().agregarDatos(datosPorCiclo);
        }
    }

    public int getDatosPorCiclo(){
        return datosPorCiclo;
    }

    public int getConsumoEnergia(){
        return consumoEnergia;
    }

    @Override 
    public String toString() {
        return super.toString() + " | Tipo: Vuelo" + " | Datos por ciclo: " + datosPorCiclo + " | Consumo de energia: " + consumoEnergia;
    }
    
}
