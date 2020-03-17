package com.cusx.bos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cusx.bos.domain.Function;
import com.cusx.bos.service.IFunctionService;
import com.cusx.bos.web.action.base.BaseAction;

/**
 * 权限管理
 * @author lh
 *
 */
@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function>{
	@Autowired
	private IFunctionService service;
	public FunctionAction() {
		super();
	}
	/**
	 * 查询所有权限，返回json数据
	 */
	public String listajax(){
		List<Function> list = service.findAll();
		this.java2Json(list, new String[]{"parentFunction","roles"});
		return NONE;
	}
	
	/**
	 * 添加权限 
	 */
	public String add(){
		service.save(model);
		return LIST;
	}
	/**
	 * 分页查询
	 * @return
	 */
	public String pageQuery(){
		String page = model.getPage();
		pageBean.setCurrentPage(Integer.parseInt(page));
		service.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"parentFunction","roles","children"});
		return NONE;
	}
	/**
	 * 根据当期登录人查询对应的菜单,返回json
	 */
	public String findMenu() {
		List<Function> list = service.findMenu();
		this.java2Json(list, new String[]{"parentFunction","roles","children"});
		return NONE;
	}
}
