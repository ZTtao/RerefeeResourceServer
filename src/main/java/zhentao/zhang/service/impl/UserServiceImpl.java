package zhentao.zhang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhentao.zhang.dao.UserMapper;
import zhentao.zhang.pojo.User;
import zhentao.zhang.pojo.UserExample;
import zhentao.zhang.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserMapper mapper;

	@Override
	public Map<Integer,String> getUserNameById(List<Integer> idList) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		example.or().andUserIdIn(idList);
		List<User> list = mapper.selectByExample(example);
		int index=0;
		Map<Integer,String> map = new HashMap<Integer,String>();
		while(index < list.size()){
			map.put(list.get(index).getUserId(), list.get(index).getNickName());
			index++;
		}
		return map;
	}

}
