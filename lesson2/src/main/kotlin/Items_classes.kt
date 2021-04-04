data class FictionBook(
    val title: String,
    val author: String,
    override val price: Int,
    override val category: String,
    override val date: DateCustom)
    : Item {
        override fun printInfo() {
            val a = listOf(this.category, this.author, this.title, this.price, this.date.printString())
            println(a.joinToString(prefix="[", postfix = "]"))
        }
    }

data class Vinyl(
    val album: String,
    val author: String,
    override val price: Int,
    override val category: String,
    override val date: DateCustom)
    : Item {
    override fun printInfo() {
        val a = listOf(this.category, this.author, this.album, this.price, this.date.printString())
        println(a.joinToString(prefix="[", postfix = "]"))
    }
    }

data class Movie(
    val title: String,
    val director: String,
    override val price: Int,
    override val category: String,
    override val date: DateCustom)
    : Item {
        override fun printInfo() {
            val a = listOf(this.category, this.title, this.director, this.price, this.date.printString())
            println(a.joinToString(prefix="[", postfix = "]"))
        }
    }





