package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao;

import java.sql.SQLException;
import java.util.List;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto.Message;

public interface MessageDAO {
	public boolean insertMessage(Message message) throws SQLException;

	public List<Message> getMessages(int uid) throws SQLException;
}
