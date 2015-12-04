package com.qualcomm.ftcrobotcontroller;

/**
 * Created by adam on 12/2/15.
 */

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Event {
	private static InetAddress addr;
	private static int port = 6157;
	static {
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	public static void sendEvent () {
		try {
			Socket socket = new Socket(addr, port);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
