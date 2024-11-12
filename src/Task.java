import java.util.Scanner;

public class Task {

    public static void main(String[] args) {
        textModifier();
    }

    private static void textModifier() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ваш текст: ");
        String text = scanner.nextLine();

        StringBuilder finalText = new StringBuilder();
        int sum = 0;
        boolean spaceDetected = false;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);


            if (currentChar == '+') {
                finalText.append('!');
            }

            else if (currentChar == '-') {
                if (i > 0 && i < text.length() - 1) {

                    finalText.append(text.charAt(i + 1));
                    finalText.append(text.charAt(i - 1));
                    i++;
                } else {
                    finalText.append(currentChar);
                }
            }
            else if (currentChar == ' ') {
                if (!spaceDetected) {
                    finalText.append(currentChar);
                    spaceDetected = true;
                }
            }
            else {
                if (Character.isDigit(currentChar)) {
                    sum += Character.getNumericValue(currentChar);
                } else {
                    finalText.append(currentChar);
                }
                spaceDetected = false;
            }
        }

        if (sum > 0) {
            finalText.append(" ").append(sum);
        }

        // Выводим готовый результат
        System.out.println("Готовый результат: " + finalText.toString());

        scanner.close();
    }
}
