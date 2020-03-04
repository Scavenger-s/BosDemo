package com.cusx.bos.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cusx.bos.domain.Subarea;
import com.cusx.bos.service.ISubareaService;
import com.cusx.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {
	@Resource
	private ISubareaService subareaService;
	public String add() {
		subareaService.save(model);
		return LIST;
	}
}
