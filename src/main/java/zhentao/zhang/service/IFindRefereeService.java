package zhentao.zhang.service;

import java.util.List;

import zhentao.zhang.pojo.FindRefereeMessage;

public interface IFindRefereeService {
	public int saveFindRefereeMessage(FindRefereeMessage message);
	public List<FindRefereeMessage> findMessageByCondition(String whereClause,String orderByClause,String limitClause);
	public boolean addReadCount(int messageId);
	public boolean addApplyCount(int messageId);
}
