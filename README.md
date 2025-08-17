# VoteWise: Candidate Insights

A non-partisan Android app for discovering, matching, and analyzing political candidates at federal, state, and county levels. Built with Kotlin and Jetpack Compose.

## Features
- Quiz-based matching (iSideWith-style).
- Candidate reports with AI consistency scores, donor visualizations, news sentiment, and voting records.
- Data from FEC, OpenSecrets, VoteSmart, NewsAPI, X API, and state sources.
- Freemium model with ads and subscriptions via Google Play Billing/AdMob.
- Privacy-focused: GDPR/CCPA compliant, optional X OAuth login.

## Setup
1. Clone: `git clone https://github.com/AlexFunTimes/VoteWise.git`
2. Add API keys in `Constants.kt`.
3. Build in Android Studio (Jellyfish+).
4. Run on emulator/device (Android 8.0+).

## API Keys
- GOOGLE_CIVIC_API_KEY
- NEWS_API_KEY
- OPENAI_API_KEY
- X_API_BEARER_TOKEN
- FEC_API_KEY
- VOTESMART_API_KEY
- ADMOB_APP_ID

See `build.gradle.kts` for dependencies.

Disclaimer: Data from public sources; not affiliated with any party. Verify info independently.
