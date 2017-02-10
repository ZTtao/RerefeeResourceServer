package zhentao.zhang.service;

import zhentao.zhang.pojo.Referee;

public interface IRefereeService {
	public String getRefereeByNickName(String nickName);
	public boolean addOrUpdateReferee(Referee referee);
	public String addReferee(Integer userId,Referee referee);
	public boolean updateReferee(Referee referee);
	public boolean deleteReferee(Integer refereeId);
}
