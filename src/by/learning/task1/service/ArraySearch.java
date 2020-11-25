package by.learning.task1.service;


import by.learning.task1.entity.CustomArray;

public class ArraySearch {

    public int receiveMaxValue(CustomArray customArray) {
        int max = customArray.getElement(0);
        for (int i = 1; i < customArray.size(); i++) {
            if (customArray.getElement(i) > max) {
                max = customArray.getElement(i);
            }
        }
        return max;
    }

    public int receiveMaxIndex(CustomArray customArray) {
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

    public int receiveMinIndex(CustomArray customArray) {
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
            int middle = start + (end - start) / 2;
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

}
