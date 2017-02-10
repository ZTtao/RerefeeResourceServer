package zhentao.zhang.dao;

import zhentao.zhang.pojo.Read;

public interface ReadMapper {
	public int insertSelective(Read read);
	public int countByPostId(int postId);
}
