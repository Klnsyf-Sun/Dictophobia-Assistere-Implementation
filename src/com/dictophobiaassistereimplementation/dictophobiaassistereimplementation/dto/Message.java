package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto;

import java.sql.Timestamp;

public class Message {
	private int mid = -1;
	private int postBy;
	private int getBy;
	private String shell;
	private String ghost;
	private boolean hasGhost = false;
	private Timestamp time = null;
	private int duration = 0;
	private boolean showDuration;

	public Message(int mid, int postBy, int getBy, String shell, String ghost, boolean hasGhost, Timestamp time,
			int duration, boolean showDuration) {
		this.mid = mid;
		this.postBy = postBy;
		this.getBy = getBy;
		this.shell = shell;
		this.ghost = ghost;
		this.hasGhost = hasGhost;
		this.time = time;
		this.duration = showDuration ? duration : null;
		this.showDuration = showDuration;
	}

	public Message(int postBy, int getBy, String shell, String ghost, boolean hasGhost, int duration,
			boolean showDuration) {
		this.mid = -1;
		this.postBy = postBy;
		this.getBy = getBy;
		this.shell = shell;
		this.ghost = ghost;
		this.hasGhost = hasGhost;
		this.time = null;
		this.duration = showDuration ? duration : null;
		this.showDuration = showDuration;

	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getPostBy() {
		return postBy;
	}

	public void setPostBy(int postBy) {
		this.postBy = postBy;
	}

	public int getGetBy() {
		return getBy;
	}

	public void setGetBy(int getBy) {
		this.getBy = getBy;
	}

	public String getShell() {
		return shell;
	}

	public void setShell(String shell) {
		this.shell = shell;
	}

	public String getGhost() {
		return ghost;
	}

	public void setGhost(String ghost) {
		this.ghost = ghost;
	}

	public boolean isHasGhost() {
		return hasGhost;
	}

	public void setHasGhost(boolean hasGhost) {
		this.hasGhost = hasGhost;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isShowDuration() {
		return showDuration;
	}

	public void setShowDuration(boolean showDuration) {
		this.showDuration = showDuration;
	}

}
