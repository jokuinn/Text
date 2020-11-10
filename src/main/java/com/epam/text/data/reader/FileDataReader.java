package com.epam.text.data.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileDataReader {
    public String read(String fileName) throws DataException {

        try {
            Path path = Paths.get(fileName);
            List<String> lines = Files.readAllLines(path);
            StringBuilder builder = new StringBuilder();
            lines.forEach(builder::append);

            return builder.toString();

        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }
}
