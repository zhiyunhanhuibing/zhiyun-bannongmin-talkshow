package com.plat.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.StringUtil;
import com.plat.bean.OperationDbMessage;
import com.plat.bean.Article;
import com.plat.config.PageBean;
import com.plat.constant.CommonErrors;
import com.plat.exception.PlatException;
import com.plat.service.ArticleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @Description 获取文章列表
 * @author yuanhuimeng Date:2018-12-04 11:28:13
 */
@RestController
@RequestMapping("/article")
@Api(value = "文章/笔记管理", tags = "文章/笔记管理")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	/**
	 * 
	 * @Description：系统用户列表
	 * @author yuanhuimeng
	 * Date:2018-12-05 09:49:17
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	@ApiOperation(value="文章/笔记列表查询", notes="文章/笔记列表查询")
	public PageBean<Article> queryArticleList(@RequestBody Article article) {

		return articleService.queryArticleList(article);
	}
	
	@PostMapping("/add")
	@ApiOperation(value="新增文章/笔记", notes="新增文章/笔记")
	public OperationDbMessage addArticle(@RequestBody Article article) {
		if(Objects.isNull(article)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "新增文章/笔记");
			pe.setAddtionalMessage("入参不可为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(article.getArticle_title())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "新增文章/笔记");
			pe.setAddtionalMessage("文章/笔记[标题]不能为空！");
			throw pe;
		}
		if(StringUtil.isEmpty(article.getArticle_content())) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "新增文章/笔记");
			pe.setAddtionalMessage("文章/笔记[内容]不能为空！");
			throw pe;
		}
		return articleService.addArticle(article);
	}
	
	@RequestMapping(value = "/getArticleByUuid",method = RequestMethod.POST)
	@ApiOperation(value="查看文章/笔记", notes="文章/笔记")
	public Article getArticleByUuid(@RequestBody  Article article) {
		if(Objects.isNull(article)) {
			PlatException pe = new PlatException(CommonErrors.REQ_PARAM_ERROR, "查看信息");
			pe.setAddtionalMessage("入参有误！");
			throw pe;
		}

		return articleService.queryArticle(article);
	}
	
}
