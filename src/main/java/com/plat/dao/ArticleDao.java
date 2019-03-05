package com.plat.dao;
import java.util.List;
import com.plat.bean.Article;

/**
 * 查询小程序用户及用户相关信息相关dao
 * @author CR
 *
 */
public interface ArticleDao {	
	/**
	 * 查询用户基本信息
	 * @param req
	 * @return
	 */
	public List<Article> queryArticleList(Article req);
	
	public int addArticle(Article article);
	
	public Article getArticleByArticleUuid(Article article);
}
