package zhentao.zhang.service;

import zhentao.zhang.pojo.Referee;

public interface IRefereeService {
	public String getRefereeByNickName(String nickName);
	public boolean addOrUpdateReferee(Referee referee);
}
