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
 * Reverse this [ClosedRange]
 */
@JvmName("reversedBigInteger")
fun ClosedRange<BigInteger>.reversed(): BigIntegerRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedBigDecimal")
fun ClosedRange<BigDecimal>.reversed(): BigDecimalRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedDuration")
fun ClosedRange<Duration>.reversed(): DurationRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedInstant")
fun ClosedRange<Instant>.reversed(): InstantRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedLocalDate")
fun ClosedRange<LocalDate>.reversed(): LocalDateRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedLocalDateTime")
fun ClosedRange<LocalDateTime>.reversed(): LocalDateTimeRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedLocalTime")
fun ClosedRange<LocalTime>.reversed(): LocalTimeRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedMonthDay")
fun ClosedRange<MonthDay>.reversed(): MonthDayRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedOffsetDateTime")
fun ClosedRange<OffsetDateTime>.reversed(): OffsetDateTimeRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedYearMonth")
fun ClosedRange<YearMonth>.reversed(): YearMonthRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedYear")
fun ClosedRange<Year>.reversed(): YearRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedZonedDateTime")
fun ClosedRange<ZonedDateTime>.reversed(): ZonedDateTimeRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedZoneOffset")
fun ClosedRange<ZoneOffset>.reversed(): ZoneOffsetRange = endInclusive..start

// TODO support for every custom range
