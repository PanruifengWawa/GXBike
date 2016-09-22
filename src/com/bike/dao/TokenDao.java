package com.bike.dao;

import com.bike.models.Token;

public interface TokenDao {
	Token getByToken(String token);
	Token getByUserId(Long userId);
	boolean addToken(Token token);
	boolean deleteToken(Long id);
	boolean updateToken(Token token);

}
