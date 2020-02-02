package pl.coderslab.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 140)
    @Size(min = 1, max = 140)
    @NotNull
    private String tweetContent;
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;
    @CreationTimestamp
    private Timestamp created;

    public Tweet() {
    }

    public Tweet(@Size(min = 1, max = 140) @NotNull String tweetContent, User user) {
        this.tweetContent = tweetContent;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public String getTweetContent() {
        return tweetContent;
    }

    public void setTweetContent(String tweetContent) {
        this.tweetContent = tweetContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
