package com.cusx.bos.web.action.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cusx.bos.domain.Region;
import com.cusx.bos.domain.Role;
import com.cusx.bos.service.IRoleService;

/**
 * 角色管理
 * @author lh
 *
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	//属性驱动，接收权限的id
	private String functionIds;
	@Autowired
	private IRoleService roleService;
	public void setFunctionIds(String functionIds) {
		this.functionIds = functionIds;
	}
	/**
	 * 添加角色
	 */
	public String add() {
		roleService.save(model, functionIds);
		return LIST;
	}
}
