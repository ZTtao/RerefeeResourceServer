package zhentao.zhang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import zhentao.zhang.dao.PlayerMapper;
import zhentao.zhang.pojo.Player;
import zhentao.zhang.pojo.PlayerExample;
import zhentao.zhang.service.IPlayerService;
import zhentao.zhang.service.IUserService;

@Service
public class PlayerServiceImpl implements IPlayerService {

	@Resource
	private PlayerMapper playerMapper;
	
	@Resource
	private IUserService userService;
	
	@Override
	public String getPlayerByNickName(String nickName) {
		int userId = userService.getUserIdByNickName(nickName);
		if(userId != -1){
			PlayerExample example = new PlayerExample();
			example.or().andUserIdEqualTo(userId).andIsDeleteEqualTo(false);
			List<Player> list = playerMapper.selectByExample(example);
			if(list != null && list.size() > 0){
				return JSON.toJSONString(list.get(0));
			}else return "nodata";
		}
		return "nodata";
	}

	@Override
	public boolean addOrUpdatePlayer(Player player) {
		PlayerExample example = new PlayerExample();
		example.or().andUserIdEqualTo(player.getUserId());
		List<Player> list = playerMapper.selectByExample(example);
		int count=0;
		if(list != null && list.size()>0){
			player.setPlayerId(list.get(0).getPlayerId());
			count = playerMapper.updateByPrimaryKey(player);
		}else{
			count = playerMapper.insertSelective(player);
		}
		if(count>0)return true;
		return false;
	}

}
