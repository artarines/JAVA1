import java.util.Scanner;

public class Main {

    //перевірка чи є число простим
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    //підрахунок нулів у двійковому поданні числа
    public static int countZerosInBinary(int num) {
        String binaryStr = Integer.toBinaryString(num);
        int zeros = 0;
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '0') {
                zeros++;
            }
        }
        return zeros;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число n: ");
        
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int maxZeros = -1;
            int targetPrime = -1;

            //перебір чисел до введеного n
            for (int i = 2; i <= n; i++) {
                if (isPrime(i)) {
                    int zeros = countZerosInBinary(i);
                    //знах. число з максимальною кількістю нулів
                    if (zeros > maxZeros) {
                        maxZeros = zeros;
                        targetPrime = i;
                    }
                }
            }

            if (targetPrime != -1) {
                System.out.println("Шукане просте число: " + targetPrime);
                System.out.println("Двійкова форма: " + Integer.toBinaryString(targetPrime));
                System.out.println("Кількість нулів: " + maxZeros);
            } else {
                System.out.println("Простих чисел у заданому діапазоні не знайдено.");
            }
        } else {
            System.out.println("Помилка: введено не ціле число.");
        }
        scanner.close();
    }
}