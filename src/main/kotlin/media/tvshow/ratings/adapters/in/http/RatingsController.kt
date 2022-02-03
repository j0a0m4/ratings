package media.tvshow.ratings.adapters.`in`.http

import media.tvshow.ratings.domain.EpisodeRating
import media.tvshow.ratings.usecases.RatingsUseCases
import org.springframework.stereotype.Controller
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.buildAndAwait

@Controller
class RatingsController(private val useCases: RatingsUseCases) : RatingsHandlers {

    override suspend fun rateEpisode(request: ServerRequest): ServerResponse =
        useCases.run {
            request.awaitBody<EpisodeRating>().let {
                rateEpisode(it)
                ServerResponse.accepted().buildAndAwait()
            }
        }
}
