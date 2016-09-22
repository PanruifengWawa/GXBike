package com.bike.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "token")
public class Token {
	private Long id;
    private Long userId;
    private String token;
    
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
    @Column(name = "user_id")
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Basic
    @Column(name = "token")
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
    
    

}
