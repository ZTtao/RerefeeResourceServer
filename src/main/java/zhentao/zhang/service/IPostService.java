package zhentao.zhang.service;



import java.util.List;

import zhentao.zhang.pojo.Post;

public interface IPostService {
	List<Post> getPostList(String whereClause,String orderByClause,String limitClause);
	Post getPostById(int postId);
	int addPost(Post post);
	boolean isLiked(int postId,int userId);
	boolean like(int postId,int userId);
	boolean cancelLike(int postId,int userId);
	boolean deletePost(int postId);
}
