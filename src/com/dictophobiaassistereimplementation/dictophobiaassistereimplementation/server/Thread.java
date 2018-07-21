package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto.Message;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto.User;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service.message.MessageGetter;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service.message.MessageReceiver;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service.user.UserDelete;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service.user.UserQuery;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service.user.UserRegister;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service.user.UserUpdate;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Thread implements Runnable {
	private Socket client;
	private Gson gson = new Gson();

	public Thread(Socket client) {
		this.client = client;
	}

	public void run() {
		try {
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintStream cout = new PrintStream(client.getOutputStream());
			JsonParser parser = new JsonParser();
			JsonObject object;
			String str = buf.readLine();
			if (str == null) {
			} else {
				object = (JsonObject) parser.parse(str);
				System.out.println(object);
				if (object.get("object").getAsString() == null || object.get("type").getAsString() == null) {
					cout.println(-1);
				} else {
					int uid;
					String username;
					String password;
					boolean isOnline;
					Blob icon;
					switch (object.get("object").getAsString()) {
					case "user":
						switch (object.get("type").getAsString()) {
						case "register":
							User user = gson.fromJson(object, User.class);
							cout.println(UserRegister.getInstance().register(user));
							break;
						case "queryByUid":
							uid = object.get("uid").getAsInt();
							cout.println(gson.toJson(UserQuery.getInstance().queryByUid(uid)));
							break;
						case "queryByUsername":
							username = object.get("username").getAsString();
							cout.println(gson.toJson(UserQuery.getInstance().queryByUsername(username)));
							break;
						case "delete":
							uid = object.get("uid").getAsInt();
							cout.println(UserDelete.getInstance().delete(uid));
							break;
						case "updateUsername":
							uid = object.get("uid").getAsInt();
							username = object.get("username").getAsString();
							cout.println(UserUpdate.getInstance().updateUsername(uid, username));
							break;
						case "updatePassword":
							uid = object.get("uid").getAsInt();
							password = object.get("password").getAsString();
							cout.println(UserUpdate.getInstance().updatePassword(uid, password));
							break;
						case "updateOnlineState":
							uid = object.get("uid").getAsInt();
							isOnline = object.get("isOnline").getAsBoolean();
							cout.println(UserUpdate.getInstance().updateOnlineState(uid, isOnline));
							break;
						case "updateIcon":
							uid = object.get("uid").getAsInt();
							icon = (Blob) object.get("icon").getAsBigDecimal();
							cout.println(UserUpdate.getInstance().updateIcon(uid, icon));
							break;
						default:
							cout.println(-1);
							break;
						}
						break;
					case "message":
						switch (object.get("type").getAsString()) {
						case "receive":
							Message message = gson.fromJson(object, Message.class);
							cout.println(MessageReceiver.getInstance().receive(message));
							break;
						case "get":
							uid = object.get("uid").getAsInt();
							List<Message> messages = MessageGetter.getInstance().get(uid);
							for (Message msg : messages) {
								cout.println(gson.toJson(msg));
							}
							break;
						default:
							cout.println(-1);
							break;
						}
						break;
					default:
						cout.println(-1);
						break;
					}
				}
			}
			cout.close();
			client.close();
		} catch (JsonSyntaxException | IOException | SQLException e) {
			e.printStackTrace();
		}
		return;

	}

}
