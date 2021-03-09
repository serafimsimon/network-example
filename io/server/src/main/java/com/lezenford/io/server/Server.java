package com.lezenford.io.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final static ExecutorService THREAD_POOL = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws IOException {
        try {
            new Server().start();
        } finally {
            THREAD_POOL.shutdownNow();
        }
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("Server started");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accept new incoming connection");
            THREAD_POOL.execute(() -> {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    System.out.printf("[%s] new incoming connect%n", Thread.currentThread().getName());
                    while (true) {
                        String message = bufferedReader.readLine();
                        System.out.printf("[%s] incoming data: %s%n", Thread.currentThread().getName(), message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
