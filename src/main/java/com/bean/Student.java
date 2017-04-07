package com.bean;

import javax.validation.constraints.NotNull;

/**
 * Created by olxja_000 on 2017/2/17.
 */
public class Student {
    @NotNull
    private String studentName;
    private String studentNo;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }
}
