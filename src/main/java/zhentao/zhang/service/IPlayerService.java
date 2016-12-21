package zhentao.zhang.service;

import zhentao.zhang.pojo.Player;

public interface IPlayerService {
	public String getPlayerByNickName(String nickName);
	public boolean addOrUpdatePlayer(Player player);
}
