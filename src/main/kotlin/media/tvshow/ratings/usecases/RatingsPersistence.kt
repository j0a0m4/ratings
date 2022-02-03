package media.tvshow.ratings.usecases

import arrow.core.Option
import media.tvshow.ratings.domain.Episode
import java.util.*

interface RatingsPersistence {

    suspend fun findById(episodeId: UUID): Option<Episode>
    suspend fun saveRating(episodeId: UUID, rating: Int): Option<Episode>
    suspend fun saveEpisode(episode: Episode): Option<Episode>

}
