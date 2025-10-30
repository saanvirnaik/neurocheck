package com.neurohearts.neurocheck.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "screening_consent")
public class ConsentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String screeningId;
    private String studentName;
    private String parentName;
    private String parentEmail;
    private boolean consentGiven;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDate consentDate;

    public String getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(String screeningId) {
        this.screeningId = screeningId;
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public boolean isConsentGiven() {
        return consentGiven;
    }

    public void setConsentGiven(boolean consentGiven) {
        this.consentGiven = consentGiven;
    }

    public LocalDate getConsentDate() {
        return consentDate;
    }

    public void setConsentDate(LocalDate consentDate) {
        this.consentDate = consentDate;
    }
}
