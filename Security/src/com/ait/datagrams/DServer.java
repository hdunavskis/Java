package com.ait.datagrams;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

public class DServer {

	public static void main(String[] args) {
		
		try (DatagramSocket socket = new DatagramSocket(2000);){
			
			byte[] buf = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
			System.out.println("Waiting for a DatagramPacket");
			socket.receive(receivePacket);
			InetAddress inetAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
			System.out.println(message + " from " + inetAddress.getHostAddress() + " senders port " + port);
			// send a new message back to sender socket.send(message);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}
