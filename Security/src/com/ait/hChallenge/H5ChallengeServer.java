package com.ait.hChallenge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class H5ChallengeServer {

    public static void writeToFile(String filename, Object object){
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(filename);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(object);
            oout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static Object readFromFile(String filename){
        FileInputStream fin = null;
        Object object = null;
        try {
            fin = new FileInputStream(filename);
            ObjectInputStream oin = new ObjectInputStream(fin);
            object = oin.readObject();
            oin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }
	public static void main(String[] args) {
		try {
			String challenge = "We give up, come and rule us";
			//generate a secret key
			KeyGenerator kg = KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk = kg.generateKey();
			
			writeToFile("data/secretKey", sk);
			
			// calculate the correct response to challenge
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(sk);
			byte[] correctRespnse = mac.doFinal(challenge.getBytes());
			
			//Accept connection from client
			Socket socket;
			ServerSocket serverSocket = new ServerSocket(2000);
			
			System.out.println("Server waiting for conection...");
			socket = serverSocket.accept();
			
			InputStream inputStream = socket.getInputStream();
	        Scanner scanner = new Scanner(inputStream);
	        OutputStream outputStream = socket.getOutputStream();
	        PrintWriter printWriter = new PrintWriter(outputStream);

	        //send challenge
	        printWriter.println(challenge);
	        printWriter.flush();
	        
	        //read response from client
	        String reply = scanner.nextLine();
	        byte[] clientHMac = Base64.getDecoder().decode(reply);
	      
	        //compare the hmac received from the client with the hmac calculated. 
	        //If they mathc send a message "success"
	        //If they dont match send a message "fails"
	        
	        if(Arrays.equals(correctRespnse, clientHMac)) {
	        	printWriter.println("Success");
	        }
	        else {
	        	printWriter.println("Fail");
	        }
	        printWriter.flush();
	        
	        //printWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
