package com.muran.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.muran.dao.ICommentDao;
import com.muran.model.Comment;

@SuppressWarnings("unchecked")
@Repository("CommentDao")
public class CommentDao extends AbstractHibernateDao<Comment> implements ICommentDao {

	@Override
	public List<Comment> getList(String columnKey, Long itemId, Long status) {
		// TODO Auto-generated method stub
		return null;
	}

}
