package my.it.test.action;

import javax.annotation.Resource;

import my.it.test.service.TestService;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	@Resource
	TestService testService;
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
	public String execute(){
		testService.say();
		return SUCCESS;
	}

}
