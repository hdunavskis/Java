package com.ait.digitalCert;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class C1 {

	public static void main(String[] args) {
		try {

			String keystoreFilename = "helmuts";
			char[] password = "kkkk".toCharArray();
			String alias = "helmuts";
			FileInputStream fIn = new FileInputStream(keystoreFilename);
			KeyStore keystore = KeyStore.getInstance("JKS");
			keystore.load(fIn, password);
			Certificate cert;
			cert = keystore.getCertificate(alias);
			System.out.println(cert);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
