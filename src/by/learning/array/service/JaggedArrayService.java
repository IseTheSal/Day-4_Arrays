package by.learning.array.service;

import by.learning.array.entity.JaggedArray;

public class JaggedArrayService {

    public int receiveMaxElementInRow(JaggedArray jaggedArray, int i) {
        int max = jaggedArray.getElement(i, 0);
        int size = jaggedArray.getRowSize(i);
        for (int j = 0; j < size; j++) {
            if (jaggedArray.getElement(i, j) > max) {
                max = jaggedArray.getElement(i, j);
            }
        }
        return max;
    }

    public int receiveMinElementInRow(JaggedArray jaggedArray, int i) {
        int min = jaggedArray.getElement(i, 0);
        int size = jaggedArray.getRowSize(i);
        for (int j = 0; j < size; j++) {
            if (jaggedArray.getElement(i, j) < min) {
                min = jaggedArray.getElement(i, j);
            }
        }
        return min;
    }

    public int receiveSumInRow(JaggedArray jaggedArray, int i) {
        int sum = 0;
        int size = jaggedArray.getRowSize(i);
        for (int j = 0; j < size; j++) {
            sum += jaggedArray.getElement(i, j);
        }
        return sum;
    }

}
