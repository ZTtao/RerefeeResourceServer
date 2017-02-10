package zhentao.zhang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhentao.zhang.dao.ReviewMapper;
import zhentao.zhang.pojo.Review;
import zhentao.zhang.service.IReviewService;

@Service
public class ReviewServiceImpl implements IReviewService{
	
	@Resource
	private ReviewMapper reviewMapper;

	@Override
	public Map<String, Object> deleteReview(int reviewId) {
		Map<String,Object> map = new HashMap<String,Object>();
		int count = reviewMapper.softDeleteByPrimaryKey(reviewId);
		if(count > 0){
			map.put("errorCode", 100);
			map.put("result","success");
		}else{
			map.put("errorCode", 101);
			map.put("result", "faild");
		}
		return map;
	}

	@Override
	public List<Review> findReviewByClause(String whereClause) {
		return reviewMapper.selectByClause(whereClause);
	}

	@Override
	public int saveReview(Review review) {
		return reviewMapper.insertSelective(review);
	}

	@Override
	public int countReviewByPostId(int postId) {
		return reviewMapper.countByPostId(postId);
	}

}
