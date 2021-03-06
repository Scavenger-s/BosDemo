package com.cusx.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cusx.bos.domain.Staff;
import com.cusx.bos.domain.User;
import com.cusx.bos.service.IStaffService;
import com.cusx.bos.service.IUserService;
import com.cusx.bos.utils.BOSUtils;
import com.cusx.bos.utils.PageBean;
import com.cusx.bos.web.action.base.BaseAction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;



@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
	@Autowired
	private IStaffService staffService;
	
	public String add() {
		staffService.save(model);
		return "list";
	}
    private int page;
    private int rows;
	/**
	 * 分页查询
	 * @return
	 * @throws IOException 
	 */
	public String pageQuery() throws IOException {
		PageBean pageBean = new PageBean();
		
		pageBean.setCurrentPage(page);
		pageBean.setPageSize(rows);
		
		//创建离线查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
		pageBean.setDetachedCriteria(detachedCriteria);
		
		staffService.pageQuery(pageBean);
		
		JsonConfig jsonConfig = new JsonConfig();
		//指定哪些属性不需要转json
		jsonConfig.setExcludes(new String[]{"decidedzones","currentPage","detachedCriteria","pageSize"});
		String json = JSONObject.fromObject(pageBean,jsonConfig).toString();
		
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(json);
		return NONE;
	}
	
	//属性驱动
	private String ids;
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	/**
	 * 取派员批量删除
	 * @return
	 */
	@RequiresPermissions("staff-delete")//执行这个方法需要staff-delete权限
	public String deleteBatch() {
		
		staffService.deleteBatch(ids);
		return "list";
	}
	
	/**
	 * 修改取派员信息
	 * @return
	 */
	public String edit() {
		
		Staff staff = staffService.findById(model.getId());
		//使用页面提交的数据进行覆盖
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staffService.update(staff);
		return "list";
	}
	
	/**
	 *  查询所有未删除取派员信息，返回json
	 * @return
	 */
	public String listajax() {
		
		List<Staff> list = staffService.findNotDelete();
		this.java2Json(list, new String[]{"decidedzones","currentPage","detachedCriteria","pageSize"});
		return NONE;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
}
