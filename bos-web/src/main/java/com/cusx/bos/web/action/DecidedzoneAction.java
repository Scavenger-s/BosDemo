package com.cusx.bos.web.action;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cusx.bos.domain.Decidedzone;

import com.cusx.bos.service.IDecidedzoneService;

import com.cusx.bos.web.action.base.BaseAction;

/**
 * 定区管理
 * @author lh
 *
 */

@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone>{
	//属性驱动
	private String[] subareaid;
	@Autowired
	private IDecidedzoneService decidedzoneService;
	public String[] getSubareaid() {
		return subareaid;
	}

	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}
	/**
	 * 添加定区
	 */
	public String add() {
		decidedzoneService.save(model, subareaid);
		return LIST;
	}
	
	/**
	 * 分页查询方法
	 */
	public String pageQuery() throws IOException{
		decidedzoneService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria",
						"pageSize","subareas","decidedzones"});
		return NONE;
	}
}
