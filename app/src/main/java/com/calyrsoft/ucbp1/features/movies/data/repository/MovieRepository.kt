package com.calyrsoft.ucbp1.features.movies.data.repository

import com.calyrsoft.ucbp1.features.movies.data.datasource.MovieRemoteDataSource
import com.calyrsoft.ucbp1.features.movies.domain.model.MovieModel
import com.calyrsoft.ucbp1.features.movies.domain.repository.IMovieRepository

private const val POSTER_BASE = "https://image.tmdb.org/t/p/w342"

class MovieRepository(
    private val remote: MovieRemoteDataSource
) : IMovieRepository {

    override suspend fun getPopularMovies(): Result<List<MovieModel>> =
        remote.getPopularMovies().map { page ->
            page.results.map { dto ->
                MovieModel(
                    id = dto.id,
                    title = dto.title,
                    posterUrl = dto.posterPath?.let { "$POSTER_BASE$it" } ?: ""
                )
            }
        }
}
