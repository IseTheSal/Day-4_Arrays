package by.learning.array.service;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayCheckTest {

    ArrayCheckService arrayCheck = new ArrayCheckService();

    @Test
    public void testIsPrimeNumberTrue() {
        int number = 17;
        boolean condition = arrayCheck.isPrimeNumber(number);
        Assert.assertTrue(condition);
    }

    @Test
    public void testIsPrimeNumberFalse() {
        int number = 0;
        boolean condition = arrayCheck.isPrimeNumber(number);
        Assert.assertFalse(condition);
    }


    @Test
    public void testIsFibonacciNumberTrue() {
        int fibonacciNumber = 10946;
        boolean condition = arrayCheck.isFibonacciNumber(fibonacciNumber);
        Assert.assertTrue(condition);
    }

    @Test
    public void testIsFibonacciNumberFalse() {
        int notFibonacciNumber = 10947;
        boolean condition = arrayCheck.isFibonacciNumber(notFibonacciNumber);
        Assert.assertFalse(condition);
    }

    @Test
    public void testContainSameDigitsTrue() {
        int number = 5567;
        boolean condition = arrayCheck.containSameDigits(number);
        Assert.assertTrue(condition);
    }

    @Test
    public void testContainSameDigitsFalse() {
        int number = 1234567;
        boolean condition = arrayCheck.containSameDigits(number);
        Assert.assertFalse(condition);
    }
}