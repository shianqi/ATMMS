package com.ATMMS.imudges.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Factory entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.ATMMS.imudges.DAO.Factory
  * @author MyEclipse Persistence Tools 
 */
public class FactoryDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(FactoryDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String PARENT = "parent";
	public static final String NUM = "num";

    
    public void save(Factory transientInstance) {
        log.debug("saving Factory instance");
        Transaction transaction= getSession().beginTransaction();
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
        transaction.commit();
		getSession().close();
    }
    
	public void delete(Factory persistentInstance) {
        log.debug("deleting Factory instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Factory findById( java.lang.Integer id) {
        log.debug("getting Factory instance with id: " + id);
        try {
            Factory instance = (Factory) getSession()
                    .get("com.ATMMS.imudges.DAO.Factory", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Factory instance) {
        log.debug("finding Factory instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.ATMMS.imudges.DAO.Factory")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Factory instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Factory as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByParent(Object parent
	) {
		return findByProperty(PARENT, parent
		);
	}
	
	public List findByNum(Object num
	) {
		return findByProperty(NUM, num
		);
	}
	

	public List findAll() {
		log.debug("finding all Factory instances");
		try {
			String queryString = "from Factory";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Factory merge(Factory detachedInstance) {
        log.debug("merging Factory instance");
        try {
            Factory result = (Factory) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Factory instance) {
        log.debug("attaching dirty Factory instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Factory instance) {
        log.debug("attaching clean Factory instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}