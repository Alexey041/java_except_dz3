public class IncorrectBirthDateException extends Exception {
    public IncorrectBirthDateException(){
        System.err.println("Некорректный формат даты рождения!");
    }
}
