package hska.eva;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import hska.eva.domain.Student;
import hska.eva.fragments.ProfilFragment;
import hska.eva.fragments.StudentsFragment;

public class ManagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    public static Context applicationContext;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    public static final String INTENT_STUDENT_ID = "studentID";
    public static Student loggedInStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applicationContext = getApplicationContext();

        setContentView(R.layout.activity_manager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager);

    //Login ID Student
    Intent intent = getIntent();
    loggedInStudent = (Student) intent.getSerializableExtra(LoginActivity.INTENT_STUDENT);
    }

    public void openRating(View clickedView){
        Intent ratingIntent = new Intent(this, RatingDetailActivity.class);

        TextView ratingId = (TextView) clickedView.findViewById(R.id.studentListViewStudentIdTextView);
        ratingIntent.putExtra(INTENT_STUDENT_ID, ratingId.getText());

        startActivity(ratingIntent);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        String[] tabtitlearray = {"Meine Gruppe", "Meine Bewertungen"};

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return new StudentsFragment();
                case 1:
                    return new ProfilFragment();
            }
            return new StudentsFragment();
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabtitlearray[position];
        }
    }




}
