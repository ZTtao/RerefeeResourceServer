package zhentao.zhang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import zhentao.zhang.pojo.FindRefereeMessage;

public interface FindRefereeMapper {
	public int insertSelective(FindRefereeMessage message);
	public List<FindRefereeMessage> selectByCondition(@Param("whereClause")String whereClause, @Param("orderByClause")String orderByClause,@Param("limitClause")String limitClause);
	public int updateReadCount(int messageId);
}
