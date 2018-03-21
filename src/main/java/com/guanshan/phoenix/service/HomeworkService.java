package com.guanshan.phoenix.service;

import com.guanshan.phoenix.error.ApplicationErrorException;
import com.guanshan.phoenix.webdomain.request.ReqCreateHomework;
import com.guanshan.phoenix.webdomain.request.ReqDeleteHomework;
import com.guanshan.phoenix.webdomain.request.ReqUpdateHomework;
import com.guanshan.phoenix.webdomain.response.*;

public interface HomeworkService {
    ResHomeworkDetail getHomeworkDetail(int homeworkID) throws ApplicationErrorException;

    ResHomeworkSubmissionList getAllHomeworkSubmissionByModuleId(int moduleId, int classId) throws ApplicationErrorException;

    ResStudentHomeworkDetail getStudentHomeworkDetailById(int studentHomeworkId) throws ApplicationErrorException;

    ResStudentHomeworkDetail getStudentHomeworkDetailByHomeworkIdAndStudentId(int homeworkId, int studentId) throws ApplicationErrorException;

    int deleteHomework(ReqDeleteHomework reqDeleteHomework) throws ApplicationErrorException;

    int updateHomework(ReqUpdateHomework reqUpdateHomework) throws ApplicationErrorException;

    int createHomework(ReqCreateHomework reqCreateHomework) throws ApplicationErrorException;

    ResClassHomework getClassHomework(int classId) throws ApplicationErrorException;

    ResStudentHomeworkList getStudentHomeworkListById(int studentId) throws ApplicationErrorException;

    ResTeacherHomeworkList getHomeworkListByTeacherId(int teacherId) throws ApplicationErrorException;
}
