package my.it.nsfw.home.action;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {
	
	//跳转到纳税服务首页
	public String frame(){
		return "frame";
	}
	
	//跳转到首页顶部
	public String top(){
		return "top";
	}
	
	//跳转到首页左边
	public String left(){
		return "left";
	}
}
