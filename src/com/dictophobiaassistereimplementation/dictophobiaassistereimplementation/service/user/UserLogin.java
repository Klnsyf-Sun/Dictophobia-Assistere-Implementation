package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service.user;

import java.sql.SQLException;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao.UserDAOImpl;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto.User;

public class UserLogin {
	private static UserLogin userLogin = new UserLogin();

	public static UserLogin getInstance() {
		return userLogin;
	}

	public int login(String username, String password) throws SQLException {
		User user = UserDAOImpl.getInstance().getUser(username);
		if (user == null) {
			return -1;
		} else if (user.getPassword().equals(password)) {
			UserDAOImpl.getInstance().updateOnlineState(user.getUid(), true);
			return user.getUid();
		} else {
			return 0;
		}
	}
}
