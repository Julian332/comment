package com.trs.comment.service;

import com.season.core.Page;
import com.trs.comment.dao.CommentDao;
import com.trs.comment.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Project: comment
 *
 * @author : Julian.cao
 * Create Time:2019/11/12 17:36
 */
@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;

    public String getUserNameByCommentedId(Integer id) {
        return commentDao.getUserNameByCommentedId(id);
    }

    public Page getPage(Integer pageNo, Integer pageSize) {

        return commentDao.getPage(pageNo, pageSize);
    }

    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }

    public Integer removeCommentById(Integer id){
        return commentDao.removeCommentById(id);
    }
}
