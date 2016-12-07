package zhentao.zhang.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import zhentao.zhang.service.impl.PostServiceImpl;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Resource
	private PostServiceImpl postService;
	
	@ResponseBody
	@RequestMapping("/addPostAPI")
	public String addPostAPI(HttpServletRequest request){
		
		return "addPostAPI";
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
	
}
