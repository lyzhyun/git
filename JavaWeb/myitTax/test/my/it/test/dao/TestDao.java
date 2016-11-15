package my.it.test.dao;

import java.io.Serializable;

import my.it.test.entity.Person;

public interface TestDao {
	//保存
		public void save(Person person);
		//根据id查询人员
		public Person findPerson(Serializable id);

}
