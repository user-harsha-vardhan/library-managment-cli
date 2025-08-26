class Library {
    private val books = mutableListOf<Book>()
    private var id = 1

    fun addBook(title: String, author: String) {
        books.add(Book(id++, title, author))
        println("\n book added")
    }

    fun viewBooks () {
        if (books.isEmpty()) println("no books found")
        else books.forEachIndexed { i, book ->
            println("${i + 1} book=${book.title}, author= ${book.author}")
        }
    }

    fun searchByTitle (title: String) {
        val found = books.filter { it.title.contains(title, ignoreCase = true) }
        if (found.isEmpty()) println("no book found by that title")
        else found.forEach { println(it) }
    }

    fun searchByAuthor (author: String) {
        val found  = books.filter {it.author.contains(author, ignoreCase = true)}
        if (found.isEmpty()) println("no book found by that author name")
        else found.forEach { println(it) }
    }

    fun borrowBook (id: Int){
        val book = books.find { it.id == id }
        if (book == null) println("book not found")
        else if (!book.isAvailable) println("book is already borrowed")
        else {
            book.isAvailable = false
            println("you borrowed ${book.title}")
        }
    }

    fun returnBook (id: Int) {
        val book = books.find{ it.id == id}
        if (book == null) println("book not found")
        else if (book.isAvailable) println("book was not borrowed")
        else {
            book.isAvailable = true
            println("you returned: ${book.title}")
        }
    }


    fun deleteBook (id: Int) {
        if (books.removeIf { it.id == id }) println("book deleted")
        else println("book not found")
    }


}