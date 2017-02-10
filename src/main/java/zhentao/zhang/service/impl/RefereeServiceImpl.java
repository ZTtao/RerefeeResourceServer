package zhentao.zhang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import zhentao.zhang.dao.RefereeMapper;
import zhentao.zhang.pojo.Referee;
import zhentao.zhang.pojo.RefereeExample;
import zhentao.zhang.service.IRefereeService;
import zhentao.zhang.service.IUserService;

@Service
public class RefereeServiceImpl implements IRefereeService{

	@Resource
	private RefereeMapper refereeMapper;
	
	@Resource
	private IUserService userService;
	
	@Override
	public String getRefereeByNickName(String nickName) {
		int userId = userService.getUserIdByNickName(nickName);
		if(userId != -1){
			RefereeExample example = new RefereeExample();
			example.or().andUserIdEqualTo(userId).andIsDeleteEqualTo(false);
			List<Referee> list = refereeMapper.selectByExample(example);
			if(list != null && list.size() > 0){
				return JSON.toJSONString(list.get(0));
			}else return "nodata";
		}
		return "nodata";
	}

	@Override
	public boolean addOrUpdateReferee(Referee referee) {
		RefereeExample example = new RefereeExample();
//		example.or().andUserIdEqualTo(referee.getUserId());
		List<Referee> list = refereeMapper.selectByExample(example);
		int count=0;
		if(list != null && list.size()>0){
			referee.setRefereeId(list.get(0).getRefereeId());
			count = refereeMapper.updateByPrimaryKey(referee);
		}else{
			count = refereeMapper.insertSelective(referee);
		}
		if(count>0)return true;
		return false;
	}

	@Override
	public String addReferee(Integer userId, Referee referee) {
		refereeMapper.insertSelective(referee);
		boolean b = userService.setRefereeId(userId, referee.getRefereeId());
		Map<String,String> map = new HashMap<String,String>();
		if(b){
			map.put("errorCode", 100+"");
			map.put("result", referee.getRefereeId()+"");
		}else{
			map.put("errorCode", 101+"");
			map.put("result", "error");
		}
		return JSON.toJSONString(map);
	}

	@Override
	public boolean updateReferee(Referee referee) {
		int count = refereeMapper.updateByPrimaryKeySelective(referee);
		if(count > 0)return true;
		return false;
	}

	@Override
	public boolean deleteReferee(Integer refereeId) {
		int count = refereeMapper.deleteByPrimaryKey(refereeId);
		if(count > 0)return true;
		return false;
	}
	
}
