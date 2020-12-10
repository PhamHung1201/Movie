package com.hungpham.movie_support.internal

import com.hungpham.movie_support.*
import com.hungpham.movie_support.internal.response.*
import io.reactivex.Single

/**
 * Created by hung.pham on 10/11/20.
 */
class MovieProviderImpl(
    private val movieServices: MovieServices,
    private val imageDataFactory: ImageDataFactory
) : MovieProvider {

    override fun getTrendingMovie(): Single<List<MovieData>> {
        return movieServices.getTrendingMovies()
            .map(this::mapTrendingMovie)
    }

    override fun getDiscoverMovie(): Single<List<MovieData>> {
        return movieServices.getDiscoverMovies()
            .map(this::mapDiscoverMovie)
    }

    override fun getMovieDetails(movieId: Long): Single<MovieDetailsData> {
        return movieServices.getMovieDetails(movieId)
            .map(this::mapMovieDetailsData)
    }

    override fun getVideoOfAMovie(movieId: Long): Single<VideoOfMovieData> {
        return movieServices.getVideoOfMovieDetails(movieId)
            .map(this::createVideoMovieData)
    }

    override fun getImageOfAMovie(movieId: Long): Single<ImageOfMovieData> {
        return movieServices.getImageOfMovieDetails(movieId)
            .map(this::createImageMovieData)
    }

    override fun getActors(): Single<List<ActorData>> {
        return movieServices.getPopularActors()
            .map(this::createActorData)
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
}