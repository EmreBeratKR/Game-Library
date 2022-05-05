package com.scpg.gamelibrary.dataAccess.abstracts;

import com.scpg.gamelibrary.entities.concretes.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReviewDao extends JpaRepository<Review, Integer>
{
    List<Review> getAllByRelatedGameId(int id);
}
