package com.ingesup.labojava.form;

import org.hibernate.validator.constraints.NotEmpty;

public class FriendRequestBean {
	

	@NotEmpty
	private Long id;
	@NotEmpty
	private Long senderID;
	@NotEmpty
	private Long receiverID;
	@NotEmpty
	private String response;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Long getSenderID() {
		return senderID;
	}
	public void setSenderID(Long senderID) {
		this.senderID = senderID;
	}
	public Long getReceiverID() {
		return receiverID;
	}
	public void setReceiverID(Long receiverID) {
		this.receiverID = receiverID;
	}
	
}
