package zhentao.zhang.service;

import zhentao.zhang.pojo.RefereeReservation;

public interface IRefereeReservationService {
	public String getAllReservation();
	public boolean addReservation(RefereeReservation res);
	public boolean hasReply(int refereeId,int reservationId);
	public boolean updateReply(int refereeId,int reservationId,boolean isDelete);
}
