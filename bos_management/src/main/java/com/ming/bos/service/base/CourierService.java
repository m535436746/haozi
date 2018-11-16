package com.ming.bos.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.ming.bos.bean.base.Courier;

public interface CourierService {

	void save(Courier courier);

	// 分页查询
	public Page<Courier> findPageData(Specification<Courier> specification, Pageable pageable);
}
