package com.ATMMS.imudges.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Itemchange entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ATMMS.imudges.DAO.Itemchange
 * @author MyEclipse Persistence Tools
 */
public class ItemchangeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ItemchangeDAO.class);
	// property constants
	public static final String TYPE = "type";
	public static final String PID = "pid";
	public static final String NAME = "name";
	public static final String ASCRIPTION = "ascription";
	public static final String PRINCLPAL = "princlpal";
	public static final String MEDIUM = "medium";
	public static final String REMARK = "remark";
	public static final String USERNAME = "username";

	public void save(Itemchange transientInstance) {
		log.debug("saving Itemchange instance");
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

	public void delete(Itemchange persistentInstance) {
		log.debug("deleting Itemchange instance");
		Transaction transaction= getSession().beginTransaction();
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		transaction.commit();
		getSession().close();
	}

	public Itemchange findById(java.lang.Integer id) {
		log.debug("getting Itemchange instance with id: " + id);
		try {
			Itemchange instance = (Itemchange) getSession().get(
					"com.ATMMS.imudges.DAO.Itemchange", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Itemchange instance) {
		log.debug("finding Itemchange instance by example");
		try {
			List results = getSession()
					.createCriteria("com.ATMMS.imudges.DAO.Itemchange")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Itemchange instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Itemchange as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByPid(Object pid) {
		return findByProperty(PID, pid);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByAscription(Object ascription) {
		return findByProperty(ASCRIPTION, ascription);
	}

	public List findByPrinclpal(Object princlpal) {
		return findByProperty(PRINCLPAL, princlpal);
	}

	public List findByMedium(Object medium) {
		return findByProperty(MEDIUM, medium);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findAll() {
		log.debug("finding all Itemchange instances");
		try {
			String queryString = "from Itemchange";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Itemchange merge(Itemchange detachedInstance) {
		log.debug("merging Itemchange instance");
		try {
			Itemchange result = (Itemchange) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Itemchange instance) {
		log.debug("attaching dirty Itemchange instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Itemchange instance) {
		log.debug("attaching clean Itemchange instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}