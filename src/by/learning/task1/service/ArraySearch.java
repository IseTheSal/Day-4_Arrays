package by.learning.task1.service;


import by.learning.task1.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySearch {

    private static final Logger logger = LogManager.getLogger(ArraySearch.class);

    public int receiveMaxValue(CustomArray customArray) {
        int max = customArray.getElement(0);
        for (int i = 1; i < customArray.size(); i++) {
            if (customArray.getElement(i) > max) {
                max = customArray.getElement(i);
            }
        }
        return max;
    }

    public int receiveMaxValueIndex(CustomArray customArray) {
        int maxIndex = 0;
        for (int i = 0; i < customArray.size(); i++) {
            if (customArray.getElement(maxIndex) < customArray.getElement(i)) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int receiveMinValue(CustomArray customArray) {
        int min = customArray.getElement(0);
        for (int i = 0; i < customArray.size(); i++) {
            if (customArray.getElement(i) < min) {
                min = customArray.getElement(i);
            }
        }
        return min;
    }

    public int receiveMinValueIndex(CustomArray customArray) {
        int minIndex = 0;
        for (int i = 0; i < customArray.size(); i++) {
            if (customArray.getElement(minIndex) > customArray.getElement(i)) {
                minIndex = i;
            }
        }
        return minIndex;
    }


    public int binarySearchIndex(CustomArray customArray, int key) {
        ArraySort arraySort = new ArraySort();
        int start = 0;
        int end = customArray.size() - 1;
        arraySort.quickSort(customArray, start, end);
        while (start <= end) {
            int middle = (end + start) / 2;
            if (customArray.getElement(middle) > key) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return end;
    }

    public int receiveFibonacciAmount(CustomArray customArray) {
        int counter = 0;
        ArrayCheck arrayCheck = new ArrayCheck();
        for (int i = 0; i < customArray.size(); i++) {
            boolean isFibonacci = arrayCheck.isFibonacciNumber(customArray.getElement(i));
            if (isFibonacci) {
                counter++;
            }
        }
        return counter;
    }

    public int[] receiveFibonacciArray(CustomArray customArray) {
        int length = receiveFibonacciAmount(customArray);
        int[] result = new int[length];
        int resultIndex = 0;
        ArrayCheck arrayCheck = new ArrayCheck();
        for (int i = 0; i < customArray.size(); i++) {
            boolean isFibonacci = arrayCheck.isFibonacciNumber(customArray.getElement(i));
            if (isFibonacci) {
                result[resultIndex] = customArray.getElement(i);
                resultIndex++;
            }
        }
        return result;
    }

    public int receiveDigitsAmount(int number) {
        int counter = 0;
        number = Math.abs(number);
        do {
            number /= 10;
            counter++;
        } while (number > 0);
        return counter;
    }

    public int receiveAmountWithoutSameDigitsAmount(CustomArray customArray, int digitsAmount) {
        ArrayCheck arrayCheck = new ArrayCheck();
        int counter = 0;
        for (int i = 0; i < customArray.size(); i++) {
            int number = Math.abs(customArray.getElement(i));
            int numberDigitsAmount = receiveDigitsAmount(number);
            boolean containSameDigits = arrayCheck.containSameDigits(number);
            if ((digitsAmount == numberDigitsAmount) && !containSameDigits) {
                counter++;
            }
        }
        return counter;
    }

    public int[] receiveNumbersWithoutSameDigitsAmount(CustomArray customArray, int digitsAmount) {
        ArrayCheck arrayCheck = new ArrayCheck();

        int length = receiveAmountWithoutSameDigitsAmount(customArray, digitsAmount);
        int[] result = new int[length];
        int resultIndex = 0;

        for (int i = 0; i < customArray.size(); i++) {
            int number = Math.abs(customArray.getElement(i));
            int numberDigitsAmount = receiveDigitsAmount(number);
            boolean containSameDigits = arrayCheck.containSameDigits(number);
            if ((digitsAmount == numberDigitsAmount) && !containSameDigits) {
                result[resultIndex] = customArray.getElement(i);
                resultIndex++;
            }
        }
        return result;
    }

}
