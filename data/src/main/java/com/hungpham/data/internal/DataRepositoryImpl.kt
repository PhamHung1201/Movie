package com.hungpham.data.internal

import com.hungpham.data.DataRepository
import com.hungpham.data.internal.entity.GenreEntity
import com.hungpham.data.internal.movie.*
import com.hungpham.data.internal.movie.response.*
import com.hungpham.model.GenreData


class DataRepositoryImpl(
    private val movieServices: MovieServices,
    private val database: AppDatabase,
    private val imageDataFactory: ImageDataFactory
) : DataRepository {
    override suspend fun getTrendingMovie(): List<MovieData> {
        val trendingMoviesResponse = movieServices.getTrendingMovies()
        return mapTrendingMovie(trendingMoviesResponse)
    }

    override suspend fun getDiscoverMovie(filters: Map<String, String>): List<MovieData> {
        val discoverMovieResponse = movieServices.getDiscoverMovies(filters)
        return mapDiscoverMovie(discoverMovieResponse)
    }

    override suspend fun getMovieDetails(movieId: Long): MovieDetailsData {
        val response = movieServices.getMovieDetails(movieId)
        return mapMovieDetailsData(response)
    }

    override suspend fun getVideoOfAMovie(movieId: Long): VideoOfMovieData {
        val response = movieServices.getVideoOfMovieDetails(movieId)
        return createVideoMovieData(response)
    }

    override suspend fun getImageOfAMovie(movieId: Long): ImageOfMovieData {
        val response = movieServices.getImageOfMovieDetails(movieId)
        return createImageMovieData(response)
    }

    override suspend fun getActors(): List<ActorData> {
        val popularActorResponse = movieServices.getPopularActors()
        return createActorData(popularActorResponse)
    }

    override suspend fun getPopularTvShows(): List<TvShowData> {
        val tvShowResponse = movieServices.getPopularTvShows()
        return createTvShowData(tvShowResponse)
    }

    override suspend fun getDiscoverTvShowBy(filters: Map<String, String>): List<TvShowData> {
        val tvShowResponse = movieServices.getDiscoverTvShows(filters)
        return createTvShowData(tvShowResponse)
    }

    override suspend fun getGenres(): List<GenreData> {
        return movieServices.getGenres().getGenres()
    }

    override suspend fun saveGenre(genres: List<GenreData>) {
        val entities = genres.map {
            GenreEntity(it.getId(), it.getName())
        }
        database.genreDao().insertGenres(entities)
    }

    private fun mapDiscoverMovie(response: DiscoverMovieResponse): List<MovieData> {
        return response.getMovies()
            .filterIndexed { index, _ -> index < 10 }
            .map { createMovieData(it) }
            .toList()
    }

    private fun mapTrendingMovie(response: TrendingMoviesResponse): List<MovieData> {
        return response.getMovies()
            .filterIndexed { index, _ -> index < 10 }
            .map { createMovieData(it) }
            .toList()
    }

    private fun mapMovieDetailsData(response: MovieDetailsResponse): MovieDetailsData {
        return with(response) {
            return@with MovieDetailsData(
                id = getId(),
                title = getOriginalTitle(),
                overview = getOverview(),
                poster = imageDataFactory.create(getPosterPath()),
                backdrop = imageDataFactory.create(getBackdropPath()),
                runtime = getRuntime(),
                originalLanguage = getOriginalLanguage(),
                budget = getBudget(),
                voteAverage = getVoteAverage(),
                voteCount = getVoteCount(),
                revenue = getRevenue()
            )
        }
    }

    private fun createMovieData(movie: Movie): MovieData {
        return MovieData(
            movie.getId(),
            movie.getTitle(),
            movie.getOverview(),
            0.0f,
            movie.getVoteCount(),
            MovieDateTime(movie.getReleaseDate()),
            imageDataFactory.create(movie.getPosterPath()),
            imageDataFactory.create(movie.getBackdropPath())
        )
    }

    private fun createVideoMovieData(response: VideoOfAMovieResponse): VideoOfMovieData {
        val videoDatas = response.getResults()
            .map {
                createVideoData(it)
            }
        return with(response) {
            return@with VideoOfMovieData(
                response.getId(),
                videoDatas
            )
        }
    }

    private fun createVideoData(res: VideoOfAMovieResponse.VideoResponse): VideoData {
        return with(res) {
            return@with VideoData(
                id = getId(),
                key = getKey(),
                name = getName(),
                site = getSite(),
                size = getSize(),
                type = getType(),
                url = "http://img.youtube.com/vi/${getKey()}/maxresdefault.jpg"
            )
        }
    }

    private fun createImageMovieData(res: ImageOfMovieResponse): ImageOfMovieData {
        val posters = res.posters.map {
            imageDataFactory.create(it.filePath).copy(
                aspectRatio = it.aspectRatio,
                height = it.height,
                width = it.width,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount
            )
        }
        val backdrops = res.backdrops.map {
            imageDataFactory.create(it.filePath).copy(
                aspectRatio = it.aspectRatio,
                height = it.height,
                width = it.width,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount
            )
        }
        return ImageOfMovieData(posters, backdrops)
    }

    private fun createActorData(res: PopularActorResponse): List<ActorData> {
        return res.getActors()
            .map {
                ActorData(
                    it.getId(),
                    it.getName(),
                    imageDataFactory.create(it.getProfilePath()),
                    it.getPopularity()
                )
            }
    }

    private fun createTvShowData(res: TvShowResponse): List<TvShowData> {
        return res.getTvShows()
            .map {
                TvShowData(
                    it.getId(),
                    it.getName(),
                    imageDataFactory.create(it.getPosterPath()),
                    it.getPopularity()
                )
            }
    }
}