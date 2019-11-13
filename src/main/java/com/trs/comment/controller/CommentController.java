package com.trs.comment.controller;

import com.season.core.Page;
import com.trs.comment.pojo.Comment;
import com.trs.comment.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 * Project: comment
 *
 * @author : Julian.cao
 * Create Time:2019/11/12 10:47
 */

@Slf4j
@Controller
public class CommentController {

    @Resource(name = "commentService")
    private CommentService commentService;

    @Deprecated
    @RequestMapping("/toPageHtml")
    public String toPageHtml() {
        return "comments";
    }

    @ResponseBody
    @GetMapping("/getPage")
    public Page getPage(Integer pageNo, Integer pageSize) {
//        String sql = "select * from " + Comment.TABLE_NAME + " where `id` > ? ";

        return commentService.getPage(pageNo, pageSize);
    }

    @ResponseBody
    @GetMapping("/getUserNameByCommentedId")
    public String getUserNameByCommentedId(Integer id) {
//        String sql = "select user_name from comment where commented_id = ? ";
        return commentService.getUserNameByCommentedId(id);
    }

    @ResponseBody
    @GetMapping("/save")
    public Comment save(Comment comment, HttpServletResponse httpServletResponse) throws IOException {
        Comment save = commentService.save(comment);
        httpServletResponse.sendRedirect("http://localhost:8080/index.html");
        return save;
        //springboot重定向 "redirect:http..."
    }

    /**
     * Description
     *
     * @param integer id
     * @return java.lang.Integer
     * @author julian cao
     */
    public Integer test(Integer integer, String string) {
        return 1;
    }

    @GetMapping("/removeCommentById")
    public String removeCommentById(Integer id){
         commentService.removeCommentById(id);
         return "redirect:http://localhost:8080/index.html";
    }


}
