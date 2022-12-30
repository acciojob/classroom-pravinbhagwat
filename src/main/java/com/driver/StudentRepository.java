package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    private Map<String, Student> studentMap;
    private Map<String, Teacher> teacherMap;
    private Map<String, List<String>> teacherStudentMap;

    public StudentRepository() {
        this.studentMap = new HashMap<>();
        this.teacherMap = new HashMap<>();
        this.teacherStudentMap = new HashMap<>();
    }

    public void addStudentInStudentMap(Student student) {
        String studentName = student.getName();
        studentMap.put(studentName, student);
    }

    public void addTeacherInTeacherMap(Teacher teacher) {
        String teacherName = teacher.getName();
        teacherMap.put(teacherName, teacher);
    }

    public Student getStudentByName(String studentName) {
        return studentMap.getOrDefault(studentName, null);
    }

    public Teacher getTeacherByName(String teacherName) {
        return teacherMap.getOrDefault(teacherName, null);
    }

    public List<String> getAllStudentList() {
        List<String> studentList = new ArrayList<>(studentMap.keySet());
        return studentList;
    }

    public Boolean addStudentTeacherPair(String studentName, String teacherName) {
        if(studentMap.containsKey(studentName) && teacherMap.containsKey(teacherName)){
            List<String> studentsList;
            if(teacherStudentMap.containsKey(teacherName)) {
                studentsList = teacherStudentMap.get(teacherName);
            }
            else {
                studentsList = new ArrayList<>();
            }
            studentsList.add(studentName);
            teacherStudentMap.put(teacherName, studentsList);
            return true;
        }
        return false;
    }

    public List<String> getStudentsByTeacherName(String teacherName) {
        return teacherStudentMap.getOrDefault(teacherName, null);
    }

    public Boolean deleteTeacherByName(String teacherName) {
        if(teacherMap.containsKey(teacherName)) {
            List<String> studentList = teacherStudentMap.get(teacherName);
            for(String s : studentList) {
                studentMap.remove(s);
            }
            teacherMap.remove(teacherName);
            teacherStudentMap.remove(teacherName);
            return true;
        }
        return false;
    }

    public void deleteAllTeachers() {

        for (String teacherName : teacherStudentMap.keySet()) {
            for (String students : teacherStudentMap.get(teacherName)) {
                studentMap.remove(students);
            }
        }
        teacherMap.clear();
        teacherStudentMap.clear();
    }
}
