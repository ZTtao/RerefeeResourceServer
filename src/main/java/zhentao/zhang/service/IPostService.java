package zhentao.zhang.service;

import java.util.List;

import zhentao.zhang.pojo.Post;

public interface IPostService {
	String getPostList();
	boolean addPost(Post post);
}
