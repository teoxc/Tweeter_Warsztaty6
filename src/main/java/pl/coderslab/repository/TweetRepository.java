package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Tweet;

import javax.persistence.Id;

public interface TweetRepository extends JpaRepository<Tweet, Id> {
}
