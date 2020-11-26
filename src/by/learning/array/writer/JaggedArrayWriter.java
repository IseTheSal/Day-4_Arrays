package by.learning.array.writer;

import by.learning.array.entity.JaggedArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JaggedArrayWriter {

    private static final Logger logger = LogManager.getLogger(JaggedArrayWriter.class);

    public void jaggedArrayWriter(JaggedArray jaggedArray) {
        for (int i = 0; i < jaggedArray.getColumnSize(); i++) {
            for (int j = 0; j < jaggedArray.getRowSize(i); j++) {
                logger.info("Element - " + i + " " + j + ":" + jaggedArray.getElement(i, j));
            }
        }
    }
}
