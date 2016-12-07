package zhentao.zhang.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhentao.zhang.pojo.GameReservation;
import zhentao.zhang.pojo.GameReservationExample;

public interface GameReservationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_reservation
     *
     * @mbggenerated
     */
    int countByExample(GameReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_reservation
     *
     * @mbggenerated
     */
    int deleteByExample(GameReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_reservation
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer gameResId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_reservation
     *
     * @mbggenerated
     */
    int insert(GameReservation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_reservation
     *
     * @mbggenerated
     */
    int insertSelective(GameReservation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_reservation
     *
     * @mbggenerated
     */
    List<GameReservation> selectByExample(GameReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_reservation
     *
     * @mbggenerated
     */
    GameReservation selectByPrimaryKey(Integer gameResId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_reservation
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") GameReservation record, @Param("example") GameReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_reservation
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") GameReservation record, @Param("example") GameReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_reservation
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(GameReservation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_reservation
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(GameReservation record);
}