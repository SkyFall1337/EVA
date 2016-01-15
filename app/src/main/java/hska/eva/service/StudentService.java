package hska.eva.service;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import hska.eva.dao.DatabaseSchema.dbStudent;
import hska.eva.dao.StudentRepository;
import hska.eva.domain.Student;

/**
 * Created by Steko on 11.01.2016.
 */
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(Context ctx) {
        studentRepository = new StudentRepository(ctx);
    }

    public List<Student> findAllStudentsForOverView() {
        List<Student> students = new ArrayList<>();

        Cursor cursor = studentRepository.findAllStudentsForOverview();
        cursor.moveToFirst();
        do {
            Long studentId = cursor.getLong(cursor.getColumnIndex(dbStudent._ID));
            String email = cursor.getString(cursor.getColumnIndex(dbStudent.COLUMN_NAME_EMAIL));
            String vorname = cursor.getString(cursor.getColumnIndex(dbStudent.COLUMN_NAME_VORNAME));
            String nachname = cursor.getString(cursor.getColumnIndex(dbStudent.COLUMN_NAME_NACHNAME));

            System.out.println(email);

            students.add(new Student(studentId, email, vorname, nachname, null));

        } while (cursor.moveToNext());

        return students;
    }

    public Student findStudent(long studentId){
        Cursor cursorStudent = studentRepository.findStudent(studentId);
        cursorStudent.moveToFirst();
        Long id = cursorStudent.getLong(cursorStudent.getColumnIndex(dbStudent._ID));
        if (id == null) {
            return null;
        }

        String studentVorname = cursorStudent.getString(cursorStudent.getColumnIndex(dbStudent.COLUMN_NAME_VORNAME));
        String studentEmail = cursorStudent.getString(cursorStudent.getColumnIndex(dbStudent.COLUMN_NAME_EMAIL));

        Student student = new Student();
        student.setId(id);
        student.setVorname(studentVorname);
        student.setEmail(studentEmail);

        return student;
    }
}