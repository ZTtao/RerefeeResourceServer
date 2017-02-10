package zhentao.zhang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhentao.zhang.dao.LikeMapper;
import zhentao.zhang.pojo.Like;
import zhentao.zhang.service.ILikeService;

@Service
public class LikeServiceImpl implements ILikeService{
	
	@Resource
	private LikeMapper likeMapper;

	@Override
	public List<Like> findLike(String whereClause, String orderByClause, String limitClause) {
		return likeMapper.selectByCondition(whereClause, orderByClause, limitClause);
	}

	@Override
	public int countByPostUser(int postId, int userId) {
		return likeMapper.countByPostUser(postId,userId);
	}

	@Override
	public int addLike(Like like) {
		int count = likeMapper.insertSelective(like);
		if(count>0)return like.getId();
		return -1;
	}

	@Override
	public int deleteLike(int postId, int userId) {
		return likeMapper.deleteByPostUser(postId,userId);
	}
	
	@Override
	public int countByPost(int postId){
		return likeMapper.countByPost(postId);
	}

}
