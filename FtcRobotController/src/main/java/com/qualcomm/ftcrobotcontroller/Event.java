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


public class Event{

	Socket socket;
	InetAddress addr;

	public Event (){

		try {
			addr = InetAddress.getLocalHost();

		}catch (UnknownHostException u){
			u.printStackTrace();
		}

	}

	public void sendEvent () {
		try {
			socket = new Socket(addr, 6157);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
