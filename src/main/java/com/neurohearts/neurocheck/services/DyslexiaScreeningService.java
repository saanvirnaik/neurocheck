package com.neurohearts.neurocheck.services;

import com.neurohearts.neurocheck.model.ConsentEntity;
import com.neurohearts.neurocheck.model.DyslexiaScreeningData;
import com.neurohearts.neurocheck.model.PatternRecognitionResult;
import com.neurohearts.neurocheck.model.WordMatchResult;
import com.neurohearts.neurocheck.repository.ConsentRepository;
import com.neurohearts.neurocheck.repository.DyslexiaScreeningRepository;
import com.neurohearts.neurocheck.repository.PatternRecognitionRepository;
import com.neurohearts.neurocheck.repository.WordMatchRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class DyslexiaScreeningService {

    @Autowired
    private DyslexiaScreeningRepository screeningRepository;

    @Autowired
    private ConsentRepository consentRepository;

    @Autowired
    private PatternRecognitionRepository patternRecognitionRepository;

    @Autowired
    private WordMatchRepository wordMatchRepository;


    public String saveConsent(ConsentEntity data) {
        String screeningId = UUID.randomUUID().toString();
        data.setScreeningId(screeningId);
        consentRepository.save(data);
        return screeningId;
    }

    @Transactional
    public void saveScreening(DyslexiaScreeningData data) {
        if (data.getScreeningId() == null || data.getScreeningId().isEmpty()) {
            throw new IllegalArgumentException("Missing screeningId");
        }
        data.calculateTotalAndRisk();
        screeningRepository.save(data);
    }

    public void saveWordMatch(WordMatchResult data) {
        if (data.getScreeningId() == null || data.getScreeningId().isEmpty()) {
            throw new IllegalArgumentException("Missing screeningId");
        }
        wordMatchRepository.save(data);
    }

    public void savePatternRecognition(PatternRecognitionResult result) {
        if (result.getScreeningId() == null || result.getScreeningId().isEmpty()) {
            throw new IllegalArgumentException("Missing screeningId");
        }
        patternRecognitionRepository.save(result);
    }

    /**
     * Retrieve all results for a given screeningId
     */
    public Map<String, Object> getResultsByScreeningId(String screeningId) {

        Map<String, Object> resultMap = new LinkedHashMap<>(); // keep key order predictable

        // ---------------- Checklist ----------------
        screeningRepository.findByScreeningId(screeningId).ifPresentOrElse(checklist -> {
            Map<String, Object> checklistMap = new HashMap<>();
            // Basic Info
            checklistMap.put("studentName", checklist.getStudentName());
            checklistMap.put("age", checklist.getAge());
            checklistMap.put("grade", checklist.getGrade());
            checklistMap.put("evaluatorName", checklist.getEvaluatorName());
            checklistMap.put("evaluationDate", checklist.getEvaluationDate());

            // Questionnaire
            checklistMap.put("delayedSpeech", checklist.getDelayedSpeech());
            checklistMap.put("letterConfusion", checklist.getLetterConfusion());
            checklistMap.put("difficultyLearningLetters", checklist.getDifficultyLearningLetters());
            checklistMap.put("troubleWithRhymes", checklist.getTroubleWithRhymes());
            checklistMap.put("difficultySegmentingWords", checklist.getDifficultySegmentingWords());
            checklistMap.put("slowReadingProgress", checklist.getSlowReadingProgress());
            checklistMap.put("avoidsReadingAloud", checklist.getAvoidsReadingAloud());
            checklistMap.put("guessesWords", checklist.getGuessesWords());
            checklistMap.put("spellingErrors", checklist.getSpellingErrors());
            checklistMap.put("slowFluency", checklist.getSlowFluency());
            checklistMap.put("writingDifficulty", checklist.getWritingDifficulty());
            checklistMap.put("strugglesWithSecondLanguage", checklist.getStrugglesWithSecondLanguage());
            checklistMap.put("mixesLetterOrder", checklist.getMixesLetterOrder());
            checklistMap.put("avoidsReadingWritingTasks", checklist.getAvoidsReadingWritingTasks());
            checklistMap.put("familyHistory", checklist.getFamilyHistory());

            int answeredCount = (int) Stream.of(
                    checklist.getDelayedSpeech(),
                    checklist.getLetterConfusion(),
                    checklist.getDifficultyLearningLetters(),
                    checklist.getTroubleWithRhymes(),
                    checklist.getDifficultySegmentingWords(),
                    checklist.getSlowReadingProgress(),
                    checklist.getAvoidsReadingAloud(),
                    checklist.getGuessesWords(),
                    checklist.getSpellingErrors(),
                    checklist.getSlowFluency(),
                    checklist.getWritingDifficulty(),
                    checklist.getStrugglesWithSecondLanguage(),
                    checklist.getMixesLetterOrder(),
                    checklist.getAvoidsReadingWritingTasks(),
                    checklist.getFamilyHistory()
            ).filter(score -> score >= 0).count();
            checklistMap.put("answeredCount", answeredCount);

            // Computed Results
            checklistMap.put("totalScore", checklist.getTotalScore());
            checklistMap.put("riskLevel", checklist.getRiskLevel());
            resultMap.put("checklist", checklistMap);

            Map<String, Object> meta = new HashMap<>();
            meta.put("screeningId", screeningId);
            meta.put("childName", checklist.getStudentName());
            meta.put("evaluatorName", checklist.getEvaluatorName());
            meta.put("submittedAt", checklist.getEvaluationDate());
            resultMap.put("meta", meta);

        }, () -> resultMap.put("checklist", Collections.emptyMap()));

        // ---------------- Word Match ----------------
        wordMatchRepository.findByScreeningId(screeningId).ifPresentOrElse(wordMatch -> {
            Map<String, Object> wmMap = new HashMap<>();
            wmMap.put("correct", wordMatch.getScore());
            wmMap.put("total", wordMatch.getTotal());
            resultMap.put("wordMatch", wmMap);
        }, () -> resultMap.put("wordMatch", Collections.emptyMap()));

        // ---------------- Pattern Recognition ----------------
        patternRecognitionRepository.findByScreeningId(screeningId).ifPresentOrElse(pattern -> {
            Map<String, Object> prMap = new HashMap<>();
            prMap.put("correct", pattern.getScore());
            prMap.put("total", pattern.getTotal());
            resultMap.put("pattern", prMap);
        }, () -> resultMap.put("pattern", Collections.emptyMap()));

        return resultMap;
    }
}
