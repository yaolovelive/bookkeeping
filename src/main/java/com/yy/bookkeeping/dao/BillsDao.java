package com.yy.bookkeeping.dao;

import com.yy.bookkeeping.entity.BillType;
import com.yy.bookkeeping.entity.Bills;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillsDao {

    @SelectProvider(type = BillDaoProvider.class,method = "getBillsCount")
    @ResultType(Integer.class)
    Integer getBillsCount(@Param("type") Integer type,@Param("startDate") String startDate,@Param("endDate") String endDate);


    @SelectProvider(type = BillDaoProvider.class,method = "getBills")
    @Results(value = {
            @Result(property = "id",id = true, column = "id",javaType = Integer.class),
            @Result(property = "billType",column = "type_id",javaType = BillType.class,
            one = @One(select = "com.yy.bookkeeping.dao.BillTypeDao.getTypeById"))
    })
    List<Bills> getBills(@Param("type") Integer type,@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);

    class BillDaoProvider{

        public String getBillsCount(@Param("type") Integer type,@Param("startDate") String startDate,@Param("endDate") String endDate){
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT COUNT(1) FROM bills WHERE 1=1 ");
            if(type != null){
                sb.append("AND type_id = #{type} ");
            }
            if(startDate != null && !"".equals(startDate)){
                sb.append("AND bill_time >= #{startDate} ");
            }
            if(endDate != null && !"".equals(endDate)){
                sb.append("AND bill_time =< #{endDate} ");
            }
            sb.append("ORDER BY bill_time DESC ");
            return sb.toString();
        }

        public String getBills(@Param("type") Integer type,@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize){
            StringBuilder sb = new StringBuilder();
//            sb.append("SELECT * FROM ( ");
            sb.append("SELECT * FROM bills b ");
//            sb.append("INNER JOIN bill_type t ");
//            sb.append("ON b.type_id = t.id ");
            sb.append(" WHERE 1=1 ");
            if(type != null){
                sb.append("AND b.type_id = #{type} ");
            }
            if(startDate != null && !"".equals(startDate)){
                sb.append("AND b.bill_time >= #{startDate} ");
            }
            if(endDate != null && !"".equals(endDate)){
                sb.append("AND b.bill_time =< #{endDate} ");
            }
            sb.append("ORDER BY bill_time DESC ");
//            sb.append(") LIMIT #{pageNo},#{pageSize}");
            sb.append(" LIMIT #{pageNo},#{pageSize}");
            return sb.toString();
        }

    }

    @Insert("INSERT INTO `bills`(`title`,`bill_time`,`type_id`,`price`,`explain`) " +
            "VALUES (#{title},#{bill_time},#{billType.id},#{price},#{explain})")
    Integer addBill(Bills bills);

}
