package media.tvshow.ratings.adapters.`in`.http

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse

interface RatingsHandlers {

    suspend fun rateEpisode(request: ServerRequest): ServerResponse

}
