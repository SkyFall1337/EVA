package hska.eva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import hska.eva.dao.RatingRepository;
import hska.eva.domain.Rating;
import hska.eva.domain.Student;
import hska.eva.service.StudentService;

public class RatingDetailActivity extends AppCompatActivity {

    private StudentService studentService = new StudentService(ManagerActivity.applicationContext);

    private Student bewerteterStudent;

    private RatingRepository ratingRepository;

    private static Button button_sbm;
    private static RatingBar rating_m;
    private static RatingBar rating_tf;
    private static RatingBar rating_kh;
    private static RatingBar rating_k;

    private Student loggedInStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_detail);

        loggedInStudent = ManagerActivity.loggedInStudent;

        ratingRepository = new RatingRepository(getApplicationContext());


        fillView();
        onButtonClickListener();
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

    public void fillView(){
        Intent intent = getIntent();
        String studentId = intent.getStringExtra(ManagerActivity.INTENT_STUDENT_ID);
        bewerteterStudent = studentService.findStudent(Long.valueOf(studentId));

        TextView ratingDetailEMail = (TextView) findViewById(R.id.ratingDetailEMail);
        ratingDetailEMail.setText(bewerteterStudent.getEmail());

        TextView ratingDetailVorname = (TextView) findViewById(R.id.ratingDetailVorname);
        ratingDetailVorname.setText(bewerteterStudent.getVorname() + " " + (bewerteterStudent.getNachname()));
    }

    public void onButtonClickListener() {
        rating_m = (RatingBar) findViewById(R.id.rating_motivation);
        rating_tf = (RatingBar) findViewById(R.id.rating_teamfaehigkeit);
        rating_kh = (RatingBar) findViewById(R.id.rating_knowhow);
        rating_k = (RatingBar) findViewById(R.id.rating_kommunikation);
        button_sbm = (Button) findViewById(R.id.button);

        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Rating rating = new Rating(null, Math.round(rating_m.getRating()),
                                Math.round(rating_tf.getRating()), Math.round(rating_kh.getRating()),
                                Math.round(rating_k.getRating()), loggedInStudent.getId(),
                                bewerteterStudent.getId());
                        ratingRepository.addRating(rating);
                        finish();
                    }
                }
        );
    }
}
