package zhentao.zhang.service;

import java.util.List;
import java.util.Map;

import zhentao.zhang.pojo.Player;

public interface IPlayerService {
	public String getPlayerByNickName(String nickName);
	public boolean addOrUpdatePlayer(Player player);
	public Map<Integer,Integer> getUserIdByPlayerId(List<Integer> playerId);
}
