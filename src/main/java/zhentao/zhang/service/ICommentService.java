package zhentao.zhang.service;

import zhentao.zhang.pojo.Comment;

public interface ICommentService {
	String getCommentByPostId(int postId);
	boolean addComment(Comment comment);
}
