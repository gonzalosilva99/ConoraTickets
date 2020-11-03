package excepciones;

public class Identidad extends Exception{
	public Identidad() {
        super();
    }
    public Identidad(String message) {
        super(message);
    }
}
