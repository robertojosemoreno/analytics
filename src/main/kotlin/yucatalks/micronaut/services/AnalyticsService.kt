package yucatalks.micronaut.services

import jakarta.inject.Singleton
import yucatalks.micronaut.models.Book
import yucatalks.micronaut.models.BookAnalytics
import java.util.concurrent.ConcurrentHashMap

@Singleton
class AnalyticsService {
    private val bookAnalytics: MutableMap<Book, Long> = ConcurrentHashMap()

    fun updateBookAnalytics(book: Book) {
        bookAnalytics.compute(book) { k, v ->
            if (v == null) return@compute 1L else return@compute v + 1
        }
    }

    fun listAnalytics(): List<BookAnalytics> =
        bookAnalytics.entries.map { (key, value) -> BookAnalytics(key.isbn, value) }
}