package zhentao.zhang.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhentao.zhang.dao.CollectionMapper;
import zhentao.zhang.dao.PostMapper;
import zhentao.zhang.pojo.Collection;
import zhentao.zhang.pojo.CollectionExample;
import zhentao.zhang.pojo.Post;
import zhentao.zhang.service.IPostService;
import zhentao.zhang.service.IUserService;

@Service
public class PostServiceImpl implements IPostService {

	@Resource
	private PostMapper postMapper;
	
	@Resource
	private CollectionMapper collectionMapper;
	
	@Resource
	private IUserService userService;
	
	@Override
	public List<Post> getPostList(String whereClause,String orderByClause,String limitClause) {
		return postMapper.selectByCondition(whereClause, orderByClause, limitClause);
	}
	
	@Override
	public Post getPostById(int postId){
		return postMapper.selectByPrimaryKey(postId);
	}
	
	@Override
	public int addPost(Post post) {
		// TODO Auto-generated method stub
		int count = postMapper.insertSelective(post);
		if(count > 0 )return post.getPostId();
		else return -1;
	}

	@Override
	public boolean isLiked(int postId, int userId) {
		CollectionExample example = new CollectionExample();
		example.or().andPostIdEqualTo(postId).andUserIdEqualTo(userId).andIsDeleteEqualTo(false);
		List<Collection> list = collectionMapper.selectByExample(example);
		if(list != null && list.size()>0)return true;
		return false;
	}

	@Override
	public boolean like(int postId, int userId) {
		CollectionExample example = new CollectionExample();
		example.or().andPostIdEqualTo(postId).andUserIdEqualTo(userId);
		List<Collection> list = collectionMapper.selectByExample(example);
		if(list != null && list.size()>0){
			list.get(0).setIsDelete(false);
			list.get(0).setCollTime(new Date());
			int count = collectionMapper.updateByPrimaryKey(list.get(0));
			if(count > 0)return true;
			else return false;
		}else{
			Collection collection = new Collection();
			collection.setCollTime(new Date());
			collection.setCreateTime(new Date());
			collection.setIsDelete(false);
			collection.setPostId(postId);
			collection.setUserId(userId);
			int count = collectionMapper.insertSelective(collection);
			if(count > 0)return true;
			else return false;
		}
	}

	@Override
	public boolean cancelLike(int postId, int userId) {
		CollectionExample example = new CollectionExample();
		example.or().andPostIdEqualTo(postId).andUserIdEqualTo(userId);
		List<Collection> list = collectionMapper.selectByExample(example);
		if(list != null && list.size()>0){
			list.get(0).setIsDelete(true);
			int count = collectionMapper.updateByPrimaryKey(list.get(0));
			if(count > 0)return true;
			else return false;
		}
		return true;
	}

	@Override
	public boolean deletePost(int postId) {
		int count = postMapper.softDeleteByPrimaryKey(postId);
		if(count > 0)return true;
		return false;
	}
	
}
