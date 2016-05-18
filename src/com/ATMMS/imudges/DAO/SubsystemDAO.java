package com.ATMMS.imudges.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Subsystem entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.ATMMS.imudges.DAO.Subsystem
  * @author MyEclipse Persistence Tools 
 */
public class SubsystemDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SubsystemDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String PARENT = "parent";
	public static final String NUM = "num";



    
    public void save(Subsystem transientInstance) {
        log.debug("saving Subsystem instance");
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
    
	public void delete(Subsystem persistentInstance) {
        log.debug("deleting Subsystem instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Subsystem findById( java.lang.Integer id) {
        log.debug("getting Subsystem instance with id: " + id);
        try {
            Subsystem instance = (Subsystem) getSession()
                    .get("com.ATMMS.imudges.DAO.Subsystem", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Subsystem instance) {
        log.debug("finding Subsystem instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.ATMMS.imudges.DAO.Subsystem")
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
      log.debug("finding Subsystem instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Subsystem as model where model." 
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
		log.debug("finding all Subsystem instances");
		try {
			String queryString = "from Subsystem";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Subsystem merge(Subsystem detachedInstance) {
        log.debug("merging Subsystem instance");
        try {
            Subsystem result = (Subsystem) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Subsystem instance) {
        log.debug("attaching dirty Subsystem instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Subsystem instance) {
        log.debug("attaching clean Subsystem instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}