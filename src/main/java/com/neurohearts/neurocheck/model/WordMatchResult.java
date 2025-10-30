package com.neurohearts.neurocheck.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "word_match")
public class WordMatchResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String screeningId;
    private int score;
    private int total;
    private LocalDateTime completedAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(String screeningId) {
        this.screeningId = screeningId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
