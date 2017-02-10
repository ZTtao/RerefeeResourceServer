package zhentao.zhang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhentao.zhang.dao.FindRefereeMapper;
import zhentao.zhang.pojo.FindRefereeMessage;
import zhentao.zhang.service.IFindRefereeService;

@Service
public class FindRefereeServiceImpl implements IFindRefereeService{
	
	@Resource
	private FindRefereeMapper findRefereeMapper;

	@Override
	public int saveFindRefereeMessage(FindRefereeMessage message) {
		return findRefereeMapper.insertSelective(message);
	}

	@Override
	public List<FindRefereeMessage> findMessageByCondition(String whereClause, String orderByClause,
			String limitClause) {
		return findRefereeMapper.selectByCondition(whereClause,orderByClause,limitClause);
	}

	@Override
	public boolean addReadCount(int messageId) {
		int count = findRefereeMapper.updateReadCount(messageId);
		if(count > 0)return true;
		return false;
	}

	@Override
	public boolean addApplyCount(int messageId) {
		int count = findRefereeMapper.updateReadCount(messageId);
		if(count > 0)return true;
		return false;
	}
}
