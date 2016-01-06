package com.qualcomm.ftcrobotcontroller;

/**
 * Created by adam on 12/2/15.
 */


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Event {


	public Event() {

		try {
			this.addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			;
		}
	}

	private static int port = 6157;
	private static DataInputStream dataInputStream;
	private static String str;
	private static InetAddress addr;


	public static String sendEventGetPath() {

		if (addr != null) {
			try {

				Socket ioSoc = new Socket(addr, port);
				ioSoc.wait(1000);
				BufferedReader i = new BufferedReader(new InputStreamReader(ioSoc.getInputStream()));
				str = i.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


		} else {
			return "ERROR";
		}

		return str;
	}


}
