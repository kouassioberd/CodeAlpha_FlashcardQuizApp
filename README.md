# FlashcardQuizApp

[![Kotlin](https://img.shields.io/badge/Kotlin-FF5722?style=flat&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=flat&logo=android&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Room](https://img.shields.io/badge/Room-FF6D00?style=flat&logo=android&logoColor=white)](https://developer.android.com/jetpack/androidx/releases/room)
[![MVVM](https://img.shields.io/badge/MVVM-00C853?style=flat)](https://developer.android.com/jetpack/guide)

A simple **flashcard app** for studying built with **Jetpack Compose**, **Room database**, and **MVVM architecture**. Add, view, edit and delete flashcards with a clean UI and persistent storage.

---

## Table of Contents
1. [Project Structure](#project-structure)
2. [Features](#features)
3. [Tech Stack](#tech-stack)
4. [Installation](#installation)
5. [How to Use](#how-to-use)
6. [Screenshots](#screenshots)

---

## Project Structure

```
com.example.codealpha_flashcardquizapp
├── data
│   ├── dao
│   │   └── FlashcardDao.kt
│   ├── database
│   │   └── FlashcardDatabase.kt
│   └── entity
│       └── Flashcard.kt
|
├── navigation
│   └── NavGraph.kt
|
├── ui
│   └── screens
│       ├── AddFlashcardScreen.kt
|       └── EditFlashcardScreen.kt
│       └── FlashcardScreen.kt
├── viewmodel
│   └── FlashcardViewModel.kt
└── MainActivity.kt
    
```

---

## Features

- Add new flashcards (question & answer)
- View flashcards using `Previous` / `Next`
- Show / hide flashcard answers
- Edit flashcard
- Delete flashcards
- Persistent data using **Room**
- Modern **Jetpack Compose UI**
- **MVVM architecture**
- Navigation with **Navigation Compose**

---

## Tech Stack

| Layer | Technology |
|------|-----------|
| Language | Kotlin |
| UI | Jetpack Compose (Material3) |
| Architecture | MVVM |
| Database | Room |
| Navigation | Navigation Compose |
| Lifecycle | ViewModel + StateFlow |

---

## Installation

1. Clone the repository

2. Open the project in Android Studio

3. Sync Gradle

4. Run the app on an emulator or physical device

---

## How to Use

1. Tap the + button to add a flashcard

2. Enter a question and answer

3. Tap Save Flashcard

4. Navigate cards using Previous / Next

5. Tap Show Answer to reveal the answer or Hide Answer to hide the answer

6. Tape Edit to edit the flashcard   

7. Delete flashcards using the Delete button

8. Restart the app → data persists 🎉

---

## Screenshots

<img width="250"  alt="Screenshot_20260211_074115" src="https://github.com/user-attachments/assets/19c9cbfa-47a2-48a4-9b34-1363f7fafaec" />
<img width="250"  alt="Screenshot_20260211_074210" src="https://github.com/user-attachments/assets/b34cd214-fbf9-42ec-9fc2-dcf98aee1941" />
<img width="250"  alt="Screenshot_20260211_074259" src="https://github.com/user-attachments/assets/9adb0a08-c23d-408f-995f-c5c4253f7e57" />
<img width="250"  alt="Screenshot_20260211_074336" src="https://github.com/user-attachments/assets/2f0550ba-af04-4f67-964d-106de5177257" />
<img width="250"  alt="Screenshot_20260211_074502" src="https://github.com/user-attachments/assets/e65321e9-c887-4688-bb22-c5d987325a73" />
<img width="250"  alt="Screenshot_20260211_074517" src="https://github.com/user-attachments/assets/93e99dcb-d6cb-4713-a04b-d8d22d475f77" />
<img width="250"  alt="Screenshot_20260211_074533" src="https://github.com/user-attachments/assets/757608e4-70a0-4afe-97e2-b9e286ea9d5d" />
<img width="250"  alt="Screenshot_20260211_074606" src="https://github.com/user-attachments/assets/4db6e1a8-85cf-4661-957f-9c7fe758174a" />
<img width="250"  alt="Screenshot_20260211_074637" src="https://github.com/user-attachments/assets/9115f9b1-5d08-4dcd-80cd-162a07380bb4" />
<img width="250"  alt="Screenshot_20260211_074649" src="https://github.com/user-attachments/assets/715a175d-2397-44c0-a869-c91dbdb72254" />
<img width="250"  alt="Screenshot_20260211_074825" src="https://github.com/user-attachments/assets/10048ea2-9152-4f4b-a3d6-ebaf494cd59e" />
<img width="250"  alt="Screenshot_20260211_074846" src="https://github.com/user-attachments/assets/0785b9bf-9ee9-4ad7-b309-81130687a1dc" />
<img width="250"  alt="Screenshot_20260211_074858" src="https://github.com/user-attachments/assets/17edfa6d-ca00-4fdc-b4c3-7539d2211013" />
<img width="250"  alt="Screenshot_20260211_074921" src="https://github.com/user-attachments/assets/78e08843-ba06-41ba-b8ef-78d99db7069d" />
<img width="250"  alt="Screenshot_20260211_074951" src="https://github.com/user-attachments/assets/fa62369b-618d-4555-9a93-f667b6894a37" />
<img width="250"  alt="Screenshot_20260211_075006" src="https://github.com/user-attachments/assets/9359ecdf-9591-46d1-8038-34685ea97776" />
<img width="250"  alt="Screenshot_20260211_075052" src="https://github.com/user-attachments/assets/7f1b06f0-80d8-4013-be2b-58d40a0ed48d" />
<img width="250"  alt="Screenshot_20260211_075105" src="https://github.com/user-attachments/assets/b8b199bf-f94d-46e2-a3ea-923092179b94" />
<img width="250"  alt="Screenshot_20260211_075132" src="https://github.com/user-attachments/assets/e935fdc2-2d64-492e-ae6d-c0d262f119fa" />
<img width="250"  alt="Screenshot_20260211_075219" src="https://github.com/user-attachments/assets/27987d82-422e-470b-b403-f4e84d252427" />
<img width="250"  alt="Screenshot_20260211_075250" src="https://github.com/user-attachments/assets/9ede092f-618b-4635-9540-9c5ea2bbd1bd" />
<img width="250"  alt="Screenshot_20260211_075315" src="https://github.com/user-attachments/assets/28b2f6f7-5bac-40fe-9ce1-5ffb5360bf7a" />

<img width="250"  alt="Screenshot_20260211_075405" src="https://github.com/user-attachments/assets/00c7b38c-ea6e-4784-abb6-502c6b7acf51" />
<img width="250"  alt="Screenshot_20260211_075424" src="https://github.com/user-attachments/assets/93e814d1-11fb-418a-8123-83334323bead" />
<img width="250"  alt="Screenshot_20260211_075641" src="https://github.com/user-attachments/assets/beafaf2a-1cf2-42a5-aec4-30ff5a1edc8e" />
<img width="250"  alt="Screenshot_20260211_075651" src="https://github.com/user-attachments/assets/f454c492-a48c-4321-98f0-dd5133183801" />
<img width="250"  alt="Screenshot_20260211_075950" src="https://github.com/user-attachments/assets/8d5ff9d8-3a66-416f-895c-67afcfc79dfc" />
<img width="250"  alt="Screenshot_20260211_080003" src="https://github.com/user-attachments/assets/ebfda4d0-c5fe-4ba6-9fed-67556d6ea869" />
<img width="250"  alt="Screenshot_20260211_080013" src="https://github.com/user-attachments/assets/61b5bf80-21c6-4845-ae6b-3c58f6b21403" />
<img width="250"  alt="Screenshot_20260211_080035" src="https://github.com/user-attachments/assets/7ffd8213-ba42-44b0-b262-be14e87121bf" />

---

## Key Concepts Implemented

- MVVM pattern with ViewModel

- Room database for persistence

- Jetpack Compose state management

- Navigation Compose

- Coroutine-based async operations

- Clean, scalable project structure

---

## Author

Oberd KOUASSI – Software Engineer (Internship Ready)

---

## 📄 License

MIT License
