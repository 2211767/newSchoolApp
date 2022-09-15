package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "USER_APP")
public class UserApplication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USERAPP_ID")
	private Integer userAppId;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "FINAL_SUBMIT")
	private String finalSubmit;

	@Column(name = "STATUS")
	private String status;

	@JsonManagedReference
	@OneToOne(mappedBy = "userApplication", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Student student;

	public Integer getUserAppId() {
		return userAppId;
	}

	public void setUserAppId(Integer userAppId) {
		this.userAppId = userAppId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFinalSubmit() {
		return finalSubmit;
	}

	public void setFinalSubmit(String finalSubmit) {
		this.finalSubmit = finalSubmit;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
