package by.learning.array.service;

import by.learning.array.entity.JaggedArray;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JaggedArraySortTest {

    JaggedArraySort jaggedArraySort = new JaggedArraySort();
    JaggedArray jaggedArray;

    @BeforeClass
    public void fillMatrix() {
        int[][] matrix = new int[][]{{14, 16}, {7, 8, 9}, {2, 3}};
        jaggedArray = new JaggedArray(matrix);
    }


    @Test
    public void testChooseSortMethodByMaxElement() {
        boolean ascending = false;
        jaggedArraySort.chooseSortMethod(jaggedArray, "sortByMaxElement", ascending);
        JaggedArray actual = jaggedArray;
        int[][] matrix = new int[][]{{14, 16}, {7, 8, 9}, {2, 3}};
        JaggedArray expected = new JaggedArray(matrix);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testChooseSortMethodBySum() {
        boolean ascending = true;
        jaggedArraySort.chooseSortMethod(jaggedArray, "sortBySum", ascending);
        JaggedArray actual = jaggedArray;
        int[][] matrix = new int[][]{{2, 3}, {7, 8, 9}, {14, 16}};
        JaggedArray expected = new JaggedArray(matrix);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testChooseSortMethodByMixElement() {
        boolean ascending = false;
        jaggedArraySort.chooseSortMethod(jaggedArray, "sortByMinElement", ascending);
        JaggedArray actual = jaggedArray;
        int[][] matrix = new int[][]{{14, 16}, {7, 8, 9}, {2, 3}};
        JaggedArray expected = new JaggedArray(matrix);
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void setJaggedArrayNull() {
        jaggedArray = null;
    }


}