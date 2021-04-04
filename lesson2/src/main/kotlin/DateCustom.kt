data class DateCustom(val year: Int, val month: Int, val day: Int) : Comparable<DateCustom> {
    override fun compareTo(other: DateCustom): Int {
        return when {
            this.year != other.year -> this.year - other.year
            this.month != other.month -> this.month - other.month
            else -> this.day - other.day
        }
    }
}

fun DateCustom.printString() = "$year-$month-$day"