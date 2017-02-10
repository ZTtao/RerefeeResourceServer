package zhentao.zhang.service;

import java.util.List;

import zhentao.zhang.pojo.Friend;

public interface IFriendService {
	public List<Friend> findFriend(String whereClause);
}
