package zhentao.zhang.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import zhentao.zhang.pojo.Review;
import zhentao.zhang.service.IReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	@Resource
	private IReviewService reviewService;
	
	@RequestMapping("/deleteReview")
	@ResponseBody
	public String deleteReview(int reviewId){
		return JSON.toJSONString(reviewService.deleteReview(reviewId));
	}
	
	@RequestMapping("/findReview")
	@ResponseBody
	public String findReview(String whereClause){
		return JSON.toJSONString(reviewService.findReviewByClause(whereClause));
	}
	
	@RequestMapping("/saveReview")
	@ResponseBody
	public String saveReview(Review review){
		return JSON.toJSONString(reviewService.saveReview(review));
	}
	
	@RequestMapping("/countReviewByPostId")
	@ResponseBody
	public String countReviewByPostId(Integer postId){
		return JSON.toJSONString(reviewService.countReviewByPostId(postId));
	}
}
