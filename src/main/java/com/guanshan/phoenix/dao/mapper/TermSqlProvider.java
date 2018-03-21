package com.guanshan.phoenix.dao.mapper;

import com.guanshan.phoenix.dao.entity.Term;
import org.apache.ibatis.jdbc.SQL;

public class TermSqlProvider {

    public String insertSelective(Term record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("term");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getYear() != null) {
            sql.VALUES("year", "#{year,jdbcType=VARCHAR}");
        }
        
        if (record.getSemester() != null) {
            sql.VALUES("semester", "#{semester,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Term record) {
        SQL sql = new SQL();
        sql.UPDATE("term");
        
        if (record.getYear() != null) {
            sql.SET("year = #{year,jdbcType=VARCHAR}");
        }
        
        if (record.getSemester() != null) {
            sql.SET("semester = #{semester,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}