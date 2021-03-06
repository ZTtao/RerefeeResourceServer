package zhentao.zhang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public String addPlayer(Integer userId,Player player) {
//		PlayerExample example = new PlayerExample();
//		example.or().andUserIdEqualTo(player.getUserId());
//		List<Player> list = playerMapper.selectByExample(example);
//		int count=0;
//		if(list != null && list.size()>0){
//			player.setPlayerId(list.get(0).getPlayerId());
//			count = playerMapper.updateByPrimaryKey(player);
//		}else{
//			count = playerMapper.insertSelective(player);
//		}
//		if(count>0)return true;
//		return false;
		playerMapper.insertSelective(player);
		boolean b = userService.setPlayerId(userId, player.getPlayerId());
		Map<String,String> map = new HashMap<String,String>();
		if(b){
			map.put("errorCode", 100+"");
			map.put("result", player.getPlayerId()+"");
		}else{
			map.put("errorCode", 101+"");
			map.put("result", "error");
		}
		return JSON.toJSONString(map);
	}

	@Override
	public Map<Integer, Integer> getUserIdByPlayerId(List<Integer> list) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<list.size();i++){
//			map.put(list.get(i), playerMapper.selectByPrimaryKey(list.get(i)).getUserId());
		}
		return map;
	}

	@Override
	public boolean updatePlayer(Player player) {
		int count = playerMapper.updateByPrimaryKeySelective(player);
		if(count > 0)return true;
		return false;
	}
	@Override
	public boolean deletePlayer(Integer playerId){
		int count = playerMapper.deleteByPrimaryKey(playerId);
		if(count > 0)return true;
		return false;
	}
}
