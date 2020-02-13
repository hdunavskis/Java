package com.ait.lab2symmetricKeyEncryption;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class q3b {
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
	public static void main(String[]args) {
		
		Cipher cipher;
		try {
			SecretKey secretKey = (SecretKey)readFromFile("data/secretKey");
			SealedObject so = (SealedObject)readFromFile("data/sealedObject.dat");
			//Decrypt
			Cipher dCipher = Cipher.getInstance("AES");
			dCipher.init(Cipher.DECRYPT_MODE, secretKey);
			
			Employee em = (Employee) so.getObject(dCipher);
			
			System.out.println(em.getName());
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
