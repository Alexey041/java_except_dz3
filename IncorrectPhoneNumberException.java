public class IncorrectPhoneNumberException extends Exception {
    public IncorrectPhoneNumberException(){
        System.err.println("Некорректно введен номер телефона!");
    }
}
