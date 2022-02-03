package media.tvshow.ratings.domain

class Episode(private var rating: Int) {

    infix fun setRating(rating: Int) = apply {
        this.rating = rating
    }

}