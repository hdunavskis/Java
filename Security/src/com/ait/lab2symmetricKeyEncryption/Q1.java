package com.ait.lab2symmetricKeyEncryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;

public class Q1 {

	public static void main(String[] args) {
		String algorithm = "AES";
		try {
			KeyGenerator keygen = KeyGenerator.getInstance(algorithm);
			SecretKey secretKey = keygen.generateKey();
			Cipher eCipher = Cipher.getInstance(algorithm);
			
			//initialize the cipher for encryption
			eCipher.init(Cipher.ENCRYPT_MODE, secretKey);
			
			String text = "This is just an example";
			System.out.println("Clear text: " + text);
			byte[]clearText = text.getBytes();
			
			//Encrypt the clearText
			byte[]cipherText = eCipher.doFinal(clearText);
			
			//Decrypt
			Cipher dChiper = Cipher.getInstance(algorithm);
			dChiper.init(Cipher.DECRYPT_MODE, secretKey);
			
			//Decreypt the cypher text
			byte[]clearText1 = dChiper.doFinal(cipherText);
			
			String t = new String(clearText);
			System.out.println("Decrypted text: " + t);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
