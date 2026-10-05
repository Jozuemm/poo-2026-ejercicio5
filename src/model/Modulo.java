package model;

public abstract class Modulo implements Comparable <Modulo>{
    private final int id;   // final para que no se pueda reasignar el atributo
    private String nombre;
    private int salud;
    private final int saludMaxima;
    private final int costo;
    private Posicion posicion;
    private boolean construido;
    private final Recursos recursos;

    public Modulo(int id, String nombre, int salud, int saludMaxima, int costo, Posicion posicion, boolean construido, Recursos recursos){
        //  validaciones al correr programa
        if (id <=0){
            throw new IllegalArgumentException(
                "El ID debe ser mayor que 0"
            );
        }

        if (nombre == null || nombre.trim().isEmpty()){     // null para indicar que no existe objeto asignado
            throw new IllegalArgumentException(             // .trim().isEmpty() para comprobar un valor ingresado esta formado por solo espacios
                "Debes ingresar un valor para nombre"
            );
        }

        if (saludMaxima <= 0){
            throw new IllegalArgumentException(
                "La salud maxima debe ser mayor que 0"
            );
        }

        if (salud < 0 || salud > saludMaxima){
            throw new IllegalArgumentException(
                "La salud debe estar entre 0 y la salud maxima"
            );
        }

        if (costo < 0){
            throw new IllegalArgumentException(
                "No puede haber costo negativo"
            );
        }

        if (posicion == null){
            throw new IllegalArgumentException(
                "La posicion debe ser un valor valido"
            );
        }

        if (recursos == null){
            throw new IllegalArgumentException(
                "Los recursos deben de ser un valor valido"
            );
        }

        this.id = id;
        this.nombre = nombre.trim();//Limpiar el nombre de espacios
        this.salud = salud;
        this.saludMaxima = saludMaxima;
        this.costo = costo;
        this.posicion = posicion;
        this.construido = construido;//Declarar el estado que se recibe en el constructor
        this.recursos = recursos;
    }

    public abstract void procesarCiclo();

    public void recibirDanio(int cantidad){
        if (cantidad <0){
            throw new IllegalArgumentException(
                "Daño negativo"
            );
        }
        salud = Math.max(0, salud - cantidad);
    }

    public boolean estaDestruido(){
        return salud == 0;
    }

    public void construir(){
        construido = true;
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        if (nombre == null || nombre.trim().isEmpty()){
        throw new IllegalArgumentException(
            "Debes ingresar un valor valido para el nombre");

        }
        this.nombre = nombre.trim();
    }


    public int getSalud(){
        return salud;
    }

    public int getSaludMaxima(){
        return saludMaxima;
    }

    public int getCosto(){
        return costo;
    }

    public Posicion getPosicion(){
        return posicion;
    }
    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new IllegalArgumentException(
                "La posicion no puede ser nula"
            );
        }

        this.posicion = posicion;
    }


    public boolean getConstruido(){
        return construido;
    }
// el protected hace que sea visible para las clases hijas y para las clases del mismo paquete
    protected Recursos getRecursos(){
        return recursos;
    }

    @Override
    public int compareTo(Modulo otro){
        return Integer.compare(this.costo, otro.costo);
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (!(objeto instanceof Modulo)) {
            return false;
        }
        Modulo otro = (Modulo) objeto;
        return this.id == otro.id;
    }

    @Override 
    public int hashCode(){ // devolver un numero entero que sirve para organizar y buscar ejemplos, sobre todo si se repiten
        return Integer.hashCode(id);
    }
    
    @Override 
    public String toString() { // toString para devolver una mejor descripcion mas legible de modulo
    return "ID: " + id
         + " | Nombre: " + nombre
         + " | Salud: " + salud + "/" + saludMaxima
        + " | Costo: " + costo
        + " | Posicion: " + posicion
        + " | Construido: " + construido;
}

}