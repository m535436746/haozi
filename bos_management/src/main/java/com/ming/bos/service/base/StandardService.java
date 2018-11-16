package com.ming.bos.service.base;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ming.bos.bean.base.Standard;

public interface StandardService {

	void save(Standard standard);

	Page<Standard> findPageData(Pageable pageable);

	List<Standard> findAll();
	
	
}
