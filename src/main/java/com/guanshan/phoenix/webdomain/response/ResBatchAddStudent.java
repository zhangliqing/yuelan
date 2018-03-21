package com.guanshan.phoenix.webdomain.response;

import java.util.List;

public class ResBatchAddStudent {

    private int success;
    private int failure;
    private List<FailureReason> failureReasonList;

    public class FailureReason {
        private String studentNum;
        private String studentName;
        private int classId;
        private String reason;

        public String getStudentNum() {
            return studentNum;
        }

        public void setStudentNum(String studentNum) {
            this.studentNum = studentNum;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public int getClassId() {
            return classId;
        }

        public void setClassId(int classId) {
            this.classId = classId;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getFailure() {
        return failure;
    }

    public void setFailure(int failure) {
        this.failure = failure;
    }

    public List<FailureReason> getFailureReasonList() {
        return failureReasonList;
    }

    public void setFailureReasonList(List<FailureReason> failureReasonList) {
        this.failureReasonList = failureReasonList;
    }
}
