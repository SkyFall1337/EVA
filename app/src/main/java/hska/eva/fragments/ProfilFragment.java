package hska.eva.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hska.eva.ManagerActivity;
import hska.eva.R;
import hska.eva.domain.Student;
import hska.eva.service.RatingService;


/**
 * Created by Luke on 10.01.2016.
 */
public class ProfilFragment extends Fragment {

    View contentView2;
    ProgressBar motivationBar;

    private RatingService ratingService = new RatingService(ManagerActivity.applicationContext);

    public static Student loggedInStudent = ManagerActivity.loggedInStudent;

    List<Float>  RatingsMw = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView2 = inflater.inflate(R.layout.fragment_profil_layout, container, true);

        RatingsMw = (ratingService.findRatingsForStudent(loggedInStudent.getId()));

        ProgressBar motivationBar = (ProgressBar) contentView2.findViewById(R.id.progressBarMotivation);
        motivationBar.setProgress(Math.round(RatingsMw.get(0)));

        ProgressBar teamfaehigkeitBar = (ProgressBar) contentView2.findViewById(R.id.progressBarTeamfaehigkeit);
        teamfaehigkeitBar.setProgress(Math.round(RatingsMw.get(1)));

        ProgressBar kommunikationBar = (ProgressBar) contentView2.findViewById(R.id.progressBarKommunikation);
        kommunikationBar.setProgress(Math.round(RatingsMw.get(2)));

        ProgressBar knowHowBar = (ProgressBar) contentView2.findViewById(R.id.progressBarKnowHow);
        knowHowBar.setProgress(Math.round(RatingsMw.get(3)));

        TextView gesamtTextView = (TextView) contentView2.findViewById(R.id.textViewMw);
        knowHowBar.setProgress(Math.round(RatingsMw.get(4)));

        return contentView2;
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
