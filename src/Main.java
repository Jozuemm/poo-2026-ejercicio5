import model.Mision;
import view.VistaConsola;
import controller.ControladorMision;

public class Main {

    public static void main(String[] args) {
        Mision modelo = new Mision();
        VistaConsola vista = new VistaConsola();
        ControladorMision controlador =
                new ControladorMision(modelo, vista);
        controlador.iniciar();
    }
}