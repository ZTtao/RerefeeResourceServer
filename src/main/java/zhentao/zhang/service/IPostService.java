package zhentao.zhang.service;


import zhentao.zhang.pojo.Post;

public interface IPostService {
	String getPostList();
	boolean addPost(Post post);
	boolean isLiked(int postId,int userId);
	boolean like(int postId,int userId);
	boolean cancelLike(int postId,int userId);
}
