package com.cusx.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cusx.bos.domain.Decidedzone;

import com.cusx.bos.service.IDecidedzoneService;

import com.cusx.bos.web.action.base.BaseAction;
import com.cusx.crm.service.Customer;
import com.cusx.crm.service.ICustomerService;

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
	
	//crm代理对象
	@Autowired
	private ICustomerService proxy;
	
	public String findListNotAssociation() {
		List<Customer> list = proxy.findListNotAssociation();
		this.java2Json(list, new String[] {});
		return NONE;
	}
	
	/**
	 * 远程调用crm服务，获取已经关联到指定的定区的客户
	 */
	public String findListHasAssociation(){
		String id = model.getId();
		List<Customer> list = proxy.findListHasAssociation(id);
		this.java2Json(list, new String[]{});
		return NONE;
	}
	private List<Integer> customerIds;
	public List<Integer> getCustomerIds() {
		return customerIds;
	}

	public void setCustomerIds(List<Integer> customerIds) {
		this.customerIds = customerIds;
	}

	/**
	 * 远程调用crm服务，将客户关联到定区
	 */
	public String assigncustomerstodecidedzone(){
		
		proxy.assigncustomerstodecidedzone(model.getId(), customerIds);
		return LIST;
	}
}
