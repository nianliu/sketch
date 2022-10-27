package functional.programming.patterns.advance

class PriceService constructor(val repo: PriceRepo) {

    fun computeRegularPrice(days: Int) = 1000 / days

    fun computeNewReleasePrice(days: Int) = days * repo.getNewReleasePriceFactor()

    fun computeChildrenPrice(days: Int) = 800 / days

    fun computeEldersPrice(days: Int) = 1500 / days

}