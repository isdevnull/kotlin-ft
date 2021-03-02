import kotlin.collections.HashMap

class Warehouse {
    private val storage: HashMap<String, MutableSet<Item>> = HashMap()

    fun add(item: Item) {
        if (storage.containsKey(item.category))
            storage[item.category]!!.add(item)
        else
            storage[item.category] = mutableSetOf<Item>(item)
    }
    fun add(items: List<Item>) {
        items.forEach {this.add(it)}
    }

    fun getAllItemsSortedBy(name: String): List<Item> {
        return when {
            name == "price" -> storage.flatMap {it.value}.sortedBy { it.price }
            name == "date" -> storage.flatMap {it.value}.sortedBy { it.date }
            else -> throw Exception("$name not found.")
        }
    }

    fun getAllItemsLowerThan(price: Int): List<Item> = storage.flatMap { it.value}.filter{ it.price < price } // return all items lower than given price
    fun getAllItemsLowerThan(date: DateCustom): List<Item> = storage.flatMap {it.value}.filter{ it.date < date } // return all dates lower than given
    fun getAllItemsLowerThan(item_category: String, price: Int): List<Item> {
        return storage.getValue(item_category).filter { it.price < price }
    }
}
