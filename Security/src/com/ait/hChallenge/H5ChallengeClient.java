package com.ait.hChallenge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class H5ChallengeClient {
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
	public static void main (String[] args) {
		
		try {
			SecretKey secretKey = (SecretKey) readFromFile("data/secretKey");
			InetAddress inetAddress = InetAddress.getByName("localhost");
	        Socket socket = new Socket(inetAddress, 2000);
			InputStream inputStream = socket.getInputStream();
	        Scanner scanner = new Scanner(inputStream);
	        OutputStream outputStream = socket.getOutputStream();
	        PrintWriter printWriter = new PrintWriter(outputStream);
	       
	        String inputLine = scanner.nextLine();
	        System.out.println(inputLine);
	        //Hmac it using the secret key
	        Mac mac = Mac.getInstance("HmacSHA256");
	        
			mac.init(secretKey);
			byte[] hmac = mac.doFinal(inputLine.getBytes());
			//base64 encode the hmac
				
			String hmacEncoded = Base64.getEncoder().encodeToString(hmac);
			printWriter.println(hmacEncoded);
			printWriter.flush();
				
			//have we passed
			String reply = scanner.nextLine();
			System.out.println(reply);
			//socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}

}
