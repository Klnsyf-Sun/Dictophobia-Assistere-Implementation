package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service;

import java.sql.SQLException;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao.UserDAOImpl;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto.User;

public class UserQuery {
	private static UserQuery userQuery = new UserQuery();

	public static UserQuery getInstance() {
		return userQuery;
	}

	public User queryByUid(int uid) throws SQLException {
		return UserDAOImpl.getInstance().getUser(uid);
	}

	public User queryByUsername(String username) throws SQLException {
		return UserDAOImpl.getInstance().getUser(username);
	}
}
