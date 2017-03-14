package org.naveen.tutorial.dto;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="USER_DETAILS")
public class UserDetails {

	@Id @GeneratedValue
	private int userId;
	@Embedded
	private Address address;
	@Basic
	private String userName;
	@Temporal (TemporalType.DATE)
	private Date joinedDate;
	@Lob
	private String description;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
	
	
}
