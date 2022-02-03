package media.tvshow.ratings.adapters.`in`.http

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class Router(private val handler: RatingsHandlers) {

    @Bean
    fun route() = coRouter {
        (accept(APPLICATION_JSON) and "/RatingsChange").nest {
            POST("/", handler::rateEpisode)
        }
    }
}
