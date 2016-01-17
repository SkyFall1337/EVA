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

    private RatingService ratingService = new RatingService(ManagerActivity.applicationContext);

    public static Student loggedInStudent = ManagerActivity.loggedInStudent;

    List<Float>  RatingsMw = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView2 = inflater.inflate(R.layout.fragment_profil_layout, container, false);

        RatingsMw = (ratingService.findRatingsForStudent(loggedInStudent.getId()));

        TextView motivationTextView = (TextView) contentView2.findViewById(R.id.textViewMwMo);
        float roundRating = RatingsMw.get(0) * 100;
        roundRating = Math.round(roundRating);
        roundRating = roundRating / 100;
        motivationTextView.setText("" + roundRating);
        //ProgressBar Motivation
        ProgressBar motivationBar = (ProgressBar) contentView2.findViewById(R.id.progressBarMotivation);
        motivationBar.setProgress(Math.round(RatingsMw.get(0) * 100));

        TextView teamfaehigkeitTextView = (TextView) contentView2.findViewById(R.id.textViewMwTe);
        float roundTeamf = RatingsMw.get(1) * 100;
        roundTeamf = Math.round(roundTeamf);
        roundTeamf = roundTeamf / 100;
        teamfaehigkeitTextView.setText("" + roundTeamf);
        //ProgressBar Teamfaehigkeit
        ProgressBar teamfaehigkeitBar = (ProgressBar) contentView2.findViewById(R.id.progressBarTeamfaehigkeit);
        teamfaehigkeitBar.setProgress(Math.round(RatingsMw.get(1) * 100));

        TextView kommunikationTextView = (TextView) contentView2.findViewById(R.id.textViewMwKo);
        float roundKommunikation = RatingsMw.get(2) * 100;
        roundKommunikation = Math.round(roundKommunikation);
        roundKommunikation = roundKommunikation / 100;
        kommunikationTextView.setText("" + roundKommunikation);
        //ProgressBarKommunikation
        ProgressBar kommunikationBar = (ProgressBar) contentView2.findViewById(R.id.progressBarKommunikation);
        kommunikationBar.setProgress(Math.round(RatingsMw.get(2)*100));

        TextView knowHowTextView = (TextView) contentView2.findViewById(R.id.textViewMwKn);
        float roundKnowHow = RatingsMw.get(3) * 100;
        roundKnowHow = Math.round(roundKnowHow);
        roundKnowHow = roundKnowHow / 100;
        knowHowTextView.setText("" + roundKnowHow);
        //ProgressBar KnowHow
        ProgressBar knowHowBar = (ProgressBar) contentView2.findViewById(R.id.progressBarKnowHow);
        knowHowBar.setProgress(Math.round(RatingsMw.get(3) * 100));

        //TextView Mittelwert
        TextView gesamtTextView = (TextView) contentView2.findViewById(R.id.textViewMwInt);
        gesamtTextView.setText("" + Math.round(RatingsMw.get(4)));

        //loggedInStudent Anzeige
        TextView loggedInTextView = (TextView) contentView2.findViewById(R.id.loggedInStudent);
        loggedInTextView.setText(loggedInStudent.getEmail());

        return contentView2;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
