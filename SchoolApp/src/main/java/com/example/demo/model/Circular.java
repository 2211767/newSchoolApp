package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CIRCULAR")
public class Circular implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CIRCULAR_ID")
	private Integer circularId;

	@Column(name = "STUDENT_ID")
	private String studentId;

	@Column(name = "CIRCULAR")
	private String circular;

	@Column(name = "ACKNOWLEDGE")
	private String acknowledge;

	@Column(name = "CIRCULAR_CREATED_DATE")
	private LocalDateTime circularCreatedDate;

	@Column(name = "ACKNOWLDGE_ACCEPTED_DATE")
	private LocalDateTime acknowldgeAcceptedDate;

	@Column(name = "POSTED_BY")
	private String postedBy;

	public Integer getCircularId() {
		return circularId;
	}

	public void setCircularId(Integer circularId) {
		this.circularId = circularId;
	}

	public String getRegisterId() {
		return studentId;
	}

	public void setRegisterId(String registerId) {
		this.studentId = registerId;
	}

	public String getCircular() {
		return circular;
	}

	public void setCircular(String circular) {
		this.circular = circular;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getAcknowledge() {
		return acknowledge;
	}

	public void setAcknowledge(String acknowledge) {
		this.acknowledge = acknowledge;
	}

	public LocalDateTime getCircularCreatedDate() {
		return circularCreatedDate;
	}

	public void setCircularCreatedDate(LocalDateTime circularCreatedDate) {
		this.circularCreatedDate = circularCreatedDate;
	}

	public LocalDateTime getAcknowldgeAcceptedDate() {
		return acknowldgeAcceptedDate;
	}

	public void setAcknowldgeAcceptedDate(LocalDateTime acknowldgeAcceptedDate) {
		this.acknowldgeAcceptedDate = acknowldgeAcceptedDate;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

}
