package zhentao.zhang.service;

import java.util.List;
import java.util.Map;

import zhentao.zhang.pojo.Review;

public interface IReviewService {
	public Map<String,Object> deleteReview(int reviewId);
	public List<Review> findReviewByClause(String whereClause);
	public int saveReview(Review review);
	public int countReviewByPostId(int postId);
}
