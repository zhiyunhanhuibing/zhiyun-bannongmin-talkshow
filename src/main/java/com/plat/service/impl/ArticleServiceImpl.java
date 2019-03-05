package com.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.plat.bean.Article;
import com.plat.bean.OperationDbMessage;
import com.plat.config.PageBean;
import com.plat.constant.DictErrors;
import com.plat.dao.ArticleDao;
import com.plat.exception.PlatException;
import com.plat.service.ArticleService;

/**
 * 获取文章列表
 * @author hanhuibing
 *
 */
@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
    private ArticleDao articleDao;
	/**
	 * 查询用户相关信息
	 */
	@Override
	public PageBean<Article> queryArticleList(Article req) {
		int pageIndex =0;
		int pageRows = 0;
		if(pageIndex<=0) {
			pageIndex = 1;
		}
		if(pageRows<=0) {
			pageRows = 15;
		}
		PageHelper.startPage(pageIndex, pageRows);
		List<Article> liItems = articleDao.queryArticleList(req);
		int countIndex = liItems.size();
		return new PageBean<>(pageIndex, pageRows, countIndex, liItems);
	}
	
	
	@Override
	@Transactional
	public OperationDbMessage addArticle(Article article){   
		OperationDbMessage message = new OperationDbMessage();
		try {
			int addCount = articleDao.addArticle(article);
			if(addCount == 0) {
				throw new PlatException(DictErrors.DICT_ADD_ERROR, "新增文章/笔记");
			}
			message.setStatusCode(200);
			message.setStatusMessage("添加字典成功！");
		} catch (Exception e) {
			throw new PlatException(DictErrors.DICT_ADD_ERROR, "新增文章/笔记",e);
		}		
		return message;
	}


	@Override
	public Article queryArticle(Article article) {
		// TODO Auto-generated method stub
		Article articleRes = articleDao.getArticleByArticleUuid(article);
		return articleRes;
	}
	

}
