package com.application.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="persons")
public class Person implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="full_name")
	public String fullname;
	@Temporal(TemporalType.DATE)
	public Date birth;
	
	@Column(name="father_id")
	public long fatherId;
	@Column(name="mother_id")
	public long motherId;
	
	
	
	public Person(long id, String fullname, Date birth, long fatherId, long motherId) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.birth = birth;
		this.fatherId = fatherId;
		this.motherId = motherId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public long getFatherId() {
		return fatherId;
	}
	public void setFatherId(long fatherId) {
		this.fatherId = fatherId;
	}
	public long getMotherId() {
		return fatherId;
	}
	public void setMotherId(long motherId) {
		this.motherId = motherId;
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
}
