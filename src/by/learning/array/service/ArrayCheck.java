package by.learning.array.service;

public class ArrayCheck {

    public boolean isPrimeNumber(int number) {
        if (number == 0) {
            return false;
        }
        int value = Math.abs(number);
        boolean isPrime = true;
        int i = 2;
        while (i <= value / 2) {
            if (value % i == 0) {
                isPrime = false;
                break;
            }
            i++;
        }
        return isPrime;
    }

    public boolean isFibonacciNumber(int number) {
        if (number == 0) {
            return true;
        }
        int previous = 0;
        int current = 1;
        boolean isFibonacci = false;
        while (current <= number) {
            current += previous;
            previous = current - previous;
            if (number == current) {
                isFibonacci = true;
                break;
            }
        }
        return isFibonacci;
    }


    public boolean containSameDigits(int number) {
        int[] digitsCounter = new int[10];
        boolean isSame = false;
        do {
            int value = number % 10;
            digitsCounter[value]++;
            if (digitsCounter[value] > 1) {
                isSame = true;
                break;
            }
            number /= 10;
        } while (number > 0);

        return isSame;
    }

}
