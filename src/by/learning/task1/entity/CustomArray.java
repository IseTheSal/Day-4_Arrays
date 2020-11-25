package by.learning.task1.entity;


import java.util.Arrays;

public class CustomArray {

    private int[] array;

    public CustomArray(int[] array) {
        this.array = array;
    }

    public CustomArray(int length) {
        this.array = new int[length];
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getElement(int index) {
        if (index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void setElement(int index, int value) {
        if (index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }

    public int size() {
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomArray that = (CustomArray) o;

        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomArray{");
        sb.append("array=").append(Arrays.toString(array));
        sb.append('}');
        return sb.toString();
    }
}
