package zhentao.zhang.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhentao.zhang.pojo.OfflineMessage;
import zhentao.zhang.pojo.OfflineMessageExample;

public interface OfflineMessageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table offline_message
     *
     * @mbggenerated
     */
    int countByExample(OfflineMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table offline_message
     *
     * @mbggenerated
     */
    int deleteByExample(OfflineMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table offline_message
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer msgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table offline_message
     *
     * @mbggenerated
     */
    int insert(OfflineMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table offline_message
     *
     * @mbggenerated
     */
    int insertSelective(OfflineMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table offline_message
     *
     * @mbggenerated
     */
    List<OfflineMessage> selectByExample(OfflineMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table offline_message
     *
     * @mbggenerated
     */
    OfflineMessage selectByPrimaryKey(Integer msgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table offline_message
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") OfflineMessage record, @Param("example") OfflineMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table offline_message
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") OfflineMessage record, @Param("example") OfflineMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table offline_message
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OfflineMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table offline_message
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OfflineMessage record);
}