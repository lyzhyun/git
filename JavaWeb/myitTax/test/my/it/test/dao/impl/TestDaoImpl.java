package my.it.test.dao.impl;

import java.io.Serializable;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import my.it.test.dao.TestDao;
import my.it.test.entity.Person;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao{

	
	@Override
	public void save(Person person) {
		this.getHibernateTemplate().save(person);
		
	}

	@Override
	public Person findPerson(Serializable id) {
		return this.getHibernateTemplate().get(Person.class, id);
		 
	}

}
