package ru.netology;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
    private int port;

    public Config() {
        try (FileInputStream fis = new FileInputStream("src/config.properties")) {
            Properties prop = new Properties();
            prop.load(fis);
            port = Integer.parseInt(prop.getProperty("SERVER_PORT"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getPort() {
        return port;
    }
}

