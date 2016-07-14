package com.muran.api.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.muran.api.Context;
import com.muran.api.service.AbstractService;
import com.muran.api.service.IKeywordsService;
import com.muran.dao.IActivityDao;
import com.muran.dao.IArticleDao;
import com.muran.model.Activity;
import com.muran.model.Article;
import com.muran.util.CommonUtil;

@Service
public class KeywordsService extends AbstractService implements
		IKeywordsService {

	@Resource(name = "ArticleDao")
	private IArticleDao dao;

	@Resource(name = "ActivityDao")
	private IActivityDao actDao;

	@Override
	public Response getKeywords(String columnKey, Context context) {
		// TODO Auto-generated method stub
		int count=10;
		
		List<String> list2 = new ArrayList<String>();
		if (columnKey.equals("column_activities")) {
			List<Activity> list = actDao.getRandomList(count);
			if (list != null && !list.isEmpty()) {
				for (Activity activity : list) {
					list2.addAll(CommonUtil.getByStrings(activity.getKeywords(),
							","));
				}
			}

		} else {
			List<Article> list = dao.getRandomList(columnKey, count);
			if (list != null && !list.isEmpty()) {
				for (Article article : list) {
					list2.addAll(CommonUtil.getByStrings(article.getKeywords(),
							","));
				}
			}
		}
		if (list2 != null && list2.size() > count) {
			list2 = list2.subList(0, count);
		}
		return Response.ok().entity(list2).build();
	}

}
