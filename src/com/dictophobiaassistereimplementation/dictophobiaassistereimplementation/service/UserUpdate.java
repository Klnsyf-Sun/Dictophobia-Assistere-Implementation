package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service;

import java.sql.Blob;
import java.sql.SQLException;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao.UserDAOImpl;

public class UserUpdate {
	private static UserUpdate userUpdate = new UserUpdate();

	public static UserUpdate getInstance() {
		return userUpdate;
	}

	public boolean updateUsername(int uid, String username) throws SQLException {
		return UserDAOImpl.getInstance().updateUsername(uid, username);
	}

	public boolean updatePassword(int uid, String password) throws SQLException {
		return UserDAOImpl.getInstance().updatePassword(uid, password);
	}

	public boolean updateOnlineState(int uid, boolean isOnline) throws SQLException {
		return UserDAOImpl.getInstance().updateOnlineState(uid, isOnline);
	}

	public boolean updateIcon(int uid, Blob icon) throws SQLException {
		return UserDAOImpl.getInstance().updateIcon(uid, icon);
	}

}
