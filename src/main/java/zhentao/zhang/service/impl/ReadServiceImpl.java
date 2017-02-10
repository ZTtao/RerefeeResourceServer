package zhentao.zhang.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhentao.zhang.dao.ReadMapper;
import zhentao.zhang.pojo.Read;
import zhentao.zhang.service.IReadService;
@Service
public class ReadServiceImpl implements IReadService{
	
	@Resource
	private ReadMapper readMapper;

	@Override
	public int saveRead(Read read) {
		return readMapper.insertSelective(read);
	}

	@Override
	public int countRead(int postId) {
		return readMapper.countByPostId(postId);
	}

}
