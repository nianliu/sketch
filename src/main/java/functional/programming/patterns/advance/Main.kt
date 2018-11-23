package functional.programming.patterns.advance

class Main {

    private fun calculatePriceFromJava(movie: MovieJava, days: Int): Int {
        return movie.type.priceAlgo.apply(priceService, days)
    }

    private fun calculatePriceForKtMovie(movie: MovieKt, days: Int): Int {
        return movie.type.priceAlgo.apply(priceService, days)
    }

    companion object {

        private val priceService = PriceService(PriceRepo())

        @JvmStatic
        fun main(args: Array<String>) {
            val movieKt = MovieKt(MovieKt.Type.NEW_RELEASE)
            val movieJava = MovieJava(MovieJava.Type.REGULAR)

            val days = 280

            println(Main().calculatePriceFromJava(movieJava, days))

            println(Main().calculatePriceForKtMovie(movieKt, days))
        }
    }
}
