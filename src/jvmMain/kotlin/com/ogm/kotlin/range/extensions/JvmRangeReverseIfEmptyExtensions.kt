package com.ogm.kotlin.range.extensions

import java.math.BigDecimal
import java.math.BigInteger
import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.MonthDay
import java.time.OffsetDateTime
import java.time.Year
import java.time.YearMonth
import java.time.ZoneOffset
import java.time.ZonedDateTime

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyBigInteger")
fun ClosedRange<BigInteger>.reversedIfEmpty(): BigIntegerRange = if (isEmpty()) {
	reversed()
} else {
	toBigIntegerRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyBigDecimal")
fun ClosedRange<BigDecimal>.reversedIfEmpty(): BigDecimalRange = if (isEmpty()) {
	reversed()
} else {
	toBigDecimalRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyDuration")
fun ClosedRange<Duration>.reversedIfEmpty(): DurationRange = if (isEmpty()) {
	reversed()
} else {
	toDurationRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyInstant")
fun ClosedRange<Instant>.reversedIfEmpty(): InstantRange = if (isEmpty()) {
	reversed()
} else {
	toInstantRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyLocalDate")
fun ClosedRange<LocalDate>.reversedIfEmpty(): LocalDateRange = if (isEmpty()) {
	reversed()
} else {
	toLocalDateRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyLocalDateTime")
fun ClosedRange<LocalDateTime>.reversedIfEmpty(): LocalDateTimeRange = if (isEmpty()) {
	reversed()
} else {
	toLocalDateTimeRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyLocalTime")
fun ClosedRange<LocalTime>.reversedIfEmpty(): LocalTimeRange = if (isEmpty()) {
	reversed()
} else {
	toLocalTimeRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyMonthDay")
fun ClosedRange<MonthDay>.reversedIfEmpty(): MonthDayRange = if (isEmpty()) {
	reversed()
} else {
	toMonthDayRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyOffsetDateTime")
fun ClosedRange<OffsetDateTime>.reversedIfEmpty(): OffsetDateTimeRange = if (isEmpty()) {
	reversed()
} else {
	toOffsetDateTimeRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyYearMonth")
fun ClosedRange<YearMonth>.reversedIfEmpty(): YearMonthRange = if (isEmpty()) {
	reversed()
} else {
	toYearMonthRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyYear")
fun ClosedRange<Year>.reversedIfEmpty(): YearRange = if (isEmpty()) {
	reversed()
} else {
	toYearRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyZonedDateTime")
fun ClosedRange<ZonedDateTime>.reversedIfEmpty(): ZonedDateTimeRange = if (isEmpty()) {
	reversed()
} else {
	toZonedDateTimeRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyZoneOffset")
fun ClosedRange<ZoneOffset>.reversedIfEmpty(): ZoneOffsetRange = if (isEmpty()) {
	reversed()
} else {
	toZoneOffsetRange()
}

// TODO support for every custom range
