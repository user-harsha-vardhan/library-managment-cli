data class Book(
    val id: Int,
    val title: String,
    val author: String,
    var isAvailable: Boolean = true
)

fun main() {
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
                println("enter book title:")
                val title = readln()
                println("enter book author:")
                val author = readln()
                library.addBook(title, author)
            }

            2 -> {
                library.viewBooks()
            }

            3 -> {
                println("enter book title:")
                val title = readln()
                library.searchByTitle(title)
            }

            4 -> {
                println("enter author name:")
                val author = readln()
                library.searchByAuthor(author)
            }

            5 -> {
                println("enter book id:")
                val id = readln().toIntOrNull() ?: -1
                library.borrowBook(id)
            }

            6 -> {
                println("enter book id to return:")
                val id = readln().toIntOrNull() ?: -1
                library.returnBook(id)
            }

            7 -> {
                println("enter id to delete:")
                val id = readln().toIntOrNull() ?: -1
                library.deleteBook(id)
            }

            8 -> {
                println(" 👋 sayonara 👋")
                break
            }

            else -> println("invalid choice")
        }
    }
}