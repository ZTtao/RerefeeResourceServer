package zhentao.zhang.service;

import java.util.List;
import java.util.Map;

import zhentao.zhang.pojo.User;

public interface IUserService {
	int addUser(User user);
	Map<Integer,String> getUserNameById(List<Integer> idList);
	boolean hasUserByNickName(String nickName);
	boolean updateUserInfo(User user);
	int getUserIdByNickName(String nickName);
	List<User> getUserNameLikeCondition(String condition);
	Map<String,Object> getUserInfoById(int userId,int friendId);
	boolean addFriend(int userId,int friendId);
	boolean setPlayerId(int userId,int playerId);
	boolean setRefereeId(int userId,int refereeId);
	User getUserById(int userId);
}
