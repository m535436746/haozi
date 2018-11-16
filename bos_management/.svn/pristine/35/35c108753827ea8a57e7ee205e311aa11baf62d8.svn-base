package com.ming.bos.action.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.ming.bos.bean.base.Standard;
import com.ming.bos.service.base.StandardService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("json-default")
@Namespace("/")
@Controller
@Scope("prototype")
public class StandardAction extends ActionSupport implements ModelDriven<Standard> {

	private Standard standard = new Standard();

	@Autowired
	private StandardService standardService;

	@Override
	public Standard getModel() {
		return standard;
	}

	// 添加收派标准
	@Action(value = "standard_save", results = {
			@Result(name = "success", type = "redirect", location = "./pages/base/standard.html") })
	public String save() {
		standardService.save(standard);
		return SUCCESS;
	}

	private int page;
	private int rows;

	public void setPage(int page) {
		this.page = page;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	// 分页列表查询
	@Action(value = "standard_pageQuery", results = { @Result(name = "success", type = "json") })
	public String pageQuery() {
		// 调用业务层 ，查询数据结果
		Pageable pageable = new PageRequest(page - 1, rows);
		Page<Standard> pageData = standardService.findPageData(pageable);

		// 返回客户端数据 需要 total 和 rows
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pageData.getNumberOfElements());
		result.put("rows", pageData.getContent());

		// 将map转换为json数据返回 ，使用struts2-json-plugin 插件
		ActionContext.getContext().getValueStack().push(result);

		return SUCCESS;
	}

	// 查询所有收派标准方法
	@Action(value = "standard_findAll", results = { @Result(name = "success", type = "json") })
	public String findAll() {
		List<Standard> standards = standardService.findAll();
		ActionContext.getContext().getValueStack().push(standards);
		return SUCCESS;
	}
}
