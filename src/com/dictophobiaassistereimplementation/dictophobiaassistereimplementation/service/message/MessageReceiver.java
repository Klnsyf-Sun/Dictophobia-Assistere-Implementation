package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service.message;

import java.sql.SQLException;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao.MessageDAOImpl;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto.Message;

public class MessageReceiver {
	private static MessageReceiver messageReceiver = new MessageReceiver();

	public static MessageReceiver getInstance() {
		return messageReceiver;
	}

	public boolean receive(Message message) throws SQLException {
		return MessageDAOImpl.getInstance().insertMessage(message);
	}
}
