public class WrongEmailException extends RuntimeException{
    public WrongEmailException() {
    }

    public WrongEmailException(String message) {
        super(message);
    }
}
