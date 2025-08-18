package com.votewise.app.utils

object Constants {
    // API Keys - Replace with your actual keys
    const val GOOGLE_CIVIC_API_KEY = "YOUR_GOOGLE_CIVIC_API_KEY" // From https://console.cloud.google.com/apis/library/civicinfo.googleapis.com
    const val NEWS_API_KEY = "YOUR_NEWS_API_KEY" // From https://newsapi.org/
    const val OPENAI_API_KEY = "YOUR_OPENAI_API_KEY" // From https://platform.openai.com/
    const val X_API_BEARER_TOKEN = "YOUR_X_BEARER_TOKEN" // From https://developer.twitter.com/ (Basic/Pro access required)
    const val FEC_API_KEY = "YOUR_FEC_API_KEY" // From https://api.data.gov/signup/
    const val VOTESMART_API_KEY = "YOUR_VOTESMART_API_KEY" // From https://votesmart.org/services_api
    const val OPEN_SECRETS_API_KEY = "YOUR_OPEN_SECRETS_API_KEY" // From https://www.opensecrets.org/api/
    const val BALLOTPEDIA_API_KEY = "YOUR_BALLOTPEDIA_API_KEY" // If available; otherwise, use scraper with Jsoup

    // AdMob and Billing
    const val ADMOB_APP_ID = "YOUR_ADMOB_APP_ID" // From Google AdMob console
    const val PREMIUM_MONTHLY_ID = "premium_monthly" // Google Play Console product ID
    const val PREMIUM_YEARLY_ID = "premium_yearly"
    const val REPORT_BUNDLE_ID = "report_bundle_10" // For microtransactions

    // Other Constants
    const val DATABASE_NAME = "votewise_db"
    const val STATES_JSON_FILE = "states.json" // Assets file for state API configs
    const val DEFAULT_ZIP_CODE = "90210" // For testing
    const val QUIZ_QUESTION_COUNT = 25 // Number of quiz questions
    const val FREE_REPORT_LIMIT = 3 // Daily free reports
    const val MIN_MATCH_PERCENT = 0 // For progress bars
    const val MAX_MATCH_PERCENT = 100
}