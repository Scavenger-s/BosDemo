package com.cusx.bos.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cusx.bos.domain.Region;
import com.cusx.bos.domain.User;
import com.cusx.bos.service.IRegionService;
import com.cusx.bos.service.IUserService;

import com.cusx.bos.utils.BOSUtils;
import com.cusx.bos.utils.PageBean;
import com.cusx.bos.utils.PinYin4jUtils;
import com.cusx.bos.web.action.base.BaseAction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;



@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region> {
	private File regionFile;
	
	private List<Region> regionList = new ArrayList<Region>();
	@Autowired
	private IRegionService regionService;
	
	
	public void setRegionFile(File regionFile) {
		this.regionFile = regionFile;
	}
	/**
	 * 区域导入
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public String importXls() throws FileNotFoundException, IOException {
		//使用POI解析excel文件
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(regionFile));
		HSSFSheet hssfSheet = workbook.getSheet("Sheet1");
		for (Row row : hssfSheet) {
			int rowNum = row.getRowNum();
			if(rowNum == 0){
				continue;
			}
			String id = row.getCell(0).getStringCellValue();
			String province = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			String postcode = row.getCell(4).getStringCellValue();
			//包装一个区域对象
			Region region = new Region(id, province, city, district, postcode, null, null, null);
			province = province.substring(0, province.length() - 1);
			city = city.substring(0, city.length() - 1);
			district = district.substring(0, district.length() - 1);
			String info = province + city + district;
			String[] headByString = PinYin4jUtils.getHeadByString(info);
			String shortcode = StringUtils.join(headByString);
			//城市编码---->>shijiazhuang
			String citycode = PinYin4jUtils.hanziToPinyin(city, "");
			
			region.setShortcode(shortcode);
			region.setCitycode(citycode);
			regionList.add(region);
			
		}
		regionService.saveBatch(regionList);
		return NONE;
	}
	
	/**
	 * 分页查询区域
	 * @throws IOException 
	 */
	public String pageQuery() throws IOException {
		regionService.pageQuery(pageBean);
		this.java2Json(pageBean, 
					new String[]{"currentPage","detachedCriteria","pageSize","subareas"});
		return NONE;
	}
	private String q;
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	/**
	 * 查询所有区域，返回json数据
	 * @return
	 */
	public String listajax() {
		List<Region> list = null;
		if(StringUtils.isNotBlank(q)){
			list = regionService.findListByQ(q);
		}else{
			list = regionService.findAll();
		}
		this.java2Json(list, new String[]{"subareas"});
		
		return NONE;
	}
}
