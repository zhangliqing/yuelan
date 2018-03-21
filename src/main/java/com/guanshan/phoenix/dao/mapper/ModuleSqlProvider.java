package com.guanshan.phoenix.dao.mapper;

import com.guanshan.phoenix.dao.entity.Module;
import org.apache.ibatis.jdbc.SQL;

public class ModuleSqlProvider {

    public String insertSelective(Module record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("module");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCourseId() != null) {
            sql.VALUES("course_id", "#{courseId,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Module record) {
        SQL sql = new SQL();
        sql.UPDATE("module");
        
        if (record.getCourseId() != null) {
            sql.SET("course_id = #{courseId,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}