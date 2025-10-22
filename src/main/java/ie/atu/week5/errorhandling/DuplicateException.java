package ie.atu.week5.errorhandling;

public class DuplicateException extends RuntimeException {

    private String message;
    private String field;
    public DuplicateException(String field, String message){
        this.field = field;
    }

    public DuplicateException(String message){
        super(message);
    }
}
