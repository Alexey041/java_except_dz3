public class IncorrectInputException extends Exception {
    public IncorrectInputException(int arrLenght){
        if (arrLenght < 6) {
            System.err.println("Введено меньше первоначальных данных!");
        }
        if (arrLenght > 6) {
            System.err.println("Введено больше первоначальных данных!");
        }

    }
}
