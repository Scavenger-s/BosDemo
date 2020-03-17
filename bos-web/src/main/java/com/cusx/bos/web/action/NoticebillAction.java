package com.cusx.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cusx.bos.domain.Noticebill;
import com.cusx.bos.service.INoticebillService;
import com.cusx.bos.web.action.base.BaseAction;
import com.cusx.crm.service.Customer;
import com.cusx.crm.service.ICustomerService;

@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill>{
	//注入crm客户端代理对象
		@Autowired
		private ICustomerService customerService;
		
		/**
		 * 远程调用crm服务，根据手机号查询客户信息
		 */
		public String findCustomerByTelephone(){
			String telephone = model.getTelephone();
			Customer customer = customerService.findCustomerByTelephone(telephone);
			this.java2Json(customer, new String[]{});
			return NONE;
		}
		@Autowired
		private INoticebillService noticebillService;
		
		/**
		 * 保存一个业务通知，并尝试分单
		 */
		public String add() {
			noticebillService.save(model);
			return "noticebill_add";
		}
	
}
