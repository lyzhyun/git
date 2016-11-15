package my.it.test.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import my.it.test.dao.TestDao;
import my.it.test.dao.impl.TestDaoImpl;
import my.it.test.entity.Person;
import my.it.test.service.TestService;

@Service("testService")  //注解的方式加入到容器
public class TestServiceImpl implements TestService{

	@Resource
	TestDao testDaoImpl; //在配置文件中手动加入到容器
	
	@Override
	public void say() {
		System.out.println("hello , server");
		
	}

	@Override
	public void save(Person person) {
		testDaoImpl.save(person);
	}

	@Override
	public Person findPerson(Serializable id) {
		return testDaoImpl.findPerson(id);
	}

}
