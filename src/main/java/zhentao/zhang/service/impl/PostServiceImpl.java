package zhentao.zhang.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhentao.zhang.dao.CollectionMapper;
import zhentao.zhang.dao.PostMapper;
import zhentao.zhang.pojo.Collection;
import zhentao.zhang.pojo.CollectionExample;
import zhentao.zhang.pojo.Post;
import zhentao.zhang.pojo.PostExample;
import zhentao.zhang.service.IPostService;

@Service
public class PostServiceImpl implements IPostService {

	@Resource
	private PostMapper postMapper;
	
	@Resource
	private CollectionMapper collectionMapper;
	
	@Resource
	private UserServiceImpl userService;
	
	@Override
	public String getPostList() {
		// TODO Auto-generated method stub
		PostExample example = new PostExample();
		example.or().andIsDeleteEqualTo(false);
		example.setOrderByClause("create_time desc");
		List<Post> list = postMapper.selectByExample(example);
		int index=0;
		List<Integer> idList = new ArrayList<Integer>();
		while(index < list.size()){
			idList.add(list.get(index).getUserId());
			index++;
		}
		Map<Integer,String> map = userService.getUserNameById(idList);
		int i=0;
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		while(i<list.size()){
			builder.append(",");
			builder.append("{");
			builder.append("'title':'");
			builder.append(list.get(i).getTitle());
			builder.append("','content':'");
			builder.append(list.get(i).getContent());
			builder.append("','createTime':");
			builder.append(list.get(i).getCreateTime().getTime());
			builder.append(",'isDelete':");
			builder.append(list.get(i).getIsDelete());
			builder.append(",'note':'");
			builder.append(list.get(i).getNote());
			builder.append("','other':'");
			builder.append(list.get(i).getOther());
			builder.append("','postId':");
			builder.append(list.get(i).getPostId());
			builder.append(",'userId':");
			builder.append(list.get(i).getUserId());
			builder.append(",'userName':'");
			builder.append(map.get(list.get(i).getUserId()));
			builder.append("'}");
			i++;
		}
		builder.deleteCharAt(1);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public boolean addPost(Post post) {
		// TODO Auto-generated method stub
		int count = postMapper.insertSelective(post);
		if(count > 0 )return true;
		else return false;
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
	
}
