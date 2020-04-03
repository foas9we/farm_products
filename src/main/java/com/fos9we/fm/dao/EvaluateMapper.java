package com.fos9we.fm.dao;

import com.fos9we.fm.bean.Evaluate;
import com.fos9we.fm.bean.EvaluateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvaluateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fm_evaluate
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    long countByExample(EvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fm_evaluate
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    int deleteByExample(EvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fm_evaluate
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fm_evaluate
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    int insert(Evaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fm_evaluate
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    int insertSelective(Evaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fm_evaluate
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    List<Evaluate> selectByExampleWithBLOBs(EvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fm_evaluate
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    List<Evaluate> selectByExample(EvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fm_evaluate
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    Evaluate selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fm_evaluate
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    int updateByExampleSelective(@Param("record") Evaluate record, @Param("example") EvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fm_evaluate
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") Evaluate record, @Param("example") EvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fm_evaluate
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    int updateByExample(@Param("record") Evaluate record, @Param("example") EvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fm_evaluate
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    int updateByPrimaryKeySelective(Evaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fm_evaluate
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(Evaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fm_evaluate
     *
     * @mbg.generated Fri Apr 03 21:03:31 CST 2020
     */
    int updateByPrimaryKey(Evaluate record);
}