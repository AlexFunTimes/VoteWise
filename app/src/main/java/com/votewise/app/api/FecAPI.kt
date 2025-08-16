// data/api/FecApi.kt
interface FecApi {
    @GET("candidates")
    fun getCandidates(@Query("api_key") apiKey: String): Call<List<Candidate>>

    companion object {
        fun create(): FecApi = Retrofit.Builder()
            .baseUrl("https://api.open.fec.gov/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FecApi::class.java)
    }
}

// Similar for OpenSecrets, VoteSmart, NewsAPI, Ballotpedia (use Jsoup for scraping if no API)
// For X API: Use x_semantic_search tool or official X API v2 for semantic searches
// For state APIs: Load from assets/state_config.json, e.g., {"FL": "https://dos.myflorida.com/elections/"}
// For AI consistency scoring: Retrofit to OpenAI API endpoint, e.g., POST to /chat/completions with prompt: "Score flip-flops on [positions] from 1-10"