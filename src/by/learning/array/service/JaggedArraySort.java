package by.learning.array.service;

import by.learning.array.entity.JaggedArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JaggedArraySort {

    private final static Logger logger = LogManager.getLogger(JaggedArraySort.class);


    public void swapMatrixRows(JaggedArray jaggedArray, int i, int j) {
        int[] tmp = jaggedArray.getRow(i);
        jaggedArray.setRow(i, jaggedArray.getRow(j));
        jaggedArray.setRow(j, tmp);
    }


    public void chooseSortMethod(JaggedArray jaggedArray, String sortMethod, boolean ascending) {
        JaggedArrayService jaggedArrayService = new JaggedArrayService();
        for (int i = 0; i < jaggedArray.getColumnSize() - 1; i++) {
            for (int j = 0; j < jaggedArray.getRowSize(i) - 1; j++) {
                int parameter1;
                int parameter2;
                switch (sortMethod) {
                    case "sortBySum":
                        parameter1 = jaggedArrayService.receiveSumInRow(jaggedArray, j);
                        parameter2 = jaggedArrayService.receiveSumInRow(jaggedArray, j + 1);
                        break;
                    case "sortByMinElement":
                        parameter1 = jaggedArrayService.receiveMinElementInRow(jaggedArray, j);
                        parameter2 = jaggedArrayService.receiveMinElementInRow(jaggedArray, j + 1);
                        break;
                    case "sortByMaxElement":
                        parameter1 = jaggedArrayService.receiveMaxElementInRow(jaggedArray, j);
                        parameter2 = jaggedArrayService.receiveMaxElementInRow(jaggedArray, j + 1);
                        break;
                    default:
                        logger.warn("Incorrect sort method");
                        return;
                }
                if (ascending && (parameter1 > parameter2)) {
                    swapMatrixRows(jaggedArray, j, j + 1);
                } else if (!ascending && (parameter1 < parameter2)) {
                    swapMatrixRows(jaggedArray, j, j + 1);
                }
            }
        }
    }


}
