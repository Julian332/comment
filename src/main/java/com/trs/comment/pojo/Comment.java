package com.trs.comment.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.season.orm.dao.annotation.TableInfo;
import com.season.orm.dao.annotation.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description:
 * Project: comment
 *
 * @author : Julian.cao
 * Create Time:2019/11/12 11:26
 */

@TableInfo(tableName = Comment.TABLE_NAME, pkName = "id")
public class Comment {

    @Transient
    public final static String TABLE_NAME = "comment_comment";

    private Integer id;

    private String content;

    private String userName;

    private Integer replyIdOfComment;

    private Integer commentedId;

    public Comment() {
    }

    public Comment(Integer id, String content, String userName, Integer replyIdOfComment, Integer commentedId, Date commentTime) {
        this.id = id;
        this.content = content;
        this.userName = userName;
        this.replyIdOfComment = replyIdOfComment;
        this.commentedId = commentedId;
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                ", replyIdOfComment=" + replyIdOfComment +
                ", commentedId=" + commentedId +
                ", commentTime=" + commentTime +
                '}';
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getReplyIdOfComment() {
        return replyIdOfComment;
    }

    public void setReplyIdOfComment(Integer replyIdOfComment) {
        this.replyIdOfComment = replyIdOfComment;
    }

    public Integer getCommentedId() {
        return commentedId;
    }

    public void setCommentedId(Integer commentedId) {
        this.commentedId = commentedId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date commentTime;
}
