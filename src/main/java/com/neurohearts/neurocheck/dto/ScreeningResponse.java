package com.neurohearts.neurocheck.dto;

import java.time.LocalDate;

public class ScreeningResponse {
    private Long id;
    private String studentName;
    private String evaluatorName;
    private LocalDate evaluationDate;
    private int totalScore;
    private String riskLevel;

    public ScreeningResponse(Long id, String studentName, String evaluatorName, LocalDate evaluationDate, int totalScore, String riskLevel) {
        this.id = id;
        this.studentName = studentName;
        this.evaluatorName = evaluatorName;
        this.evaluationDate = evaluationDate;
        this.totalScore = totalScore;
        this.riskLevel = riskLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEvaluatorName() {
        return evaluatorName;
    }

    public void setEvaluatorName(String evaluatorName) {
        this.evaluatorName = evaluatorName;
    }

    public LocalDate getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(LocalDate evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}
