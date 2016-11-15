package my.it.test;

import my.it.test.entity.Person;
import my.it.test.service.TestService;
import my.it.test.service.impl.TestServiceImpl;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMerge {

	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void loadCtx() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestService ts = (TestService) ctx.getBean("testService");
		ts.say();
	}
	
	@Test
	public void testSpring() {
		TestService ts = (TestService) ctx.getBean("testService");
	}
	@Test
	public void testHibernate() {
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		//保存人员
		session.save(new Person("人员一"));
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testService() {
		TestService testService = (TestService) ctx.getBean("testService");
		testService.save(new Person("人员二"));
		testService.findPerson("402847815842d611015842d613660000");
	}
	
	@Test
	public void testTransactionReadOnly() {
		TestService testService = (TestService) ctx.getBean("testService");
		testService.save(new Person("人员二"));
		testService.findPerson("402847815842d611015842d613660000");
	}

}
