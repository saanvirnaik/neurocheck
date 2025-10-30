# 🧩 NeuroCheck

[![YouTube Demo](https://img.shields.io/badge/🎥%20Watch-Demo-red?logo=youtube)](https://youtu.be/Wi13vPI1PEc?si=p96PEYjSKlndkNA-)
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

### 🔄 Combined Architecture + App Flow

```mermaid
flowchart TD
    A["User (Parent / Child)"] --> B["Frontend - React + Material UI"]
    B --> C["Screening Modules (Autism / ADHD / Dyslexia)"]
    C --> D["REST API - Spring Boot Backend"]
    D --> E["Scoring & Analysis Engine"]
    E --> F["MySQL Database"]
    F --> G["Results Dashboard"]
    G --> H["Resources & Next Steps"]
    H --> I["Hosting & Deployment - Vercel / Render"]
