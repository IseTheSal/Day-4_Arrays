package by.learning.task1.writer;


import by.learning.task1.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayWriter {

    private static final Logger logger = LogManager.getLogger(ArrayWriter.class);

    public void arrayWriter(CustomArray customArray) {
        for (int i = 0; i < customArray.size(); i++) {
            logger.info(i + " - " + customArray.getElement(i) + "\n");
        }
    }

}
