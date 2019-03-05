package com.plat.config;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 
 * PageHelper分页实体
 * @author chenrong
 *
 * @param <T> 实体类  
 */
@Data
public class PageBean<T> {
	// 当前页
	private Integer currentPage = 1;
	// 每页显示的总条数
	private Integer pageSize = 10;
	// 总条数
	private Integer totalNum;
	// 是否有下一页
	private Integer isMore;
	// 总页数
	private Integer totalPage;
	// 开始索引
	private Integer startIndex;
	// 分页结果
	private List<T> items;

	public PageBean() {
		super();
	}

	public PageBean(Integer currentPage, Integer pageSize, Integer totalNum,List<T> items) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalNum = totalNum;
		this.totalPage = (this.totalNum + this.pageSize - 1) / this.pageSize;
		this.startIndex = (this.currentPage - 1) * this.pageSize;
		this.isMore = this.currentPage >= this.totalPage ? 0 : 1;
		List<T> li = new ArrayList<>();
		// 没有更多页
		if(this.isMore==0) {
			if(items.size()>0) {
				for (int i = startIndex; i < items.size(); i++) {
					li.add(items.get(i));
				}
			}
		}
		// 有更多页
		else {
			for (int i = startIndex; i < this.currentPage*this.pageSize; i++) {
				li.add(items.get(i));
			}
		}
		this.items = li;
	}

}
