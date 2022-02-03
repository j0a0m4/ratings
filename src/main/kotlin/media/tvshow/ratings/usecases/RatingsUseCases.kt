package media.tvshow.ratings.usecases

import media.tvshow.ratings.domain.EpisodeRating

interface RatingsUseCases {
    suspend fun rateEpisode(episodeRating: EpisodeRating)

}
