package hska.eva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import hska.eva.domain.Rating;
import hska.eva.domain.Student;
import hska.eva.service.RatingService;
import hska.eva.service.StudentService;

public class RatingDetailActivity extends AppCompatActivity {

    public static final String INTENT_RATING = "intentSurveyfregzhjzjzzj";

    private StudentService studentService = new StudentService(ManagerActivity.applicationContext);

    private RatingService ratingService = new RatingService(ManagerActivity.applicationContext);

    private Rating rating;

    private List<Rating> ratings;

    private int currentRatingIndex = 0;

    private Student student;

    private Student loggedInStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_detail);

        loggedInStudent = ManagerActivity.loggedInStudent;

        fillView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void fillView(){
        Intent intent = getIntent();
        String studentId = intent.getStringExtra(ManagerActivity.INTENT_STUDENT_ID);
        student = studentService.findStudent(Long.valueOf(studentId));

        TextView ratingDetailEMail = (TextView) findViewById(R.id.ratingDetailEMail);
        ratingDetailEMail.setText(student.getEmail());

        TextView ratingDetailVorname = (TextView) findViewById(R.id.ratingDetailVorname);
        ratingDetailVorname.setText(student.getVorname() + " " + (student.getNachname()));
    }

    public void onRatingClick(View clickedRatingBar){
        Rating currentRating = ratings.get(currentRatingIndex);
        Long currentRatingId = currentRating.getId();
        int ratingBarId = clickedRatingBar.getId();

        ratings.add(new Rating(currentRatingId, 0 , 0, 0, 0, loggedInStudent.getId(), currentRatingId));
    }
}
