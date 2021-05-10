package nowowiejski.m.myapp.core.utils

import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

object TimeUtils {
    private const val DATE_FORMAT = "yyyy/MM/dd"

    fun dateTimeString(startTime: String): String {
        return DateTimeFormatter.ofPattern(DATE_FORMAT).format(LocalDate.parse(startTime))
    }
}
