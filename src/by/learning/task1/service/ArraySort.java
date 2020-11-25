package by.learning.task1.service;


import by.learning.task1.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


class ArraySort {

    private static final Logger logger = LogManager.getLogger(ArraySort.class);

    public void quickSort(CustomArray customArray, int low, int high) {
        if (customArray.size() == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int i = low;
        int j = high;
        int middle = low + (high - low) / 2;
        int pivot = customArray.getElement(middle);
        while (i <= j) {
            while (customArray.getElement(i) < pivot) {
                i++;
            }
            while (customArray.getElement(j) > pivot) {
                j--;
            }

            if (i <= j) {
                swapElements(customArray, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(customArray, low, j);
        }

        if (high > i) {
            quickSort(customArray, i, high);
        }
    }

    public void swapElements(CustomArray customArray, int i, int j) {
        if (i > (customArray.size() - 1) || i < 0
                || j > (customArray.size() - 1) || j < 0) {
            logger.warn("IndexOfBoundException was thrown");
            throw new IndexOutOfBoundsException();
        }
        int tmp = customArray.getElement(i);
        customArray.setElement(i, customArray.getElement(j));
        customArray.setElement(j, tmp);
    }


    public void countingSort(CustomArray customArray, int exp) {
        int arraySize = customArray.size();
        int[] countingArray = new int[10];
        int[] resultArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            if (customArray.getElement(i) < 0) {
                throw new IllegalArgumentException();
            }
            countingArray[(customArray.getElement(i) / exp) % 10]++;
        }

        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i] += countingArray[i - 1];
        }

        for (int i = resultArray.length - 1; i >= 0; i--) {
            resultArray[countingArray[(customArray.getElement(i) / exp) % 10] - 1] = customArray.getElement(i);
            countingArray[(customArray.getElement(i) / exp) % 10]--;
        }

        for (int i = 0; i < arraySize; i++) {
            customArray.setElement(i, resultArray[i]);
        }
    }

    public void radixSort(CustomArray customArray) {
        ArraySearch arraySearch = new ArraySearch();
        int maxValue = arraySearch.receiveMaxValue(customArray);

        for (int exp = 1; maxValue / exp > 0; exp *= 10) {
            countingSort(customArray, exp);
        }
    }

    void mergeHalves(CustomArray customArray, int left, int middle, int right) {
        int firstLength = middle - left + 1;
        int secondLength = right - middle;

        int[] arrayLeft = new int[firstLength];
        int[] arrayRight = new int[secondLength];

        for (int i = 0; i < firstLength; ++i) {
            arrayLeft[i] = customArray.getElement(left + i);
        }

        for (int j = 0; j < secondLength; ++j) {
            arrayRight[j] = customArray.getElement(middle + 1 + j);
        }

        int i = 0, j = 0;

        int currentPosition = left;
        while (i < firstLength && j < secondLength) {
            if (arrayLeft[i] <= arrayRight[j]) {
                customArray.setElement(currentPosition, arrayLeft[i]);
                i++;
            } else {
                customArray.setElement(currentPosition, arrayRight[j]);
                j++;
            }
            currentPosition++;
        }

        while (i < firstLength) {
            customArray.setElement(currentPosition, arrayLeft[i]);
            i++;
            currentPosition++;
        }

        while (j < secondLength) {
            customArray.setElement(currentPosition, arrayRight[j]);
            j++;
            currentPosition++;
        }
    }

    void mergeSort(CustomArray customArray, int leftPosition, int rightPosition) {
        if (leftPosition < rightPosition) {
            int middle = (leftPosition + rightPosition) / 2;

            mergeSort(customArray, leftPosition, middle);
            mergeSort(customArray, middle + 1, rightPosition);

            mergeHalves(customArray, leftPosition, middle, rightPosition);
        }
    }


}

