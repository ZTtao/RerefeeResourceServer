package zhentao.zhang.service;

import java.util.List;
import java.util.Map;

import zhentao.zhang.pojo.Player;

public interface IPlayerService {
	public String getPlayerByNickName(String nickName);
	public String addPlayer(Integer userId,Player player);
	public Map<Integer,Integer> getUserIdByPlayerId(List<Integer> playerId);
	public boolean updatePlayer(Player player);
	public boolean deletePlayer(Integer playerId);
}
