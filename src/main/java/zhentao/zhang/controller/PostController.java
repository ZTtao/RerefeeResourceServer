package zhentao.zhang.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zhentao.zhang.pojo.Post;
import zhentao.zhang.service.IPostService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Resource
	private IPostService postService;
	
	@ResponseBody
	@RequestMapping("/addPostAPI")
	public String addPostAPI(HttpServletRequest request){
		Post post = new Post();
		post.setContent(request.getParameter("content"));
		post.setCreateTime(new Date(Long.parseLong(request.getParameter("createTime"))));
		post.setIsDelete(false);
		post.setTitle(request.getParameter("title"));
		post.setUserId(Integer.parseInt(request.getParameter("userId")));
		if(postService.addPost(post))return "success";
		else return "faild";
	}
	@ResponseBody
	@RequestMapping("/getPostAPI")
	public String getPostAPI(HttpServletRequest request){
		return postService.getPostList();
	}
	@ResponseBody
	@RequestMapping("/deletePostAPI")
	public String deletePostAPI(HttpServletRequest request){
		
		return "deletePostAPI";
	}
	
	@ResponseBody
	@RequestMapping("/isLiked")
	public String isLiked(HttpServletRequest request){
		String postId = request.getParameter("postId");
		String userId = request.getParameter("userId");
		if(postService.isLiked(Integer.parseInt(postId), Integer.parseInt(userId)))return "true";
		return "false";
	}
	
	@ResponseBody
	@RequestMapping("/like")
	public String like(HttpServletRequest request){
		String postId = request.getParameter("postId");
		String userId = request.getParameter("userId");
		if(postService.like(Integer.parseInt(postId), Integer.parseInt(userId)))
			return "success";
		else
			return "faild";
	}
	
	@ResponseBody
	@RequestMapping("/cancelLike")
	public String cancelLike(HttpServletRequest request){
		String postId = request.getParameter("postId");
		String userId = request.getParameter("userId");
		if(postService.cancelLike(Integer.parseInt(postId), Integer.parseInt(userId)))
			return "success";
		else
			return "faild";
	}
}
