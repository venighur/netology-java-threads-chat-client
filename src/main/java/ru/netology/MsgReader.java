package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

public class MsgReader extends Thread {
    private final Socket socket;

    public MsgReader(Socket socket) {
        this.socket = socket;
        start();
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            Logger logger = new Logger();
            String entry;

            while (!socket.isOutputShutdown()) {
                entry = in.readLine();
                System.out.println(entry);
                logger.writeLog(new Date() + " - " + entry + "\n");
            }

        } catch (IOException e) {
            System.out.println("read error");
            System.out.println(e.getMessage());
        }
    }
}
