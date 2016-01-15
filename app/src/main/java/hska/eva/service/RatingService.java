package hska.eva.service;

import android.content.Context;
import android.database.Cursor;

import hska.eva.dao.RatingRepository;
import hska.eva.domain.Rating;
import hska.eva.dao.DatabaseSchema.dbRating;

/**
 * Created by Luke on 12.01.2016.
 */
public class RatingService {
    private RatingRepository ratingRepository;


    public RatingService(Context ctx) {
        ratingRepository = new RatingRepository(ctx);
    }

    public Rating findRatingForStudent(long studentID) {
        Cursor cursorRating = ratingRepository.findRatingForStudent(studentID);
        cursorRating.moveToFirst();
        Long id = cursorRating.getLong(cursorRating.getColumnIndex(dbRating.COLUMN_NAME_STUDENT_FK));
        if (id==null){
            return null;
        }

        int ratingMotivation = cursorRating.getInt(cursorRating.getColumnIndex(dbRating.COLUMN_NAME_MOTIVATION));
        int ratingTeamfaehigkeit = cursorRating.getInt(cursorRating.getColumnIndex(dbRating.COLUMN_NAME_TEAMFAEHIGKEIT));
        int ratingKommunikation = cursorRating.getInt(cursorRating.getColumnIndex(dbRating.COLUMN_NAME_KOMMUNIKATION));
        int ratingKnowhow = cursorRating.getInt(cursorRating.getColumnIndex(dbRating.COLUMN_NAME_KNOWHOW));
        int ratingStudentb_fk = cursorRating.getInt(cursorRating.getColumnIndex(dbRating.COLUMN_NAME_STUDENTB_FK));

        Rating rating = new Rating();
        rating.setId(id);
        rating.setMotivation(ratingMotivation);
        rating.setTeamfaehigkeit(ratingTeamfaehigkeit);
        rating.setKommunikation(ratingKommunikation);
        rating.setKnowhow(ratingKnowhow);
        rating.setStudent_fk(studentID);
        rating.setStudentb_fk(ratingStudentb_fk);

        return rating;

    }

}
