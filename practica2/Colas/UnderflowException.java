package practica2.Colas;

public class UnderflowException extends RuntimeException {
    public UnderflowException(String message){
        super( message );
    }
}
