package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service.message;

import java.sql.SQLException;
import java.util.List;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao.MessageDAOImpl;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto.Message;

public class MessageGetter {

	private static MessageGetter messageGetter = new MessageGetter();

	public static MessageGetter getInstance() {
		return messageGetter;
	}

	public List<Message> get(int uid) throws SQLException {
		return MessageDAOImpl.getInstance().getMessages(uid);
	}
}
