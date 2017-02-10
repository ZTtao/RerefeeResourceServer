package zhentao.zhang.service;

import zhentao.zhang.pojo.Read;

public interface IReadService {
	public int saveRead(Read read);
	public int countRead(int postId);
}
