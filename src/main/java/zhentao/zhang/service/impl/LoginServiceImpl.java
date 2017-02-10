package zhentao.zhang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import zhentao.zhang.dao.UserMapper;
import zhentao.zhang.pojo.User;
import zhentao.zhang.pojo.UserExample;
import zhentao.zhang.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public User checkAccountAndPassword(String account, String password) {
		// TODO Auto-generated method stub
//		UserExample example = new UserExample();
//		example.or().andNickNameEqualTo(account).andPasswordEqualTo(password);
		List<User> list = userMapper.selectByPhoneAndPassword(account,password);
		if(list.size()>0)return list.get(0);
		else return null;
	}
}
