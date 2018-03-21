package com.guanshan.phoenix.service;

import com.guanshan.phoenix.dao.entity.Clazz;
import com.guanshan.phoenix.error.ApplicationErrorException;
import com.guanshan.phoenix.webdomain.request.*;
import com.guanshan.phoenix.webdomain.response.ResClassDetail;
import com.guanshan.phoenix.webdomain.response.ResClassInfos;
import com.guanshan.phoenix.webdomain.response.ResClassStudents;

public interface ClassService {
    Clazz getClassById(int classID) throws ApplicationErrorException;

    int deleteClassStudent(ReqDeleteClassStudent reqDeleteClassStudent) throws ApplicationErrorException;

    int addClassStudent(ReqAddClassStudent reqAddClassStudent) throws ApplicationErrorException;

    ResClassStudents getAllClassStudentInfo(int classId) throws ApplicationErrorException;

    int deleteClass(ReqDeleteClass reqDeleteClass) throws ApplicationErrorException;

    int updateClassInfo(ReqUpdateClass reqUpdateClass) throws ApplicationErrorException;

    int createClass(ReqAddClass reqAddClass) throws ApplicationErrorException;

    ResClassInfos getAllClassInfo();
}
