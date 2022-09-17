package com.ogm.kotlin.range.extensions

import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.MonthDay
import java.time.OffsetDateTime
import java.time.Period
import java.time.Year
import java.time.YearMonth
import java.time.ZoneOffset
import java.time.ZonedDateTime

object JvmTODO {
	val localTime = LocalTime.MIN..LocalTime.MAX
	val localDateTime = LocalDateTime.MIN..LocalDateTime.MAX
	// If endInclusive.offset != start.offset, then convert offset to start zone
	val offsetDateTime = OffsetDateTime.MIN..OffsetDateTime.MAX
	val zoneOffset = ZoneOffset.MIN..ZoneOffset.MAX
	// If endInclusive.zone != start.zone, then convert end to start zone
	val zonedDateTime = ZonedDateTime.now()..ZonedDateTime.now()
	val period = Period.ZERO..Period.ZERO
	val monthDay = MonthDay.now()..MonthDay.now()
	val year = Year.MIN_VALUE..Year.MAX_VALUE
	val yearMonth = YearMonth.now()..YearMonth.now()
	val bigDecimal = BigDecimal.ZERO..BigDecimal.TEN
}
