package zhentao.zhang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhentao.zhang.dao.UserMapper;
import zhentao.zhang.pojo.User;
import zhentao.zhang.pojo.UserExample;
import zhentao.zhang.service.IRegisterService;

@Service
public class RegisterServiceImpl implements IRegisterService {

	@Resource
	private UserMapper userMapper;
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		example.or().andNickNameEqualTo(user.getNickName()).andIsDeleteEqualTo(false);
		List<User> list = userMapper.selectByExample(example);
		if(list != null & list.size()>0)return false;
		else{
			userMapper.insertSelective(user);
			return true;
		}
	}

}
