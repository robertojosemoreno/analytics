package yucatalks.micronaut.controllers

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject
import yucatalks.micronaut.models.BookAnalytics
import yucatalks.micronaut.services.AnalyticsService

@Controller("/analytics")
class AnalyticsController {
    @Inject
    lateinit var analyticsService: AnalyticsService

    @Get
    fun listAnalytics(): List<BookAnalytics> = analyticsService.listAnalytics()

}