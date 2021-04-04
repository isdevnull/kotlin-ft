
fun testDate() {
    val d1 = DateCustom(2018, 6, 1)
    val d2 = DateCustom(2019, 7, 30)
    val d3 = DateCustom(2019, 7, 31)
    check(d2 < d3)
    check(d1 < d2)
    check(d1 < d3)
    println("testDate OK!")
}


fun main() {
    testDate()
    val w = Warehouse()
    val books = listOf<Item>(
        FictionBook("1Q84a","Haruki Murakami", 10, "Book", DateCustom(2020, 6, 3)),
        FictionBook("Crime and Punishment", "Fyodor Dostoevsky", 20, "Book", DateCustom(2014, 5, 1)),
        FictionBook("Ulysses", "James Joyce", 30, "Book", DateCustom(2017, 8, 15))
    )
    val albums = listOf<Item>(
        Vinyl("Meteora", "Linkin Park", 50, "Music", DateCustom(2006, 5, 30)),
        Vinyl("El Pintor", "Interpol", 40, "Music", DateCustom(2014, 3, 20)),
        Vinyl("Diamond Eyes", "Deftones", 35, "Music", DateCustom(2010, 4, 4))
    )
    val movies = listOf<Item>(
        Movie("Mulholland Drive", "David Lynch", 60, "Movie", DateCustom(2002, 10, 11)),
        Movie("Persona", "Ingmar Bergman", 55, "Movie", DateCustom(1990, 11, 5)),
        Movie("Nomadland", "Chloe Zhao", 44, "Movie", DateCustom(2020, 11, 12))
    )
    w.add(books)
    w.add(albums)
    w.add(movies)
    w.add(FictionBook("Rainbow Gravity", "Thomas Pynchon", 25, "Book", DateCustom(1980, 2, 20)))
    println("Items Sorted By Price:")
    w.getAllItemsSortedBy("price").forEach {it.printInfo()}
    println()
    println("Items Sorted By Date:")
    w.getAllItemsSortedBy("date").forEach {it.printInfo()}
    println()
    val price = 45
    println("All Items Lower Than $price:")
    w.getAllItemsLowerThan(price).forEach {it.printInfo()}
    println()
    val date = DateCustom(2000, 1, 1)
    println("All Items Before given date ${date.printString()}")
    w.getAllItemsLowerThan(date).forEach { it.printInfo() }
    println()
    println("Books Lower than given price ${price - 20}")
    w.getAllItemsLowerThan("Book", price - 20).forEach { it.printInfo() }
}