package com.lezenford.io.client;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    private final static ExecutorService THREAD_POOL = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        try {
            new Client().start();
        } finally {
            THREAD_POOL.shutdown();
        }
    }

    public void start() {
        for (int i = 0; i < 5; i++) {
            THREAD_POOL.submit(() -> {
                try (Socket socket = new Socket("localhost", 9000);
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                    while (true) {
                        String threadName = Thread.currentThread().getName();
                        System.out.println("Client started on thread: " + threadName);
                        writer.write("Message from " + threadName);
                        writer.newLine();
                        writer.flush();
                        Thread.sleep(1000);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
