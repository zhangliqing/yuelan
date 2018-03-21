package com.guanshan.phoenix.service;

import com.guanshan.phoenix.dao.entity.Student;
import com.guanshan.phoenix.dao.entity.StudentClass;
import com.guanshan.phoenix.error.ApplicationErrorException;
import com.guanshan.phoenix.webdomain.response.ResBatchAddStudent;
import com.guanshan.phoenix.webdomain.request.ReqUpdateStudent;
import com.guanshan.phoenix.webdomain.response.ResStudentClassList;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    List<StudentClass> getAllStudentClassByUserId(int studentID) throws ApplicationErrorException;

    ResStudentClassList getAllStudentClassInfoByUserId(int studentID) throws ApplicationErrorException;

    int updateStudentInfo(ReqUpdateStudent reqUpdateStudent) throws ApplicationErrorException;

    ResBatchAddStudent batchStudentCreation(int classId, MultipartFile file) throws ApplicationErrorException, IOException;

    void createStudent(Student student) throws ApplicationErrorException;

    void updateStudent(Student student) throws ApplicationErrorException;

    int getCount();
}
