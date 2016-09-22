package com.bike.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bike.dao.BaseDao;
import com.bike.dao.BikeDao;
import com.bike.models.Bike;

@Repository
public class BikeDaoImpl extends BaseDao<Bike> implements BikeDao {

	@SuppressWarnings("unchecked")
	@Override
	public Bike getByCode(Long code) {
		// TODO Auto-generated method stub
		List<Bike> ret = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(Bike.class);
        criteria.add(Restrictions.eq("code",code));
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
