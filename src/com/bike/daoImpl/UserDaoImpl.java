package com.bike.daoImpl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bike.dao.BaseDao;
import com.bike.dao.UserDao;
import com.bike.models.User;


@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public User getByUserName(String userName) {
		// TODO Auto-generated method stub
		List<User> ret = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("userName",userName));
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
	


}
