package zhentao.zhang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import zhentao.zhang.pojo.Like;

public interface LikeMapper {
	public List<Like> selectByCondition(@Param("whereClause")String whereClause,@Param("orderByClause")String orderByClause,@Param("limitClause")String limitClause);
	public int countByPostUser(@Param("postId")Integer postId,@Param("userId")Integer userId);
	public int insertSelective(Like like);
	public int deleteByPostUser(@Param("postId")int postId,@Param("userId")int userId);
	public int countByPost(Integer postId);
}
