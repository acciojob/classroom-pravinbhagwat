package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudentInDB(Student student) {
        studentRepository.addStudentInStudentMap(student);
    }

    public void addTeacherInDB(Teacher teacher) {
        studentRepository.addTeacherInTeacherMap(teacher);
    }
    public Student getStudentByName(String studentName) {
        return studentRepository.getStudentByName(studentName);
    }

    public Teacher getTeacherByName(String teacherName) {
        return studentRepository.getTeacherByName(teacherName);
    }
    public List<String> getAllStudentList() {
        return studentRepository.getAllStudentList();
    }

    public Boolean addStudentsTeacherPair(String studentName, String teacherName) {
        return studentRepository.addStudentTeacherPair(studentName, teacherName);
    }

    public List<String> getStudentsByTeacherName(String teacherName) {
        return studentRepository.getStudentsByTeacherName(teacherName);
    }
    public Boolean deleteTeacherByName(String teacherName) {
        return studentRepository.deleteTeacherByName(teacherName);
    }
    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
    }
}
