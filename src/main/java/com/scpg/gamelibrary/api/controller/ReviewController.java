package com.scpg.gamelibrary.api.controller;

import com.scpg.gamelibrary.business.abstracts.IGameService;
import com.scpg.gamelibrary.business.abstracts.IReviewService;
import com.scpg.gamelibrary.entities.concretes.Review;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/reviews")
@RequiredArgsConstructor
public class ReviewController
{
    private final IReviewService reviewService;
    private final IGameService gameService;


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Review review)
    {
        var resultData = this.reviewService.add(review);

        if (resultData.isSuccess())
        {
            return new ResponseEntity<>(resultData, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultData, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> remove(@RequestParam int reviewId)
    {
        var reviewResultData = this.reviewService.getById(reviewId);

        if (!reviewResultData.isSuccess())
        {
            return new ResponseEntity<>(reviewResultData, HttpStatus.BAD_REQUEST);
        }

        var resultData = this.reviewService.remove(reviewResultData.getData());

        if (resultData.isSuccess())
        {
            return new ResponseEntity<>(resultData, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultData, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getallbygameid")
    public ResponseEntity<?> getAllByGameId(@RequestParam int gameId)
    {
        var gameResultData = this.gameService.getById(gameId);

        if (!gameResultData.isSuccess())
        {
            return new ResponseEntity<>(gameResultData, HttpStatus.BAD_REQUEST);
        }

        var resultData = this.reviewService.getAllGameReviews(gameResultData.getData());

        if (resultData.isSuccess())
        {
            return new ResponseEntity<>(resultData, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultData, HttpStatus.BAD_REQUEST);
    }
}
