package com.bike.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bike.dao.BaseDao;
import com.bike.dao.TokenDao;
import com.bike.models.Token;


@Repository
public class TokenDaoImpl extends BaseDao<Token> implements TokenDao{

	@SuppressWarnings("unchecked")
	@Override
	public Token getByToken(String token) {
		// TODO Auto-generated method stub
		List<Token> ret = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(Token.class);
        criteria.add(Restrictions.eq("token",token));
        try {
            ret = criteria.list();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (ret != null && ret.size() > 0) {
			return ret.get(0);
		}
		return null;
	}

	@Override
	public boolean addToken(Token token) {
		// TODO Auto-generated method stub
		return save(token);
	}

	@Override
	public boolean deleteToken(Long id) {
		// TODO Auto-generated method stub
		return delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Token getByUserId(Long userId) {
		// TODO Auto-generated method stub
		List<Token> ret = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(Token.class);
        criteria.add(Restrictions.eq("userId",userId));
        try {
            ret = criteria.list();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (ret != null && ret.size() > 0) {
			return ret.get(0);
		}
		return null;
	}

	@Override
	public boolean updateToken(Token token) {
		// TODO Auto-generated method stub
		return update(token);
	}


}
