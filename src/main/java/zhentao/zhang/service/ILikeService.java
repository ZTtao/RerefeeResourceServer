package zhentao.zhang.service;

import java.util.List;

import zhentao.zhang.pojo.Like;

public interface ILikeService {
	public List<Like> findLike(String whereClause,String orderByClause,String limitClause);
	public int countByPostUser(int postId,int userId);
	public int addLike(Like like);
	public int deleteLike(int postId,int userId);
	public int countByPost(int postId);
}
