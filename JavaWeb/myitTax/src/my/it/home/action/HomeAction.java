package my.it.home.action;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{

	//跳转到首页
	@Override
	public String execute() throws Exception {
		return "home";
	}
	
	
	
}
