package hska.eva.service;

import android.content.Context;

import hska.eva.dao.RatingRepository;

/**
 * Created by Luke on 12.01.2016.
 */
public class RatingService {
    private RatingRepository ratingRepository;


    public RatingService(Context ctx) {
        ratingRepository = new RatingRepository(ctx);
    }


}
