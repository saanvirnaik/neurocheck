# 🧩 NeuroCheck

[![YouTube Demo](https://img.shields.io/badge/🎥%20Watch-Demo-red?logo=youtube)](https://youtu.be/Wi13vPI1PEc?si=p96PEYjSKlndkNA-)
[![Patent Pending](https://img.shields.io/badge/Patent-Pending-blueviolet)](#)
[![Volunteering Impact](https://img.shields.io/badge/Inspired%20By-Community%20Service-orange)](#)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![Tech Stack](https://img.shields.io/badge/Built%20With-React%20%7C%20Spring%20Boot%20%7C%20MySQL-blue)](#-technology-stack)

**NeuroCheck** is a fun, educational web app that helps identify early signs of **Autism, ADHD, and Dyslexia** using a combination of **scientific questionnaires** and **interactive, game-based assessments**.  
It is designed to promote awareness, inclusion, and early support for children with neurodiverse needs.

---

## 🌈 Features

- 🧠 **Checklist-based Screeners** — Autism, ADHD, and Dyslexia  
- 🎮 **Gamified Mini-Tests** — Fun interactive activities that assess focus, attention, and memory  
- 📊 **Instant Results Report** — Printable and easy-to-understand summaries  
- 🌍 **Resource Library** — Links to national and local neurodiversity support organizations  
- 🔐 **Privacy First** — No user data transmitted  

---

## 💡 Inspiration

This project was inspired by **Saanvi Naik’s** volunteering work at *Stable Influence*, a therapeutic horse-riding center where children with autism and other developmental conditions come for equine therapy.  
Seeing the positive change early intervention brought to these children motivated her to create a digital tool that helps families begin the journey toward awareness and support.

---

## 🧩 Technology Stack

| Layer | Technology | Description |
|-------|-------------|-------------|
| **Frontend** | React + Framer Motion | Responsive, animated user interface |
| **Backend** | Spring Boot (Java) | REST APIs and screening logic |
| **Database** | MySQL | Stores screening data and configurations |
| **Deployment** | Vercel + Render | Fast, free hosting for CAC submission |

---

## 🧠 System Overview

NeuroCheck follows a **modular, secure client–server architecture** designed for accessibility, scalability, and privacy.  
It connects interactive front-end modules with a robust back-end that performs logic scoring and returns personalized feedback.

---

### ⚙️ Scoring Algorithms (Patent-Protected)

NeuroCheck uses a structured scoring framework that combines **scientific questionnaires** and **interactive task results** to generate indicative scores for Autism, ADHD, and Dyslexia.  
Each response and gameplay action contributes to weighted categories such as **focus**, **reading awareness**, and **attention span**, which are then compiled into a **condition-specific index**.

> 🧩 *The detailed computation model, weighting logic, and normalization process are part of the **patent-pending NeuroCheck Early Screening System (US 63/958,427)** and are not publicly disclosed.*

---

### 🧩 Detailed Architecture

```mermaid
graph TD
    subgraph Frontend
        UI["React UI"]
        Logic["Game Logic & Questionnaire Engine"]
    end

    subgraph Backend
        API["Spring Boot API"]
        Analyzer["Scoring Algorithms"]
    end

    subgraph Database
        DB["MySQL Database"]
    end

    subgraph Hosting
        Cloud["Vercel / Render"]
    end

    UI -->|User Inputs| Logic
    Logic -->|Responses| API
    API --> Analyzer
    Analyzer --> DB
    DB --> API
    API --> UI
    Cloud --> API
```

---

### 🔢 Database Model (ER Diagram)

```mermaid
erDiagram
    USER {
        INT id PK
        STRING name
        INT age
        STRING relationship
    }

    SCREENING {
        INT id PK
        STRING type
        DATETIME date_taken
        INT user_id FK
    }

    QUESTION {
        INT id PK
        STRING category
        STRING text
    }

    RESPONSE {
        INT id PK
        INT question_id FK
        INT screening_id FK
        STRING answer
        INT score
    }

    RESULT {
        INT id PK
        INT screening_id FK
        STRING condition
        FLOAT total_score
        STRING recommendation
    }

    USER ||--o{ SCREENING : "has many"
    SCREENING ||--o{ RESPONSE : "records"
    RESPONSE }o--|| QUESTION : "references"
    SCREENING ||--|| RESULT : "generates"
```

---

### 🗂️ Data Schema Description

| Table | Purpose | Key Columns |
|--------|----------|-------------|
| **USER** | Stores parent/child information | `id`, `name`, `age`, `relationship` |
| **SCREENING** | Represents a single screening session | `id`, `type`, `date_taken`, `user_id` |
| **QUESTION** | Contains all questions for each condition | `id`, `category`, `text` |
| **RESPONSE** | Links user answers to questions | `question_id`, `screening_id`, `score` |
| **RESULT** | Stores summary and recommendations | `screening_id`, `condition`, `total_score` |

---

### 📱 Screening Flow

```mermaid
flowchart LR
    Start["Start Screen"] --> Choose["Select Condition"]
    Choose --> Play["Game / Questionnaire"]
    Play --> Process["Backend Analysis"]
    Process --> Results["Results Dashboard"]
    Results --> Learn["Learning Resources"]
    Learn --> Restart["Restart / New Screening"]
```

---

### 🔒 Data Privacy

```mermaid
graph LR
    A["User"] -->|Anonymous ID| B["Frontend"]
    B -->|Secure HTTPS| C["Backend API"]
    C -->|Anonymized Storage| D["MySQL Database"]
    D -->|Retention Policy| E["Scheduled Cleanup"]
```
---

## 🚀 Deployment Links

| Component | URL |
|------------|-----|
| **GitHub Repo** | [https://github.com/saanvirnaik/neurocheck](https://github.com/saanvirnaik/neurocheck) |
| **Demo Video** | [Watch on YouTube](https://youtu.be/Wi13vPI1PEc?si=p96PEYjSKlndkNA-) |

---

## 🔧 Installation (Local Development)

### Frontend
```bash
cd frontend
npm install
npm start
```

### Backend
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

---

## 📄 License
This project is licensed under the **MIT License** — see the [LICENSE](LICENSE) file for details.

---

> 🧩 *Developed and submitted by **Saanvi Naik** for the 2025 Congressional App Challenge.*  
> *Patent No: **US 63/958,427 – NeuroCheck Early Screening System (Patent Pending).***  
> *Inspired by volunteering at Stable Influence Therapeutic Riding Center.*

