import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        input();

    }

    public static void input() {
        int count = 7;
        try (Scanner scanner = new Scanner(System.in, "ibm866")) {
            System.out.println("Фамилия Имя Отчество дата_рождения(dd.mm.yyyy) номер_телефона(11цифр) пол(f/m) ");
            String[] arr = scanner.nextLine().split(" ");
            if (!checkInput(arr)) {
                try {
                    throw new IncorrectInputException(arr.length);
                } catch (IncorrectInputException e) {
                    input();
                }
            } else {
                count--;
            }

            if (isEmptyString(arr, 0)) {
                try {
                    throw new RuntimeException();
                } catch (Exception e) {
                    System.err.println("Некорректно введена фамилия!");
                    input();
                }
            } else {
                count--;
            }

            if (isEmptyString(arr, 1)) {
                try {
                    throw new RuntimeException();
                } catch (Exception e) {
                    System.err.println("Некорректно введено имя!");
                    input();
                }
            } else {
                count--;
            }

            if (isEmptyString(arr, 2)) {
                try {
                    throw new RuntimeException();
                } catch (Exception e) {
                    System.err.println("Некорректно введено отчество!");
                    input();
                }
            } else {
                count--;
            }

            if (!isBirthDate(arr)) {
                try {
                    throw new IncorrectBirthDateException();
                } catch (IncorrectBirthDateException e) {
                    input();
                }
            } else {
                count--;
            }

            if (!isPhoneNumber(arr)) {
                try {
                    throw new IncorrectPhoneNumberException();
                } catch (Exception e) {
                    input();
                }
            } else {
                count--;
            }

            if (!isGender(arr)) {
                try {
                    throw new IncorrectGenderException();
                } catch (Exception e) {
                    input();
                }
            } else {
                count--;
            }
            System.out.println(count);
            if (count == 0) {
                addToHuman(arr);
            }
        }
    }

    public static void addToHuman(String[] arr) {
        Human human = new Human(arr[1], arr[0], arr[2], arr[3], arr[4], arr[5]);
        System.out.println(human);
        Writer(human);
    }

    public static boolean checkInput(String[] arr) {
        if (arr.length == 6) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBirthDate(String[] arr) {
        if (arr[3].length() == 10) {
            String[] birthdayStr = arr[3].split("\\.");
            int date = Integer.parseInt(birthdayStr[0]);
            int month = Integer.parseInt(birthdayStr[1]);
            int year = Integer.parseInt(birthdayStr[2]);
            if (date > 0 && date < 32 && month > 0 && month < 13 && year > 1900 && year < 2018) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
    }

    public static boolean isPhoneNumber(String[] arr) {
        if (arr[4].length() == 11) {
            if (isNumeric(arr[4])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isGender(String[] arr) {
        if (arr[5].length() == 1) {
            if (arr[5].equals("f") | arr[5].equals("m") |
                    arr[5].equals("м") | arr[5].equals("ж")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSpecialCharacter(String[] arr, int index) {
        Pattern p = Pattern.compile("[^a-zа-я -]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(arr[index]);
        boolean b = m.find();
        if (b) {
            return true;
        }
        return false;
    }

    public static boolean isEmptyString(String[] arr, int index) {
        if (arr[index].length() < 2) {
            return true;
        }
        return false;
    }

    public static void Writer(Human human) {
        try (FileWriter writer = new FileWriter(new File(human.lastname + ".txt"), true);) {
            writer.write(human.toString() + "\n");

        } catch (IOException e) {
            System.err.println("Ошибка чтения/записи");
            e.printStackTrace();
        }
    }
}
