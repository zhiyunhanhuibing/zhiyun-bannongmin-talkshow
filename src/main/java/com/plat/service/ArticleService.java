package com.plat.service;
import com.plat.bean.Article;
import com.plat.bean.OperationDbMessage;
import com.plat.config.PageBean;

/**
 * 小程序用户相关Service
 * @author Administrator
 *
 */
public interface ArticleService {
	/**
	 * 查询用户信息
	 * @param req
	 * @return
	 */
	public PageBean<Article> queryArticleList(Article article);
	
	/**
	 * 添加字典
	 * @param di
	 * @return
	 */
	public OperationDbMessage addArticle(Article article);
	
	/**
	 * 查看
	 * @param di
	 * @return
	 */
	public Article queryArticle(Article article);
}
