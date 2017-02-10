package zhentao.zhang.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhentao.zhang.dao.FriendMapper;
import zhentao.zhang.dao.PlayerMapper;
import zhentao.zhang.dao.RefereeMapper;
import zhentao.zhang.dao.UserMapper;
import zhentao.zhang.pojo.Friend;
import zhentao.zhang.pojo.FriendExample;
import zhentao.zhang.pojo.Player;
import zhentao.zhang.pojo.PlayerExample;
import zhentao.zhang.pojo.Referee;
import zhentao.zhang.pojo.RefereeExample;
import zhentao.zhang.pojo.User;
import zhentao.zhang.pojo.UserExample;
import zhentao.zhang.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserMapper mapper;
	@Resource
	private PlayerMapper playerMapper;
	@Resource
	private RefereeMapper refereeMapper;
	@Resource
	private FriendMapper friendMapper;

	@Override
	public Map<Integer,String> getUserNameById(List<Integer> idList) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		example.or().andUserIdIn(idList);
		List<User> list = mapper.selectByExample(example);
		int index=0;
		Map<Integer,String> map = new HashMap<Integer,String>();
		while(index < list.size()){
//			map.put(list.get(index).getUserId(), list.get(index).getNickName());
			index++;
		}
		return map;
	}

	@Override
	public boolean hasUserByNickName(String nickName) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		example.or().andNickNameEqualTo(nickName).andIsDeleteEqualTo(false);
		List<User> list = mapper.selectByExample(example);
		if(list.size()>0)return true;
		else return false;
	}

	@Override
	public boolean updateUserInfo(User user) {
		// TODO Auto-generated method stub
//		UserExample example = new UserExample();
//		example.or().andNickNameEqualTo(user.getNickName()).andIsDeleteEqualTo(false);
//		List<User> list = mapper.selectByExample(example);
//		if(list != null && list.size()>0){
//			user.setUserId(list.get(0).getUserId());
//			user.setIsDelete(false);
//			user.setOther(list.get(0).getOther());
//			user.setPassword(list.get(0).getPassword());
//			user.setRegisterTime(list.get(0).getRegisterTime());
			int count = mapper.updateByPrimaryKeySelective(user);
			if(count >= 1)return true;
			else return false;
//		}else return false;
	}

	@Override
	public int getUserIdByNickName(String nickName) {
		UserExample example = new UserExample();
		example.or().andNickNameEqualTo(nickName).andIsDeleteEqualTo(false);
		List<User> list = mapper.selectByExample(example);
		if(list != null && list.size() > 0)return list.get(0).getUserId();
		return -1;
	}

	@Override
	public List<User> getUserNameLikeCondition(String condition) {
//		UserExample example = new UserExample();
//		example.or().andNickNameLike("%"+condition+"%").andIsDeleteEqualTo(false);
		List<User> list = mapper.selectLikeName(condition);
//		Map<String,String> map ;
//		List<Map<String,String>> list1 = new ArrayList<Map<String,String>>();
//		if(list != null)
//		for(int i=0;i<list.size();i++){
//			map = new HashMap<String,String>();
//			map.put("id", list.get(i).getUserId()+"");
////			map.put("name", list.get(i).getNickName());
//			list1.add(map);
//		}
		return list;
	}

	@Override
	public Map<String, Object> getUserInfoById(int userId,int friendId) {
		Map<String,Object> map = new HashMap<String,Object>();
		User user = mapper.selectByPrimaryKey(friendId);
		map.put("user", user);
		PlayerExample example = new PlayerExample();
		example.or().andUserIdEqualTo(friendId).andIsDeleteEqualTo(false);
		List<Player> list = playerMapper.selectByExample(example);
		if(list != null && list.size() > 0)map.put("player", list.get(0));
		else map.put("player", null);
		RefereeExample example1 = new RefereeExample();
		example1.or().andUserIdEqualTo(friendId).andIsDeleteEqualTo(false);
		List<Referee> list1 = refereeMapper.selectByExample(example1);
		if(list != null && list.size() > 0)map.put("referee", list1.get(0));
		else map.put("referee", null);
		FriendExample example2 = new FriendExample();
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(userId);
		list2.add(friendId);
		example2.or().andFromIdIn(list2).andToIdIn(list2).andIsDeleteEqualTo(false);
		List<Friend> list3 = friendMapper.selectByExample(example2);
		if(list3 != null && list3.size() > 0){
			map.put("isFriend", true);
		}else map.put("isFriend", false);
		return map;
	}
	@Override
	public boolean addFriend(int userId, int friendId) {
		Friend friend = new Friend();
		friend.setFromId(userId);
		friend.setToId(friendId);
		friend.setCreateTime(new Date());
		friend.setIsDelete(false);
		int count = friendMapper.insertSelective(friend);
		if(count > 0)return true;
		else return false;
	}

	@Override
	public int addUser(User user) {
		int count = mapper.insertSelective(user);
		if(count > 0)user.getUserId();
		return 0;
	}
	
	@Override
	public boolean setPlayerId(int userId,int playerId){
		int count = mapper.setPlayerId(userId, playerId);
		if(count > 0)
			return true;
		else return false;
	}
	
	@Override
	public boolean setRefereeId(int userId,int refereeId){
		int count = mapper.setRefereeId(userId, refereeId);
		if(count > 0)
			return true;
		else return false;
	}

	@Override
	public User getUserById(int userId) {
		return mapper.selectByPrimaryKey(userId);
	}
}
