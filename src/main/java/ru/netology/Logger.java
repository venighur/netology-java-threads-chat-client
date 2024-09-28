package ru.netology;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Logger {
    private final FileOutputStream fos;

    public Logger() throws FileNotFoundException {
        fos = new FileOutputStream("file.log", true);
    }

    public void writeLog(String text) throws IOException {
        byte[] bytes = text.getBytes();
        fos.write(bytes);
    }
}
