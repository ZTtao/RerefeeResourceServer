package zhentao.zhang.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import zhentao.zhang.pojo.Post;
import zhentao.zhang.service.IPostService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Resource
	private IPostService postService;
	
	@ResponseBody
	@RequestMapping("/savePost")
	public String savePost(Post post){
		return JSON.toJSONString(postService.addPost(post));
	}
	@ResponseBody
	@RequestMapping("/getPostAPI")
	public String getPostAPI(String whereClause,String orderByClause,String limitClause){
		return JSON.toJSONString(postService.getPostList(whereClause,orderByClause,limitClause));
	}
	
	@ResponseBody
	@RequestMapping("/getPost")
	public String getPost(Integer postId){
		return JSON.toJSONString(postService.getPostById(postId));
	}
	
	@ResponseBody
	@RequestMapping("/deletePost")
	public String deletePostAPI(Integer postId){
		return JSON.toJSONString(postService.deletePost(postId));
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
