package com.ait.lab2symmetricKeyEncryption;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class Q2 {

	public static void main(String[] args) {
		
		Cipher cipher;
		try {
			String algo = "AES";
			KeyGenerator keygen = KeyGenerator.getInstance(algo);
			SecretKey secretKey = keygen.generateKey();
			
			cipher = Cipher.getInstance(algo);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			Employee emp = new Employee("name", "address", "phone");
			SealedObject so = new SealedObject(emp, cipher);
			//object so can be stored encrypted
			
			//Decrypt
			Cipher dCipher = Cipher.getInstance(algo);
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
