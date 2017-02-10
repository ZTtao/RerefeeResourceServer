package zhentao.zhang.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhentao.zhang.pojo.Referee;
import zhentao.zhang.pojo.RefereeExample;

public interface RefereeMapper {
    int insertSelective(Referee record);
    int updateByPrimaryKeySelective(Referee record);
    int deleteByPrimaryKey(Integer refereeId);
    Referee selectByPrimaryKey(Integer refereeId);
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee
     *
     * @mbggenerated
     */
    int countByExample(RefereeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee
     *
     * @mbggenerated
     */
    int deleteByExample(RefereeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee
     *
     * @mbggenerated
     */
    

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee
     *
     * @mbggenerated
     */
    int insert(Referee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee
     *
     * @mbggenerated
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee
     *
     * @mbggenerated
     */
    List<Referee> selectByExample(RefereeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee
     *
     * @mbggenerated
     */
    

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Referee record, @Param("example") RefereeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Referee record, @Param("example") RefereeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee
     *
     * @mbggenerated
     */
    

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Referee record);
}