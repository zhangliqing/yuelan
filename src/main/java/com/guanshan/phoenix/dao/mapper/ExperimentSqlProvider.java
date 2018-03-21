package com.guanshan.phoenix.dao.mapper;

import com.guanshan.phoenix.dao.entity.Experiment;
import org.apache.ibatis.jdbc.SQL;

public class ExperimentSqlProvider {

    public String insertSelective(Experiment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("experiment");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getModuleId() != null) {
            sql.VALUES("module_id", "#{moduleId,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getCloudwareType() != null) {
            sql.VALUES("cloudware_type", "#{cloudwareType,jdbcType=INTEGER}");
        }
        
        if (record.getPublishDate() != null) {
            sql.VALUES("publish_date", "#{publishDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeadlineDate() != null) {
            sql.VALUES("deadline_date", "#{deadlineDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExperimentContent() != null) {
            sql.VALUES("experiment_content", "#{experimentContent,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Experiment record) {
        SQL sql = new SQL();
        sql.UPDATE("experiment");
        
        if (record.getModuleId() != null) {
            sql.SET("module_id = #{moduleId,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getCloudwareType() != null) {
            sql.SET("cloudware_type = #{cloudwareType,jdbcType=INTEGER}");
        }
        
        if (record.getPublishDate() != null) {
            sql.SET("publish_date = #{publishDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeadlineDate() != null) {
            sql.SET("deadline_date = #{deadlineDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExperimentContent() != null) {
            sql.SET("experiment_content = #{experimentContent,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}