package model;

public class Recursos {
    private int energia;
    private int datosPendientes;
    private int datosDescargados;

    public Recursos(int energiaInicial){
        validarCantidad(energiaInicial);
        energia=energiaInicial;
        datosPendientes = 0;
        datosDescargados =0;
    }

    public void agregarEnergia(int cantidad){
        validarCantidad(cantidad);
        energia += cantidad;    // += aumento de valor de una variable
    }

    public boolean consumirEnergia(int cantidad){
        validarCantidad(cantidad);
        if (energia < cantidad){
            return false;
        }
        energia -= cantidad;    // -= disminuye el valor de una variable
        return true;
    }

    public int descargarDatos(int capacidad){
        validarCantidad(capacidad);
        int cantidad = Math.min(capacidad, datosPendientes);    // Math.min para seleccionar el menor valor
        datosPendientes -= cantidad;
        datosDescargados += cantidad;
        return cantidad;
    }

    public void agregarDatos(int cantidad){
        validarCantidad(cantidad);
        datosPendientes += cantidad;
    }

    private void validarCantidad(int cantidad){
        if (cantidad <0){
            throw new IllegalArgumentException(     // rechazar un argumento invalido con un mensaje claro
                "No puede ser un valor negativoo"
            );
        }
    }

    public int getEnergia(){
        return energia;
    }
    public int getDatosPendientes(){
        return datosPendientes;
    }
    public int getDatosDescargados(){
        return datosDescargados;
    }

}
