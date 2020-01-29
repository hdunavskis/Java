package com.ait.lab2Sockets;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception{

        InetAddress inetAddress = InetAddress.getByName("localhost");
        Socket socket = new Socket(inetAddress, 2000);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(inputStream);

        printWriter.println("Test");
        printWriter.flush();

        String inputLine = scanner.nextLine();
        System.out.println("Client: " + inputLine);
    }
}
