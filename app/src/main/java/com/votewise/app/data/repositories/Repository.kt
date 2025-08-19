package com.votewise.app.data.repository

// ...
suspend fun getCandidates(address: String): List<Candidate> {
    val cached = dao.getAll()
    if (cached.isNotEmpty()) return cached.map { it.toModel() }
    // Fetch from APIs, map to entity, insert
    val response = /* API call */
        dao.insertAll(response.map { it.toEntity() })
    return response.map { it.toModel() }  // Assume API response has toModel()
}

// Extensions (in utils/Extensions.kt)
fun CandidateEntity.toModel(): Candidate = Candidate(id, name, party, bio, positions, donors)
fun Candidate.toEntity(): CandidateEntity = CandidateEntity(id, name, party, bio, positions, donors)