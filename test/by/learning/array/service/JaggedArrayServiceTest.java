package by.learning.array.service;

import by.learning.array.entity.JaggedArray;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JaggedArrayServiceTest {

    JaggedArrayService jaggedArrayService = new JaggedArrayService();
    JaggedArray jaggedArray;

    @BeforeClass
    public void fillMatrix() {
        int[][] matrix = new int[][]{{456, 23423, 1233, 25, 231, 654}, {1, 2}, {-4, 25235, 123234}};
        jaggedArray = new JaggedArray(matrix);
    }

    @Test
    public void testReceiveMaxElementInRow() {
        int actual = jaggedArrayService.receiveMaxElementInRow(jaggedArray, 0);
        int expected = 23423;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testReceiveMinElementInRow() {
        int actual = jaggedArrayService.receiveMinElementInRow(jaggedArray, 2);
        int expected = -4;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testReceiveSumInRow() {
        int actual = jaggedArrayService.receiveSumInRow(jaggedArray, 1);
        int expected = 3;
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void setJaggedArrayNull() {
        jaggedArray = null;
    }
}