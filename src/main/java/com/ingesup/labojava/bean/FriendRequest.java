package com.ingesup.labojava.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="FRIEND_REQUEST")
public class FriendRequest implements Serializable {
	

	private Long id;
	private boolean received;
	private boolean sent;
	
	private User user;
	private Long senderID;
	private Long receiverID;
	
	private String senderName;
	private String receiverName;
	
	public FriendRequest() {
		
	}
	
	/** Un boolean qui permet de dire si la requête a été envoyé ou reçue 
	 * et qui permet d'initialiser l'utilisateur user */
	
	public FriendRequest(User sender, User receiver, boolean isReceived) {
		
		received = isReceived;
		setSent(!received);
		
		if (received)
			user = receiver;
		else
			user = sender;
		
		senderID = sender.getId();
		receiverID = receiver.getId();	
		senderName = sender.getFirstName() +" "+ sender.getLastName();
		receiverName = receiver.getFirstName() +" "+ receiver.getLastName();
	}
	
	/**
	 * Method Equals*/
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		FriendRequest other = (FriendRequest) obj;
		
		if (id == other.id && senderID == other.senderID && receiverID == other.receiverID)
			return true;
		
		else
			return false;
	}
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public User getUser() {
		return user;
	}

	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FRIEND_REQUEST_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	//@Id
	@Column(name="SENDER_ID")
	public Long getSenderID() {
		return senderID;
	}

	public void setSenderID(Long senderID) {
		this.senderID = senderID;
	}

	//@Id
	@Column(name="RECEIVER_ID")
	public Long getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(Long receiverID) {
		this.receiverID = receiverID;
	}
	
	//@Id
	@Column(name="IS_RECEIVED")
	public boolean isReceived() {
		return received;
	}

	public void setReceived(boolean received) {
		this.received = received;
	}

	@Column(name="IS_SENT")
	public boolean isSent() {
		return sent;
	}

	public void setSent(boolean sent) {
		this.sent = sent;
	}

	@Column(name="SENDER_NAME")
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	@Column(name="RECEIVER_NAME")
	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	
	
}
