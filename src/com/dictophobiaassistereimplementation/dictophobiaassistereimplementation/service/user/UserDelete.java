package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service.user;

import java.sql.SQLException;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao.UserDAOImpl;

public class UserDelete {
	private static UserDelete userDelete = new UserDelete();

	public static UserDelete getInstance() {
		return userDelete;
	}

	public boolean delete(int uid) throws SQLException {
		return UserDAOImpl.getInstance().deleteUser(uid);
	}
}
