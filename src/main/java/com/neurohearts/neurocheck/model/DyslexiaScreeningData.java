package com.neurohearts.neurocheck.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dyslexia_screenings")
public class DyslexiaScreeningData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String screeningId;

    private String studentName;
    private int age;
    private String grade;
    private String evaluatorName;
    private LocalDate evaluationDate;

    // Questionnaire responses (0 = Never, 1 = Sometimes, 2 = Often)
    private int delayedSpeech;
    private int letterConfusion;
    private int difficultyLearningLetters;
    private int troubleWithRhymes;
    private int difficultySegmentingWords;
    private int slowReadingProgress;
    private int avoidsReadingAloud;
    private int guessesWords;
    private int spellingErrors;
    private int slowFluency;
    private int writingDifficulty;
    private int strugglesWithSecondLanguage;
    private int mixesLetterOrder;
    private int avoidsReadingWritingTasks;
    private int familyHistory;


    // Computed total and risk band
    private int totalScore;
    private String riskLevel;

    public void calculateTotalAndRisk() {
        this.totalScore = delayedSpeech + letterConfusion + difficultyLearningLetters +
                troubleWithRhymes + difficultySegmentingWords + slowReadingProgress +
                avoidsReadingAloud + guessesWords + spellingErrors + slowFluency +
                writingDifficulty + strugglesWithSecondLanguage + mixesLetterOrder +
                avoidsReadingWritingTasks + familyHistory;

        if (totalScore <= 9) riskLevel = "Low risk";
        else if (totalScore <= 19) riskLevel = "Moderate risk";
        else riskLevel = "Elevated risk";
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public int getDelayedSpeech() {
        return delayedSpeech;
    }

    public void setDelayedSpeech(int delayedSpeech) {
        this.delayedSpeech = delayedSpeech;
    }

    public int getLetterConfusion() {
        return letterConfusion;
    }

    public void setLetterConfusion(int letterConfusion) {
        this.letterConfusion = letterConfusion;
    }

    public int getDifficultyLearningLetters() {
        return difficultyLearningLetters;
    }

    public void setDifficultyLearningLetters(int difficultyLearningLetters) {
        this.difficultyLearningLetters = difficultyLearningLetters;
    }

    public int getTroubleWithRhymes() {
        return troubleWithRhymes;
    }

    public void setTroubleWithRhymes(int troubleWithRhymes) {
        this.troubleWithRhymes = troubleWithRhymes;
    }

    public int getDifficultySegmentingWords() {
        return difficultySegmentingWords;
    }

    public void setDifficultySegmentingWords(int difficultySegmentingWords) {
        this.difficultySegmentingWords = difficultySegmentingWords;
    }

    public int getSlowReadingProgress() {
        return slowReadingProgress;
    }

    public void setSlowReadingProgress(int slowReadingProgress) {
        this.slowReadingProgress = slowReadingProgress;
    }

    public int getAvoidsReadingAloud() {
        return avoidsReadingAloud;
    }

    public void setAvoidsReadingAloud(int avoidsReadingAloud) {
        this.avoidsReadingAloud = avoidsReadingAloud;
    }

    public int getGuessesWords() {
        return guessesWords;
    }

    public void setGuessesWords(int guessesWords) {
        this.guessesWords = guessesWords;
    }

    public int getSpellingErrors() {
        return spellingErrors;
    }

    public void setSpellingErrors(int spellingErrors) {
        this.spellingErrors = spellingErrors;
    }

    public int getSlowFluency() {
        return slowFluency;
    }

    public void setSlowFluency(int slowFluency) {
        this.slowFluency = slowFluency;
    }

    public int getWritingDifficulty() {
        return writingDifficulty;
    }

    public void setWritingDifficulty(int writingDifficulty) {
        this.writingDifficulty = writingDifficulty;
    }

    public int getStrugglesWithSecondLanguage() {
        return strugglesWithSecondLanguage;
    }

    public void setStrugglesWithSecondLanguage(int strugglesWithSecondLanguage) {
        this.strugglesWithSecondLanguage = strugglesWithSecondLanguage;
    }

    public int getMixesLetterOrder() {
        return mixesLetterOrder;
    }

    public void setMixesLetterOrder(int mixesLetterOrder) {
        this.mixesLetterOrder = mixesLetterOrder;
    }

    public int getAvoidsReadingWritingTasks() {
        return avoidsReadingWritingTasks;
    }

    public void setAvoidsReadingWritingTasks(int avoidsReadingWritingTasks) {
        this.avoidsReadingWritingTasks = avoidsReadingWritingTasks;
    }

    public int getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(int familyHistory) {
        this.familyHistory = familyHistory;
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
