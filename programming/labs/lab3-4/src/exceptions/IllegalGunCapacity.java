package exceptions;

public class IllegalGunCapacity extends Exception {
    @Override
    public String getMessage() {
        return "Невозможный запас патронов";
    }
}
