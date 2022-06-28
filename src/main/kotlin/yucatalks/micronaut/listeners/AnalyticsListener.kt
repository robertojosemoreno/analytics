package yucatalks.micronaut.listeners

import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.context.annotation.Requires
import io.micronaut.context.env.Environment
import jakarta.inject.Inject
import yucatalks.micronaut.models.Book
import yucatalks.micronaut.services.AnalyticsService

@Requires(notEnv = [Environment.TEST])
@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class AnalyticsListener {
    @Inject
    lateinit var analyticsService: AnalyticsService

    @Topic("analytics")
    fun updateAnalytics(book: Book) = analyticsService.updateBookAnalytics(book)
}