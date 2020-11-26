package by.learning.array.service;

import by.learning.array.entity.CustomArray;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ArraySearchTest {

    ArraySearch arraySearch = new ArraySearch();
    CustomArray customArray;

    @BeforeClass
    public void fillCustomArray() {
        int[] array = new int[]{4, 5, 123, 12, 54, 2, -2, 124, 0, 45, 1251, 122, 5346, 5345, 324, 4181, 153};
        customArray = new CustomArray(array);
    }

    @BeforeMethod(onlyForGroups = {"sort"})
    public void sortArray() {
        ArraySort arraySort = new ArraySort();
        int start = 0;
        int end = customArray.size() - 1;
        arraySort.quickSort(customArray, start, end);
    }

    @Test
    public void testReceiveMaxValueEquals() {
        int actual = arraySearch.receiveMaxValue(customArray);
        int expected = 5346;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testReceiveMaxValueNotEquals() {
        int actual = arraySearch.receiveMaxValue(customArray);
        int expected = 5345;
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void testReceiveMaxIndex() {
        int actual = arraySearch.receiveMaxValueIndex(customArray);
        int expected = 12;
        Assert.assertSame(actual, expected);
    }

    @Test
    public void testReceiveMinValue() {
        int actual = arraySearch.receiveMinValue(customArray);
        int expected = -2;
        Assert.assertSame(actual, expected);
    }

    @Test(groups = "sort")
    public void testReceiveMinIndex() {
        int actual = arraySearch.receiveMinValueIndex(customArray);
        int expected = 0;
        Assert.assertSame(actual, expected);
    }

    @Test
    public void testBinarySearchIndex() {
        int key = -2;
        int actual = arraySearch.binarySearchIndex(customArray, key);
        int expected = 0;
        Assert.assertSame(actual, expected);
    }

    @Test
    public void testReceiveFibonacciAmount() {
        int actual = arraySearch.receiveFibonacciAmount(customArray);
        int expected = 4;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "sort")
    public void testReceiveFibonacciArray() {
        int[] actual = arraySearch.receiveFibonacciArray(customArray);
        int[] expected = new int[]{0, 2, 5, 4181};
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testReceiveDigitsAmountFirst() {
        int number = 56445;
        int actual = arraySearch.receiveDigitsAmount(number);
        Assert.assertEquals(actual, 5);
    }

    @Test
    public void testReceiveDigitsAmountSecond() {
        int number = 0;
        int actual = arraySearch.receiveDigitsAmount(number);
        Assert.assertEquals(actual, 1);
    }

    @Test
    public void testReceiveAmountWithNotSameDigitsAmount() {
        int actual = arraySearch.receiveAmountWithoutSameDigitsAmount(customArray, 3);
        int expected = 4;
        Assert.assertSame(actual, expected);
    }

    @Test(groups = "sort")
    public void testReceiveNumbersWithNotSameDigitsAmount() {
        int[] actual = arraySearch.receiveNumbersWithoutSameDigitsAmount(customArray, 3);
        int[] expected = new int[]{123, 124, 153, 324};
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void setCustomArrayNull() {
        customArray = null;
    }
}