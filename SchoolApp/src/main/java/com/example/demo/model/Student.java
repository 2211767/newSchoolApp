package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.example.demo.service.StringPrefixedSequenceIdGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_generate")
	@GenericGenerator(name = "student_id_generate", strategy = "com.example.demo.service.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "R-"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })

	@Id
	private String registerId;

	@Column(name = "PARENT_NAME")
	private String parentName;

	@Column(name = "STUDENT_NAME")
	private String studentName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "STATE")
	private String state;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "CITY")
	private String city;

	@Column(name = "ZIP_CODE", nullable = false, length = 6)
	private Integer zipCode;

	@Column(name = "PRIMARYCONTACT_PERSON")
	private String primaryContactPerson;

	@Column(name = "PRIMARYCONTACT_PERSON_MOBILENO")
	private String primaryContactPersonMobileNo;

	@Column(name = "SECONDERYCONTACT_PERSON")
	private String seconderyContactPerson;

	@Column(name = "seconderyCONTACT_PERSON_MOBILENO")
	private String secondoryContactPersonMobileNo;

	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USERAPP_ID")
	private UserApplication userApplication;

	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;

	@Column(name = "UPDATED_DATE")
	private LocalDateTime updatedDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@OneToMany(targetEntity = Circular.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "STUDENT_ID", referencedColumnName = "registerId")
	private List<Circular> circular;

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZipCode() {
		return zipCode;
	}

//	public String getAcknowldgeStatus() {
//		return acknowldgeStatus;
//	}
//
//	public void setAcknowldgeStatus(String acknowldgeStatus) {
//		this.acknowldgeStatus = acknowldgeStatus;
//	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getPrimaryContactPerson() {
		return primaryContactPerson;
	}

	public void setPrimaryContactPerson(String primaryContactPerson) {
		this.primaryContactPerson = primaryContactPerson;
	}

	public String getPrimaryContactPersonMobileNo() {
		return primaryContactPersonMobileNo;
	}

	public void setPrimaryContactPersonMobileNo(String primaryContactPersonMobileNo) {
		this.primaryContactPersonMobileNo = primaryContactPersonMobileNo;
	}

	public String getSeconderyContactPerson() {
		return seconderyContactPerson;
	}

	public void setSeconderyContactPerson(String seconderyContactPerson) {
		this.seconderyContactPerson = seconderyContactPerson;
	}

	public String getSecondoryContactPersonMobileNo() {
		return secondoryContactPersonMobileNo;
	}

	public void setSecondoryContactPersonMobileNo(String secondoryContactPersonMobileNo) {
		this.secondoryContactPersonMobileNo = secondoryContactPersonMobileNo;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime localDate) {
		this.createdDate = localDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime localDate) {
		this.updatedDate = localDate;
	}

	public List<Circular> getCircular() {
		return circular;
	}

	public void setCircular(List<Circular> circular) {
		this.circular = circular;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserApplication getUserApplication() {
		return userApplication;
	}

	public void setUserApplication(UserApplication userApplication) {
		this.userApplication = userApplication;
	}

}
