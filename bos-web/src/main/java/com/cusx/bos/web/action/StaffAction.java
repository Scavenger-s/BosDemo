package com.cusx.bos.web.action;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cusx.bos.domain.Staff;
import com.cusx.bos.domain.User;
import com.cusx.bos.service.IStaffService;
import com.cusx.bos.service.IUserService;
import com.cusx.bos.utils.BOSUtils;
import com.cusx.bos.web.action.base.BaseAction;



@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
	@Autowired
	private IStaffService staffService;
	
	public String add() {
		staffService.save(model);
		return "list";
	}
}
