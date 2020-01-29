package com.ait.lab2Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        Socket socket;
        try {
            ServerSocket serverSocket = new ServerSocket(2000);
            while (true){
                System.out.println("Server: waiting for connection..");
                socket = serverSocket.accept();

                InputStream inputStream = socket.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream);

                String inputLine = scanner.nextLine();

                printWriter.println("Hello " + inputLine + " from hello server");
                printWriter.close();

            }



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
