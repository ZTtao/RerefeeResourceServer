package zhentao.zhang.dao;

import java.util.List;

import zhentao.zhang.pojo.Review;

public interface ReviewMapper {
	public int softDeleteByPrimaryKey(int reviewId);
	public List<Review> selectByClause(String whereClause);
	public int insertSelective(Review review);
	public int countByPostId(int postId);
}
