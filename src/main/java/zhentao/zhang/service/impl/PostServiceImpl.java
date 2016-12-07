package zhentao.zhang.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhentao.zhang.dao.PostMapper;
import zhentao.zhang.pojo.Post;
import zhentao.zhang.pojo.PostExample;
import zhentao.zhang.service.IPostService;

@Service
public class PostServiceImpl implements IPostService {

	@Resource
	private PostMapper postMapper;
	
	@Resource
	private UserServiceImpl userService;
	
	@Override
	public String getPostList() {
		// TODO Auto-generated method stub
		PostExample example = new PostExample();
		List<Post> list = postMapper.selectByExample(example);
		int index=0;
		List<Integer> idList = new ArrayList<Integer>();
		while(index < list.size()){
			idList.add(list.get(index).getUserId());
			index++;
		}
		Map<Integer,String> map = userService.getUserNameById(idList);
		List<Object> map1 = new ArrayList<Object>();
		int i=0;
		int userId=0;
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		while(i<list.size()){
			userId = list.get(i).getUserId();
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
	
}