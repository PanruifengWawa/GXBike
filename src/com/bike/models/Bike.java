package com.bike.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bike_info")
public class Bike {
	private Long id;
	private Long code;
	private Long pwd;
	
	@Id
    @GeneratedValue
    @Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Basic
    @Column(name = "code")
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	@Basic
    @Column(name = "pwd")
	public Long getPwd() {
		return pwd;
	}
	public void setPwd(Long pwd) {
		this.pwd = pwd;
	}
	
	

}
