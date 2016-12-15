package zhentao.zhang.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhentao.zhang.dao.CommentMapper;
import zhentao.zhang.pojo.Comment;
import zhentao.zhang.pojo.CommentExample;
import zhentao.zhang.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService {
	@Resource
	private CommentMapper commentMapper;
	@Resource
	private UserServiceImpl userService;
	
	@Override
	public String getCommentByPostId(int postId) {
		// TODO Auto-generated method stub
		CommentExample example = new CommentExample();
		example.or().andPostIdEqualTo(postId).andIsDeleteEqualTo(false);
		List<Comment> list = commentMapper.selectByExample(example);
		if(list.size() > 0){
			List<Integer> idList = new ArrayList<Integer>();
			int index = 0 ;
			while(index < list.size()){
				idList.add(list.get(index).getUserId());
				index++;
			}
			Map<Integer,String> map = userService.getUserNameById(idList);
			int i = 0;
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			while(i < list.size()){
				builder.append(",");
				builder.append("{");
				builder.append("'commentId':");
				builder.append(list.get(i).getCommentId());
				builder.append(",'postId':");
				builder.append(list.get(i).getPostId());
				builder.append(",'createTime':");
				builder.append(list.get(i).getCreateTime().getTime());
				builder.append(",'isDelete':");
				builder.append(list.get(i).getIsDelete());
				builder.append(",'content':'");
				builder.append(list.get(i).getContent());
				builder.append("','userId':");
				builder.append(list.get(i).getUserId());
				builder.append(",'userName':'");
				builder.append(map.get(list.get(i).getUserId()));
				builder.append("'}");
				i++;
			}
			builder.deleteCharAt(1);
			builder.append("]");
			return builder.toString();
		}else return "nodata";
	}

	@Override
	public boolean addComment(Comment comment) {
		// TODO Auto-generated method stub
		int count = commentMapper.insertSelective(comment);
		if(count > 0)return true;
		else return false;
	}

}
