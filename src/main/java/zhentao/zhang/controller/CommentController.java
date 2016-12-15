package zhentao.zhang.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zhentao.zhang.pojo.Comment;
import zhentao.zhang.service.impl.CommentServiceImpl;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Resource
	private CommentServiceImpl commentService;
	
	@RequestMapping("/getCommentAPI")
	@ResponseBody
	public String getCommentAPI(HttpServletRequest request,HttpServletResponse response){
		int postId = Integer.parseInt(request.getParameter("postId"));
		return commentService.getCommentByPostId(postId);
	}
	
	@RequestMapping("/addCommentAPI")
	@ResponseBody
	public String addCommentAPI(HttpServletRequest request,HttpServletResponse response){
		Comment comment = new Comment();
		comment.setContent(request.getParameter("content"));
		comment.setPostId(Integer.parseInt(request.getParameter("postId")));
		comment.setCreateTime(new Date(Long.parseLong(request.getParameter("createTime"))));
		comment.setIsDelete(false);
		comment.setUserId(Integer.parseInt(request.getParameter("userId")));
		if(commentService.addComment(comment))return "success";
		else return "faild";
	}
}
