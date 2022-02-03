package media.tvshow.ratings.infra

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing

@Configuration
@EnableReactiveMongoAuditing
internal class MongoConfig