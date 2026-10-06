package model;

public class ModuloEnergia extends Modulo{

    private final int energiaPorCiclo;

    public ModuloEnergia(int id, String nombre, int salud, int saludMaxima, int costo, Posicion posicion, boolean construido, Recursos recursos, int energiaPorCiclo){
        super(id, nombre, salud, saludMaxima, costo, posicion, construido, recursos);

        if (energiaPorCiclo <= 0){
            throw new IllegalArgumentException(
                "La energia por ciclo no puede ser negativa ni 0"
            );
        }

        this.energiaPorCiclo = energiaPorCiclo;
    }

    @Override 
    public void procesarCiclo() {//Un modulo destruido o sin construir no genera energia
        if(!getConstruido() || estaDestruido()){
            return;
        }
        getRecursos().agregarEnergia(energiaPorCiclo);
    }

    public int getEnergiaPorCiclo(){
        return energiaPorCiclo;
    }

    @Override 
    public String toString() {
        return super.toString() + " | Tipo: Energia" + " | Energia por ciclo: " + energiaPorCiclo;
    }

    
}