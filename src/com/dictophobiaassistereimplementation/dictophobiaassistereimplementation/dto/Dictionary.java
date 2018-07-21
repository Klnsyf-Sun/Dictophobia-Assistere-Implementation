package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto;

public class Dictionary {
	private int did = -1;
	private int uid;
	private String linkedPhrase;
	private String content;

	public Dictionary(int uid, String linkedPhrase, String content) {
		this.did = -1;
		this.uid = uid;
		this.linkedPhrase = linkedPhrase;
		this.content = content;
	}

	public Dictionary(int did, int uid, String linkedPhrase, String content) {
		this.did = did;
		this.uid = uid;
		this.linkedPhrase = linkedPhrase;
		this.content = content;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getLinkedPhrase() {
		return linkedPhrase;
	}

	public void setLinkedPhrase(String linkedPhrase) {
		this.linkedPhrase = linkedPhrase;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
