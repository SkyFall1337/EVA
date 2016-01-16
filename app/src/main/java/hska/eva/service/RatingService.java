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

}
