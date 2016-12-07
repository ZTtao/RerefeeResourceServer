package zhentao.zhang.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhentao.zhang.pojo.RefereeReply;
import zhentao.zhang.pojo.RefereeReplyExample;

public interface RefereeReplyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reply
     *
     * @mbggenerated
     */
    int countByExample(RefereeReplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reply
     *
     * @mbggenerated
     */
    int deleteByExample(RefereeReplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reply
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer refRepId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reply
     *
     * @mbggenerated
     */
    int insert(RefereeReply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reply
     *
     * @mbggenerated
     */
    int insertSelective(RefereeReply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reply
     *
     * @mbggenerated
     */
    List<RefereeReply> selectByExample(RefereeReplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reply
     *
     * @mbggenerated
     */
    RefereeReply selectByPrimaryKey(Integer refRepId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reply
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") RefereeReply record, @Param("example") RefereeReplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reply
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") RefereeReply record, @Param("example") RefereeReplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reply
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(RefereeReply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reply
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(RefereeReply record);
}