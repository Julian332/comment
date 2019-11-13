package com.trs.comment.dao;

import com.season.core.Page;
import com.season.orm.dao.ISeasonDao;
import com.trs.comment.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * Project: comment
 *
 * @author : Julian.cao
 * Create Time:2019/11/12 17:37
 */
@Repository
public class CommentDao {

    @Autowired
    private ISeasonDao seasonDao;

    public String getUserNameByCommentedId(Integer id) {
        String sql = "select userName from "+Comment.TABLE_NAME+" where replyIdOfComment = ? ";
        Comment seasonDaoFirst = seasonDao.findFirst(Comment.class, sql, id);
        return seasonDaoFirst.getUserName();
    }

    public Page getPage(Integer pageNo, Integer pageSize) {
        String sql = "select * from " + Comment.TABLE_NAME;

        return seasonDao.page(pageNo, pageSize, sql, null);
    }

    public Comment save(Comment comment){
        return seasonDao.save(comment);
    }

    public Integer removeCommentById(Integer id){
        return seasonDao.deleteById(Comment.class, id);
    }

    public Integer updateComment(Comment comment){
        return seasonDao.update(comment, null);
    }

}
