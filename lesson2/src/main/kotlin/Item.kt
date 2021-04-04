interface Item {
    fun printInfo() {
        val a = listOf(category, price, date)
        println(a.joinToString())
    }

    val category: String
    val price: Int
    val date: DateCustom
}