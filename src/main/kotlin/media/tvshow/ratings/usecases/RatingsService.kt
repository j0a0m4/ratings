package media.tvshow.ratings.usecases

import media.tvshow.ratings.domain.EpisodeRating
import org.springframework.stereotype.Service

@Service
class RatingsService(val persistence: RatingsPersistence) : RatingsUseCases {

    override suspend fun rateEpisode(episodeRating: EpisodeRating) {
        episodeRating.let {
            persistence.apply {
                saveRating(it.episodeId, it.rating)
            }
        }
    }

}