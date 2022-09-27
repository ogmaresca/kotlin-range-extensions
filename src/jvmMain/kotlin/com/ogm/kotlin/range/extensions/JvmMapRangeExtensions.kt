package com.ogm.kotlin.range.extensions

import java.math.BigDecimal
import java.math.BigInteger
import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZonedDateTime

fun <T : Comparable<T>> ClosedRange<T>.mapToBigInteger(block: (T) -> BigInteger): BigIntegerRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToBigDecimal(block: (T) -> BigDecimal): BigDecimalRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToDuration(block: (T) -> Duration): DurationRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToInstant(block: (T) -> Instant): InstantRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToLocalDate(block: (T) -> LocalDate): LocalDateRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToLocalDateTime(block: (T) -> LocalDateTime): LocalDateTimeRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToLocalTime(block: (T) -> LocalTime): LocalTimeRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToOffsetDateTime(block: (T) -> OffsetDateTime): OffsetDateTimeRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToZonedDateTime(block: (T) -> ZonedDateTime): ZonedDateTimeRange =
	block(start)..block(endInclusive)

// TODO support for every custom range
