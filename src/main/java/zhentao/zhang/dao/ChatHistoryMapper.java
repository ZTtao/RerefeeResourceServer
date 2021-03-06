package zhentao.zhang.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhentao.zhang.pojo.ChatHistory;
import zhentao.zhang.pojo.ChatHistoryExample;

public interface ChatHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cux_users
     *
     * @mbggenerated
     */
    int countByExample(ChatHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cux_users
     *
     * @mbggenerated
     */
    int deleteByExample(ChatHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cux_users
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cux_users
     *
     * @mbggenerated
     */
    int insert(ChatHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cux_users
     *
     * @mbggenerated
     */
    int insertSelective(ChatHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cux_users
     *
     * @mbggenerated
     */
    List<ChatHistory> selectByExample(ChatHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cux_users
     *
     * @mbggenerated
     */
    ChatHistory selectByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cux_users
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ChatHistory record, @Param("example") ChatHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cux_users
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ChatHistory record, @Param("example") ChatHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cux_users
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ChatHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cux_users
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ChatHistory record);
}