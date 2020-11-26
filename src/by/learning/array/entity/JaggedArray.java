package by.learning.array.entity;

import java.util.Arrays;

public class JaggedArray {

    private int[][] matrix;

    public JaggedArray(int[][] matrix) {
        this.matrix = matrix;
    }

    public JaggedArray(int columns, int rows) {
        matrix = new int[rows][columns];
    }

    public int[] getRow(int i) {
        return matrix[i].clone();
    }


    public void setRow(int i, int[] row) {
        matrix[i] = row;
    }

    public int getElement(int i, int j) {
        return matrix[i][j];
    }

    public void setElement(int i, int j, int value) {
        matrix[i][j] = value;
    }

    public int getColumnSize() {
        return matrix.length;
    }

    public int getRowSize(int i) {
        return matrix[i].length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JaggedArray that = (JaggedArray) o;

        return Arrays.deepEquals(matrix, that.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JaggedArray{");
        sb.append("matrix=").append(Arrays.toString(matrix));
        sb.append('}');
        return sb.toString();
    }
}
