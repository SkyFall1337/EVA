package hska.eva.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.List;

import hska.eva.ManagerActivity;
import hska.eva.R;
import hska.eva.domain.Student;
import hska.eva.service.StudentService;

/**
 * Created by Luke on 10.01.2016.
 */
public class StudentsFragment extends Fragment {

    View contentView;

    private TableLayout studentsList;

    private StudentService studentService = new StudentService(ManagerActivity.applicationContext);


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        contentView = inflater.inflate(R.layout.fragment_students_layout, container, false);

        studentsList = (TableLayout) contentView.findViewById(R.id.studentsScrollView);
        insertStudentsInScrollView(studentService.getAllStudents());

        return contentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void insertStudentsInScrollView(List<Student> students){
        for(Student student : students){
            insertStudentsInScrollView(students);
        }
    }

    private void insertStudentInScrollView(Student student){
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View newStudentRow = layoutInflater.inflate(R.layout.student_list_view, null);

        TextView studentHeadLineTextView = (TextView) newStudentRow.findViewById(R.id.studentListViewFirstLine);
        studentHeadLineTextView.setText(student.getEmail());

        TextView studentSecondHeadLineTextView = (TextView) newStudentRow.findViewById(R.id.studentListViewSecondLine);
        studentSecondHeadLineTextView.setText(student.getVorname());

        TextView studentIdTextView = (TextView) newStudentRow.findViewById(R.id.studentListViewStudentIdTextView);
        studentIdTextView.setText(student.getId().toString());

        studentsList.addView(newStudentRow);
    }
}
