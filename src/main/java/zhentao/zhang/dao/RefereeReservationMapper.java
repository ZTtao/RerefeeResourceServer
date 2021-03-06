package zhentao.zhang.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhentao.zhang.pojo.RefereeReservation;
import zhentao.zhang.pojo.RefereeReservationExample;

public interface RefereeReservationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reservation
     *
     * @mbggenerated
     */
    int countByExample(RefereeReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reservation
     *
     * @mbggenerated
     */
    int deleteByExample(RefereeReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reservation
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer refResId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reservation
     *
     * @mbggenerated
     */
    int insert(RefereeReservation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reservation
     *
     * @mbggenerated
     */
    int insertSelective(RefereeReservation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reservation
     *
     * @mbggenerated
     */
    List<RefereeReservation> selectByExample(RefereeReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reservation
     *
     * @mbggenerated
     */
    RefereeReservation selectByPrimaryKey(Integer refResId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reservation
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") RefereeReservation record, @Param("example") RefereeReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reservation
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") RefereeReservation record, @Param("example") RefereeReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reservation
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(RefereeReservation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referee_reservation
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(RefereeReservation record);
}