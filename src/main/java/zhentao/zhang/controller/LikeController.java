package zhentao.zhang.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import zhentao.zhang.pojo.Like;
import zhentao.zhang.pojo.Post;
import zhentao.zhang.pojo.User;
import zhentao.zhang.service.ILikeService;

@RequestMapping("/like")
@Controller
public class LikeController {
	
	@Resource
	private ILikeService likeService;
	
	@RequestMapping("/findLike")
	@ResponseBody
	public String findLike(String whereClause,String orderByClause,String limitClause){
		return JSON.toJSONString(likeService.findLike(whereClause, orderByClause, limitClause));
	}
	
	@RequestMapping("/isLiked")
	@ResponseBody
	public String isLiked(Integer postId,Integer userId){
		return JSON.toJSONString(likeService.countByPostUser(postId,userId));
	}
	
	@RequestMapping("/addLike")
	@ResponseBody
	public String addLike(Integer postId,Integer userId){
		Like like = new Like();
		Post post = new Post();
		post.setPostId(postId);
		User user = new User();
		user.setUserId(userId);
		like.setPost(post);
		like.setUser(user);
		return JSON.toJSONString(likeService.addLike(like));
	}
	
	@RequestMapping("/deleteLike")
	@ResponseBody
	public String deleteLike(Integer postId,Integer userId){
		return JSON.toJSONString(likeService.deleteLike(postId,userId));
	}
	
	@RequestMapping("/countLike")
	@ResponseBody
	public String countLike(Integer postId){
		return JSON.toJSONString(likeService.countByPost(postId));
	}
}
