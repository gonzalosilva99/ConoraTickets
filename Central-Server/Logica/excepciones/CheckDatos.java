package excepciones;

public class CheckDatos extends Exception{
	public CheckDatos() {
        super();
    }

    public CheckDatos(String message) {
        super(message);
    }
}
