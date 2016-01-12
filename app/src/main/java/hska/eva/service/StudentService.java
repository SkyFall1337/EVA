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

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        Cursor cursor = studentRepository.getAllStudents();
        cursor.moveToFirst();
        do {
            Long studentId = cursor.getLong(cursor.getColumnIndex(dbStudent._ID));
            String email = cursor.getString(cursor.getColumnIndex(dbStudent.COLUMN_NAME_EMAIL));
            String vorname = cursor.getString(cursor.getColumnIndex(dbStudent.COLUMN_NAME_VORNAME));
            String nachname = cursor.getString(cursor.getColumnIndex(dbStudent.COLUMN_NAME_NACHNAME));

            System.out.println(email);

            students.add(new Student(studentId, email, vorname, nachname));

        } while (cursor.moveToNext());

        return students;
    }
}
