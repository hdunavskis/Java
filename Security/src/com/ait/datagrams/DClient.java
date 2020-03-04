package com.ait.datagrams;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class DClient {

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(2012);
		String greeting = "Hello There";
		
		byte[] buf = greeting.getBytes();
		
		InetAddress inetAddress = InetAddress.getByName("localhost");
		DatagramPacket packet = new DatagramPacket(buf, buf.length, inetAddress, 2000);
		try {
				
			socket.setSoTimeout(5000);
			socket.send(packet);
			
		} catch (SocketTimeoutException e) {
			System.out.println("Socket timeout, resending");
			//socket.send(packet);
		}
	}
}
