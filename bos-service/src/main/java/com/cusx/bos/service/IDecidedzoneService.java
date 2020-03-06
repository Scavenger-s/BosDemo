package com.cusx.bos.service;

import com.cusx.bos.domain.Decidedzone;
import com.cusx.bos.utils.PageBean;

public interface IDecidedzoneService {
	/**
	 * 添加定区，关联分区
	 * @param model
	 * @param subareaid
	 */
	public void save(Decidedzone model, String[] subareaid);

	public void pageQuery(PageBean pageBean);

}
