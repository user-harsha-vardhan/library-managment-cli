data class Book(
    val id: Int,
    val title: String,
    val author: String,
    var isAvailable: Boolean = true
)
fun main () {
    val library = Library()
    while (true) {
        println(
            """
            ===== Library Menu ====
            1.add book
            2.view books
            3.search book by title
            4.search book by author
            5.borrow book
            6.return book
            7.delete book 
            8.exit
        """.trimIndent()
        )

        println("\n enter your choice:")
        when (readln().toIntOrNull()) {
            1 -> {
                println("enter title:")
                val title = readln()
                println("enter author:")
                val author = readln()
                library.addBook(title,author)
            }

            2 -> {
                library.viewBooks()
            }

            3 -> {
                println("enter book title:")


            }
        }
    }
}