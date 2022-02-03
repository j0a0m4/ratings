package media.tvshow.ratings.adapters.out.nosql

import arrow.core.Option
import kotlinx.coroutines.reactive.awaitFirstOrNull
import media.tvshow.ratings.domain.Episode
import media.tvshow.ratings.usecases.RatingsPersistence
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Service
import java.util.*

@Service
class RatingsReactiveMongo(private val operations: ReactiveMongoOperations) : RatingsPersistence {

    override suspend fun saveRating(episodeId: UUID, rating: Int): Option<Episode> =
        findById(episodeId).flatMap {
            saveEpisode(it setRating rating)
        }

    override suspend fun saveEpisode(episode: Episode) =
        operations.run {
            save(episode).awaitFirstOrNull()
        }.let { Option.fromNullable(it) }

    override suspend fun findById(episodeId: UUID): Option<Episode> =
        operations.run {
            Query(where("_id").isEqualTo(episodeId)).let {
                find<Episode>(it).awaitFirstOrNull()
            }
        }.let { Option.fromNullable(it) }
}

