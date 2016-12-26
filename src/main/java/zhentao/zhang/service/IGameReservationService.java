package zhentao.zhang.service;

import zhentao.zhang.pojo.GameReservation;

public interface IGameReservationService {
	public String getAllReservation();
	public boolean addReservation(GameReservation res);
	public boolean hasReply(int playerId,int reservationId);
	public boolean updateReply(int playerId,int reservationId,boolean isDelete);
}
