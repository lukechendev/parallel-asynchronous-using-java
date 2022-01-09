package com.learnjava.service;

import com.learnjava.domain.Review;

import static com.learnjava.util.CommonUtil.delay;
import static com.learnjava.util.LoggerUtil.log;

public class ReviewService {

    public Review retrieveReviews(String productId) {
        log("Start review" + productId);
        delay(1000);
        log("End review" + productId);
        return new Review(200, 4.5);
    }
}
