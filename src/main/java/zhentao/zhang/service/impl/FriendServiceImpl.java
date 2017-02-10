package zhentao.zhang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhentao.zhang.dao.FriendMapper;
import zhentao.zhang.pojo.Friend;
import zhentao.zhang.service.IFriendService;

@Service
public class FriendServiceImpl implements IFriendService{
	
	@Resource
	private FriendMapper friendMapper;

	@Override
	public List<Friend> findFriend(String whereClause) {
		return friendMapper.selectByCondition(whereClause);
	}

}
