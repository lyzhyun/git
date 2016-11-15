package my.it.test.service;

import java.io.Serializable;

import my.it.test.entity.Person;

public interface TestService {
	//测试
	public void say();
	//保存
	public void save(Person person);
	//根据id查询人员
	public Person findPerson(Serializable id);
	

}
