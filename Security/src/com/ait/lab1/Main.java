package com.ait.lab1;

import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class Main {

    public static void q1(){
        String password = "randompassword";
        MessageDigest algorithm = null;
        try {
            algorithm = MessageDigest.getInstance("SHA-256");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        algorithm.reset();
        algorithm.update(password.getBytes());
        byte[] messageDigest = algorithm.digest();
        System.out.println("length: " + messageDigest.length);
        String encodedDigest = Base64.getEncoder().encodeToString(messageDigest);
        System.out.println("Base64 encoded message digest " + encodedDigest);

        String newPassword = "randomPasswor";

        algorithm.reset();
        algorithm.update(newPassword.getBytes());
        messageDigest = algorithm.digest();

        System.out.println("length: " + messageDigest.length);
        encodedDigest = Base64.getEncoder().encodeToString(messageDigest);
        System.out.println("Base64 encoded message digest " + encodedDigest);
    }
    public static void q2()  {
        try {
            InputStream is = new FileInputStream("data/test");
            byte[] buffer = new byte[64];
            int bytesRead = 0;
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            while ((bytesRead = is.read(buffer)) > 0) {

                algorithm.update(buffer, 0, bytesRead);
                // System.out.println(bytesRead);
            }
            byte[] digest = algorithm.digest();
            String encoded = Base64.getEncoder().encodeToString(digest);
            System.out.println("Basae64 encoded: " + encoded);
            is.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void q3(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGenerator.generateKey();

            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKey);

            byte[] result = mac.doFinal("Stuff".getBytes());
            System.out.println(result.length);

            //Receiver
            Mac mac2 = Mac.getInstance("HmacSHA256");
            mac2.init(secretKey);
            byte[] result2 = mac.doFinal("Stuff".getBytes());

            System.out.println("Check: " + Arrays.equals(result,result2));

        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

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
    public static void q4(){
        try {
            String sendingData = "Test";
            //write a secret key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGenerator.generateKey();
            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            //write a message
            writeToFile("data/secretKey", encodedKey);
            // write hmac
            writeToFile("data/sendText.txt", sendingData);

            byte[] textArray = sendingData.getBytes();
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKey);
            byte[] hmac = mac.doFinal(textArray);
            String encodedHmac = Base64.getEncoder().encodeToString(hmac);

            writeToFile("data/hmac", encodedHmac);
            System.out.println(hmac.length);
            System.out.println("Base64 encoded message digest: " + encodedHmac);

            //read from the file
            String readEncodedKey = (String) readFromFile("data/secretKey");
            byte[] decodedKey = Base64.getDecoder().decode(readEncodedKey);
            SecretKey key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "HmacSHA256");

            String readHcodedHmac = (String) readFromFile("data/hmac");
            byte[] sentHmac = Base64.getDecoder().decode(readHcodedHmac);
            String sendText = (String) readFromFile("data/sendText.txt");
            //hmac calculate
            Mac mac2 = Mac.getInstance("HmacSHA256");
            mac2.init(secretKey);
            byte[] myHmac = mac.doFinal(sendText.getBytes());
            // check hmac
            System.out.println("Check: " + Arrays.equals(sentHmac, myHmac));


        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        //q1();
        //q2();
        //q3();
        q4();
    }
}
