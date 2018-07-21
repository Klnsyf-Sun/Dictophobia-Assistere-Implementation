package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.datasource.MySQL;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto.User;

public class UserDAOImpl implements UserDAO {
	private static UserDAOImpl userDAOImpl = new UserDAOImpl();

	private UserDAOImpl() {
	}

	public static UserDAOImpl getInstance() {
		return userDAOImpl;
	}

	@Override
	public boolean insertUser(User user) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Connection conn = MySQL.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rsts;
		if (user.getUid() != -1) {
			sql.append("SELECT uid FROM users WHERE uid=").append(user.getUid());
			rsts = stmt.executeQuery(sql.toString());
			if (rsts.next()) {
				MySQL.close();
				return false;
			}
		}
		sql.setLength(0);
		sql.append("SELECT username FROM users WHERE username='").append(user.getUsername()).append("'");
		rsts = stmt.executeQuery(sql.toString());
		if (rsts.next()) {
			MySQL.close();
			return false;
		}
		sql.setLength(0);
		sql.append("INSERT INTO users(").append(user.getUid() != -1 ? "uid," : "").append("username,password)")
				.append(" VALUES ").append("('").append(user.getUid() != -1 ? user.getUid() + "','" : "")
				.append(user.getUsername()).append("','").append(user.getPassword()).append("')");
		stmt.execute(sql.toString());
		MySQL.close();
		return true;
	}

	@Override
	public boolean deleteUser(int uid) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Connection conn = MySQL.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rsts;
		sql.append("SELECT uid FROM users WHERE uid=").append(uid);
		rsts = stmt.executeQuery(sql.toString());
		if (!rsts.next()) {
			MySQL.close();
			return false;
		} else {
			sql.setLength(0);
			sql.append("DELETE FROM users WHERE uid=").append(uid);
			stmt.execute(sql.toString());
			MySQL.close();
			return true;
		}
	}

	@Override
	public boolean updateUsername(int uid, String username) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Connection conn = MySQL.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rsts;
		sql.append("SELECT uid FROM users WHERE uid=").append(uid);
		rsts = stmt.executeQuery(sql.toString());
		if (!rsts.next()) {
			MySQL.close();
			return false;
		} else {
			sql.setLength(0);
			sql.append("UPDATE users SET username='").append(username).append("' WHERE uid=").append(uid);
			stmt.execute(sql.toString());
			MySQL.close();
			return true;
		}
	}

	@Override
	public boolean updatePassword(int uid, String password) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Connection conn = MySQL.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rsts;
		sql.append("SELECT uid FROM users WHERE uid=").append(uid);
		rsts = stmt.executeQuery(sql.toString());
		if (!rsts.next()) {
			MySQL.close();
			return false;
		} else {
			sql.setLength(0);
			sql.append("UPDATE users SET password='").append(password).append("' WHERE uid=").append(uid);
			stmt.execute(sql.toString());
			MySQL.close();
			return true;
		}
	}

	@Override
	public boolean updateOnlineState(int uid, boolean isOnline) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Connection conn = MySQL.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rsts;
		sql.append("SELECT uid FROM users WHERE uid=").append(uid);
		rsts = stmt.executeQuery(sql.toString());
		if (!rsts.next()) {
			MySQL.close();
			return false;
		} else {
			sql.setLength(0);
			sql.append("UPDATE users SET isOnline=").append(isOnline ? 1 : 0).append(" WHERE uid=").append(uid);
			stmt.execute(sql.toString());
			MySQL.close();
			return true;
		}
	}

	@Override
	public boolean updateIcon(int uid, Blob icon) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Connection conn = MySQL.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rsts;
		sql.append("SELECT uid FROM users WHERE uid=").append(uid);
		rsts = stmt.executeQuery(sql.toString());
		if (!rsts.next()) {
			MySQL.close();
			return false;
		} else {
			sql.setLength(0);
			sql.append("UPDATE users SET icon='").append(icon).append("' WHERE uid=").append(uid);
			stmt.execute(sql.toString());
			MySQL.close();
			return true;
		}
	}

	@Override
	public User getUser(int uid) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Connection conn = MySQL.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rsts;
		sql.append("SELECT * FROM users WHERE uid=").append(uid);
		rsts = stmt.executeQuery(sql.toString());
		if (!rsts.next()) {
			MySQL.close();
			return null;
		} else {
			User user = new User(rsts.getInt("uid"), rsts.getString("username"), rsts.getString("password"),
					rsts.getTimestamp("regTime"), rsts.getBoolean("isOnline"), rsts.getBlob("icon"));
			MySQL.close();
			return user;
		}
	}

	@Override
	public User getUser(String username) throws SQLException {
		StringBuffer sql = new StringBuffer();
		Connection conn = MySQL.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rsts;
		sql.append("SELECT * FROM users WHERE username='").append(username).append("'");
		rsts = stmt.executeQuery(sql.toString());
		if (!rsts.next()) {
			MySQL.close();
			return null;
		} else {
			User user = new User(rsts.getInt("uid"), rsts.getString("username"), rsts.getString("password"),
					rsts.getTimestamp("regTime"), rsts.getBoolean("isOnline"), rsts.getBlob("icon"));
			MySQL.close();
			return user;
		}
	}

	@Override
	public List<User> getOnlineUsers() throws SQLException {
		List<User> users = new LinkedList<>();
		StringBuffer sql = new StringBuffer();
		Connection conn = MySQL.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rsts;
		sql.append("SELECT uid FROM users WHERE isOnline=1");
		rsts = stmt.executeQuery(sql.toString());
		if (!rsts.next()) {
			MySQL.close();
			return null;
		} else {
			do {
				users.add(new User(rsts.getInt("uid"), rsts.getString("username"), rsts.getString("password"),
						rsts.getTimestamp("regTime"), rsts.getBoolean("isOnline"), rsts.getBlob("icon")));
			} while (rsts.next());
			MySQL.close();
			return users;
		}
	}

}
