package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(8080);
		boolean flag=true;
		while(flag) {
			new java.lang.Thread(new Thread(server.accept())).start();
		}
		server.close();
	}
}
