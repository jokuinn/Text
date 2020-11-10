package com.epam.text.data.reader;


import org.junit.Assert;
import org.junit.Test;

public class FileDataReaderTest {

    private static final String FILE_NAME = "src/test/resources/text.txt";
    private static final String LINE = "It is a [4 5+] established fact that a reader will be of a page when looking at is layout.";

    @Test
    public void testReadShouldReturnStringWhenDataIsCorrect() throws DataException{
        FileDataReader reader = new FileDataReader();

        String actual = reader.read(FILE_NAME);

        Assert.assertEquals(LINE, actual);
    }

}
