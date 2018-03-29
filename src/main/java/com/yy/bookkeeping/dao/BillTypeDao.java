package com.yy.bookkeeping.dao;

import com.yy.bookkeeping.entity.BillType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("billTypeDao")
public interface BillTypeDao {

    @Select("SELECT * FROM bill_type")
    @ResultType(BillType.class)
    List<BillType> getAllBillTypes();

    @Select("SELECT * FROM bill_type WHERE id = #{id}")
    @ResultType(BillType.class)
    BillType getTypeById(@Param("id") Integer id);
}
