package com.cusx.bos.web.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cusx.bos.domain.Workordermanage;
import com.cusx.bos.service.IWorkordermanageService;
import com.cusx.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class WorkordermanageAction extends BaseAction<Workordermanage>{
	@Autowired
	private IWorkordermanageService workordermangeService;
	public String add() throws IOException {
		String f = "1";
		try{
			workordermangeService.save(model);
		}catch(Exception e){
			e.printStackTrace();
			f = "0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
}
