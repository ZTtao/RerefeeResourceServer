package zhentao.zhang.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhentao.zhang.pojo.Collection;
import zhentao.zhang.pojo.CollectionExample;

public interface CollectionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbggenerated
     */
    int countByExample(CollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbggenerated
     */
    int deleteByExample(CollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer collId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbggenerated
     */
    int insert(Collection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbggenerated
     */
    int insertSelective(Collection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbggenerated
     */
    List<Collection> selectByExample(CollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbggenerated
     */
    Collection selectByPrimaryKey(Integer collId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Collection record, @Param("example") CollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Collection record, @Param("example") CollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Collection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Collection record);
}