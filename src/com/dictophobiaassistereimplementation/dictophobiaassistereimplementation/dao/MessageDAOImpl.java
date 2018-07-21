package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.datasource.MySQL;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto.Message;

public class MessageDAOImpl implements MessageDAO {
	private static MessageDAOImpl messageDAOImpl = new MessageDAOImpl();

	public static MessageDAOImpl getInstance() {
		return messageDAOImpl;
	}

	@Override
	public boolean insertMessage(Message message) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Connection conn = MySQL.getConnection();
		Statement stmt = conn.createStatement();
		sql.append("INSERT INTO messages(postBy,getBy,shell,ghost,hasGhost,duration,showDuration) VALUES (")
				.append(message.getPostBy()).append(",").append(message.getGetBy()).append(",'")
				.append(message.getShell()).append("','").append(message.getGhost()).append("',")
				.append(message.isHasGhost() ? 1 : 0).append(",").append(message.getDuration()).append(",")
				.append(message.isShowDuration() ? 1 : 0).append(")");
		stmt.execute(sql.toString());
		MySQL.close();
		return true;
	}

	@Override
	public List<Message> getMessages(int uid) throws SQLException {
		List<Message> messages = new LinkedList<>();
		StringBuffer sql = new StringBuffer();
		Connection conn = MySQL.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rsts;
		sql.append("SELECT * FROM messages WHERE postBy=").append(uid);
		rsts = stmt.executeQuery(sql.toString());
		if (!rsts.next()) {
		} else {
			do {
				messages.add(new Message(rsts.getInt("mid"), rsts.getInt("postBy"), rsts.getInt("getBy"),
						rsts.getString("shell"), rsts.getString("ghost"), rsts.getBoolean("hasGhost"),
						rsts.getTimestamp("time"), rsts.getInt("duration"), rsts.getBoolean("showDuration")));
			} while (rsts.next());
		}
		sql.setLength(0);
		sql.append("SELECT * FROM messages WHERE getBy=").append(uid);
		rsts = stmt.executeQuery(sql.toString());
		if (!rsts.next()) {
		} else {
			do {
				messages.add(new Message(rsts.getInt("mid"), rsts.getInt("postBy"), rsts.getInt("getBy"),
						rsts.getString("shell"), rsts.getString("ghost"), rsts.getBoolean("hasGhost"),
						rsts.getTimestamp("time"), rsts.getInt("duration"), rsts.getBoolean("showDuration")));
			} while (rsts.next());
		}
		MySQL.close();
		return messages;
	}

}
