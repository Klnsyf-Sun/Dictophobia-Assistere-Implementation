package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto;

import java.sql.Blob;
import java.sql.Timestamp;

public class User {
	private int uid = -1;
	private String username;
	private String password;
	private Timestamp regTime = null;
	private boolean isOnline = false;
	private Blob icon = null;

	public User(int uid, String username, String password, Timestamp regTime, boolean isOnline, Blob icon) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.regTime = regTime;
		this.isOnline = isOnline;
		this.icon = icon;
	}

	public User(int uid, String username, String password) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.regTime = null;
		this.isOnline = false;
		this.icon = null;
	}

	public User(String username, String password) {
		this.uid = -1;
		this.username = username;
		this.password = password;
		this.regTime = null;
		this.isOnline = false;
		this.icon = null;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegTime() {
		return regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public Blob getIcon() {
		return icon;
	}

	public void setIcon(Blob icon) {
		this.icon = icon;
	}
}
