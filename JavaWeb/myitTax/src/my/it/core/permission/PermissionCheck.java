package my.it.core.permission;

import my.it.nsfw.user.entity.User;

public interface PermissionCheck {

	//判断用户是否有code对应的权限  返回boolean值
	boolean isAccessible(User user, String code);

}
