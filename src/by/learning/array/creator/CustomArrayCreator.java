package by.learning.array.creator;

import by.learning.array.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class CustomArrayCreator {

    private static final Logger logger = LogManager.getLogger(CustomArrayCreator.class);

    public void fillArrayWithRandom(CustomArray customArray) {
        Random random = new Random();
        for (int i = 0; i < customArray.size(); i++) {
            int value = random.nextInt();
            customArray.setElement(i, value);
        }
    }

    public void fillArrayFromFileAndRandom(CustomArray customArray, File file) {
        Random random = new Random();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            for (int i = 0; i < customArray.size(); i++) {
                if (scanner.hasNextInt()) {
                    customArray.setElement(i, scanner.nextInt());
                } else {
                    customArray.setElement(i, random.nextInt());
                }
            }
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException was catch " + e);
        } finally {
            scanner.close();
        }
    }
}
