package ru.netology;

import java.io.*;
import java.net.Socket;

public class Client {
    public Client() {
        Config config = new Config();

        try (Socket clientSocket = new Socket("localhost", config.getPort());
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true)
        ) {
            System.out.println("Добро пожаловать в чат!");
            System.out.print("Введите свой никнейм: ");
            out.println(reader.readLine());


            new MsgReader(clientSocket);
            while (!clientSocket.isOutputShutdown()) {
                String entry = reader.readLine();
                out.println(entry);
                if (entry.equals("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
