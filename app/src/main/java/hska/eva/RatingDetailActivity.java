package hska.eva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import hska.eva.domain.Rating;
import hska.eva.domain.Student;
import hska.eva.service.RatingService;
import hska.eva.service.StudentService;

public class RatingDetailActivity extends AppCompatActivity {

    public static final String INTENT_RATING = "intentSurveyfregzhjzjzzj";

    private StudentService studentService = new StudentService(ManagerActivity.applicationContext);

    private RatingService ratingService = new RatingService(ManagerActivity.applicationContext);

    private Rating rating;

    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_detail);

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
        ratingDetailVorname.setText(student.getVorname());

        /*TextView bonusTextView = (TextView) findViewById(R.id.surveyDetailBonusTextView);
        if(survey.getBonus() != null){
            bonusTextView.setText(bonusTextView.getText() + ": " + survey.getBonus().getDescription());
        }

        if(survey.getQuestions().size() == 0){
            Toast toast = Toast.makeText(getApplicationContext(), "Oups, no Questions available!", Toast.LENGTH_SHORT);
            toast.show();
            finish();
        }

        TextView questionsCountTextView = (TextView) findViewById(R.id.surveyDetailQuestionsCountTextView);
        questionsCountTextView.setText(questionsCountTextView.getText() + ": " + survey.getQuestions().size());
        */
    }
}
