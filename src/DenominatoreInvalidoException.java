public class DenominatoreInvalidoException extends Exception{
    public DenominatoreInvalidoException(){
        super("Denominatore non valido");
    }

    public DenominatoreInvalidoException(String s){
        super(s);
    }
}
