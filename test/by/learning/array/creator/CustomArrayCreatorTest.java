package by.learning.array.creator;

import by.learning.array.entity.CustomArray;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class CustomArrayCreatorTest {

    CustomArrayCreator customArrayCreator = new CustomArrayCreator();
    CustomArray customArray;
    final String path = "data\\fillArray.txt";
    @BeforeMethod
    public void createCustomArray() {
        customArray = new CustomArray(2);
    }

    @Test
    public void testFillArrayFromFileAndRandom() {
        File file = new File(path);
        customArrayCreator.fillArrayFromFileAndRandom(customArray, file);
        CustomArray actual = customArray;
        CustomArray expected = new CustomArray(2);
        expected.setElement(0, 3);
        expected.setElement(1, 4);
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void setCustomArrayNull() {
        customArray = null;
    }
}