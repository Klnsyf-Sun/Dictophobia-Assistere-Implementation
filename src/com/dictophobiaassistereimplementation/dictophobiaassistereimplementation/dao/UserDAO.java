package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto.User;

public interface UserDAO {
	public boolean insertUser(User user) throws SQLException;

	public boolean deleteUser(int uid) throws SQLException;

	public boolean updateUsername(int uid, String username) throws SQLException;

	public boolean updatePassword(int uid, String password) throws SQLException;

	public boolean updateOnlineState(int uid, boolean isOnline) throws SQLException;

	public boolean updateIcon(int uid, Blob icon) throws SQLException;

	public User getUser(int uid) throws SQLException;

	public User getUser(String username) throws SQLException;

	public List<User> getOnlineUsers() throws SQLException;
}
