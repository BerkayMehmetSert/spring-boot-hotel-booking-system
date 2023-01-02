package com.bms.hotelbookingsystem.service;

import com.bms.hotelbookingsystem.dto.RatingDto;
import com.bms.hotelbookingsystem.dto.converter.RatingDtoConverter;
import com.bms.hotelbookingsystem.dto.request.CreateRatingRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateRatingRequest;
import com.bms.hotelbookingsystem.exception.RatingNotFoundException;
import com.bms.hotelbookingsystem.helper.DateHelper;
import com.bms.hotelbookingsystem.helper.message.BusinessLogMessage;
import com.bms.hotelbookingsystem.helper.message.BusinessMessage;
import com.bms.hotelbookingsystem.model.Rating;
import com.bms.hotelbookingsystem.repository.RatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RatingService {
    private final RatingRepository ratingRepository;
    private final RatingDtoConverter converter;

    public RatingService(RatingRepository ratingRepository,
                         RatingDtoConverter converter) {
        this.ratingRepository = ratingRepository;
        this.converter = converter;
    }

    public void createRating(CreateRatingRequest request) {
        Rating rating = new Rating();

        rating.setValue(request.getValue());
        rating.setDescription(request.getDescription());
        rating.setCreatedAt(DateHelper.getCurrentDate());
        rating.setUpdatedAt(DateHelper.getCurrentDate());

        ratingRepository.save(rating);
        log.info(BusinessLogMessage.Rating.RATING_CREATED);
    }

    public void updateRating(final String id, UpdateRatingRequest request) {
        Rating rating = findRatingByRatingId(id);

        rating.setValue(request.getValue());
        rating.setDescription(request.getDescription());
        rating.setUpdatedAt(DateHelper.getCurrentDate());

        ratingRepository.save(rating);
        log.info(BusinessLogMessage.Rating.RATING_UPDATED + id);
    }

    public void deleteRating(final String id) {
        Rating rating = findRatingByRatingId(id);

        ratingRepository.delete(rating);
        log.info(BusinessLogMessage.Rating.RATING_DELETED + id);
    }

    public RatingDto findRatingById(final String id) {
        Rating rating = findRatingByRatingId(id);

        log.info(BusinessLogMessage.Rating.RATING_FOUND + id);
        return converter.convert(rating);
    }

    public List<RatingDto> findAllRatings() {
        List<Rating> ratings = ratingRepository.findAll();

        if (ratings.isEmpty()) {
            log.info(BusinessLogMessage.Rating.RATING_LIST_EMPTY);
            throw new RatingNotFoundException(BusinessMessage.Rating.RATING_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Rating.RATING_LISTED);
        return converter.convert(ratings);
    }

    protected Rating findRatingByRatingId(final String id) {
        return ratingRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Rating.RATING_NOT_FOUND + id);
            return new RuntimeException(BusinessLogMessage.Rating.RATING_NOT_FOUND);
        });
    }
}
