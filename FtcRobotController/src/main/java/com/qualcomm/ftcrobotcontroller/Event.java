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

	private static int port = 6157;
	private static String str;
	public static InetAddress addr;
	public static String sendEventGetPath() {

		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		if (addr != null) {
			try {

				Socket ioSoc = new Socket(addr, port);
				BufferedReader i = new BufferedReader(new InputStreamReader(ioSoc.getInputStream()));
				str = i.readLine();
				while (str.isEmpty()) {
					str = i.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		} else {
			return "ERROR, Address Null";
		}
	}
}
