abstract class DAO {
    abstract val data: Map<Int, String>
    abstract fun getItemById(id: Int): String?
    abstract fun getAllItems(): List<String>
    /*fun getItemById(id: Int): String? {
        return data[id]
    }*/

    /*fun getAllItems(): List<String> {
        return data.values.toList()
    }*/

}