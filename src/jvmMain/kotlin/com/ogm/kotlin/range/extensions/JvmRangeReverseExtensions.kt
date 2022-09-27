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

@JvmName("reversedBigInteger")
fun ClosedRange<BigInteger>.reversed(): BigIntegerRange = endInclusive..start

@JvmName("reversedBigDecimal")
fun ClosedRange<BigDecimal>.reversed(): BigDecimalRange = endInclusive..start

@JvmName("reversedDuration")
fun ClosedRange<Duration>.reversed(): DurationRange = endInclusive..start

@JvmName("reversedInstant")
fun ClosedRange<Instant>.reversed(): InstantRange = endInclusive..start

@JvmName("reversedLocalDate")
fun ClosedRange<LocalDate>.reversed(): LocalDateRange = endInclusive..start

@JvmName("reversedLocalDateTime")
fun ClosedRange<LocalDateTime>.reversed(): LocalDateTimeRange = endInclusive..start

@JvmName("reversedLocalTime")
fun ClosedRange<LocalTime>.reversed(): LocalTimeRange = endInclusive..start

@JvmName("reversedOffsetDateTime")
fun ClosedRange<OffsetDateTime>.reversed(): OffsetDateTimeRange = endInclusive..start

@JvmName("reversedZonedDateTime")
fun ClosedRange<ZonedDateTime>.reversed(): ZonedDateTimeRange = endInclusive..start

// TODO support for every custom range
