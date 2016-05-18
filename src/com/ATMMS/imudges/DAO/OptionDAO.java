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
 * Option entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ATMMS.imudges.DAO.Option
 * @author MyEclipse Persistence Tools
 */
public class OptionDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(OptionDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PARENT = "parent";
	public static final String NUM = "num";

	public void save(Option transientInstance) {
		log.debug("saving Option instance");
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

	public void delete(Option persistentInstance) {
		log.debug("deleting Option instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Option findById(java.lang.Integer id) {
		log.debug("getting Option instance with id: " + id);
		try {
			Option instance = (Option) getSession().get(
					"com.ATMMS.imudges.DAO.Option", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Option instance) {
		log.debug("finding Option instance by example");
		try {
			List results = getSession()
					.createCriteria("com.ATMMS.imudges.DAO.Option")
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
		log.debug("finding Option instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Option as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByParent(Object parent) {
		return findByProperty(PARENT, parent);
	}

	public List findByNum(Object num) {
		return findByProperty(NUM, num);
	}

	public List findAll() {
		log.debug("finding all Option instances");
		try {
			String queryString = "from Option";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Option merge(Option detachedInstance) {
		log.debug("merging Option instance");
		try {
			Option result = (Option) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Option instance) {
		log.debug("attaching dirty Option instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Option instance) {
		log.debug("attaching clean Option instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}