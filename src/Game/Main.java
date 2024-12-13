package Game;

import java.util.*;

public class Main {
    private static Random random = new Random();

    public static int[] generateRandomNumbers() {
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = random.nextInt(50) + 1;
        }
        return numbers;
    }

    public static boolean checkMatch(int userNumber, int[] randomNumbers) {
        for (int number : randomNumbers) {
            if (number == userNumber) {
                return true;
            }
        }
        return false;
    }

    public static String numbersToString(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
            new MainLogic().setVisible(true);
    }
}
