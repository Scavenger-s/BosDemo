package com.cusx.bos.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.cusx.bos.domain.User;
import com.cusx.bos.utils.BOSUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 自定义拦截器,实现未登录跳转登录页面
 * @author lh
 *
 */
public class BosLoginInterceptor extends MethodFilterInterceptor{

	
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//从session中获取用户对象
	    User user = BOSUtils.getLoginUser();
		if(user == null) {
			//没有登录
			return "login";
		}
		//放行
	    return invocation.invoke();
	}

}
