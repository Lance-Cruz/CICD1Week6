package ie.atu.week5.errorhandling;

public class PassengerNotFound extends RuntimeException {
    private String message;
    private String field;

    public PassengerNotFound(String field, String message){
        this.field = field;
    }

    public PassengerNotFound(String message){
        super(message);
    }
}
