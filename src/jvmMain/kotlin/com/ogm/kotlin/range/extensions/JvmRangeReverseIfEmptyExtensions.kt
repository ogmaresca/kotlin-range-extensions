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

@JvmName("reversedIfEmptyBigInteger")
fun ClosedRange<BigInteger>.reversedIfEmpty(): BigIntegerRange = if (isEmpty()) {
	reversed()
} else {
	toBigIntegerRange()
}

@JvmName("reversedIfEmptyBigDecimal")
fun ClosedRange<BigDecimal>.reversedIfEmpty(): BigDecimalRange = if (isEmpty()) {
	reversed()
} else {
	toBigDecimalRange()
}

@JvmName("reversedIfEmptyDuration")
fun ClosedRange<Duration>.reversedIfEmpty(): DurationRange = if (isEmpty()) {
	reversed()
} else {
	toDurationRange()
}

@JvmName("reversedIfEmptyInstant")
fun ClosedRange<Instant>.reversedIfEmpty(): InstantRange = if (isEmpty()) {
	reversed()
} else {
	toInstantRange()
}

@JvmName("reversedIfEmptyLocalDate")
fun ClosedRange<LocalDate>.reversedIfEmpty(): LocalDateRange = if (isEmpty()) {
	reversed()
} else {
	toLocalDateRange()
}

@JvmName("reversedIfEmptyLocalDateTime")
fun ClosedRange<LocalDateTime>.reversedIfEmpty(): LocalDateTimeRange = if (isEmpty()) {
	reversed()
} else {
	toLocalDateTimeRange()
}

@JvmName("reversedIfEmptyLocalTime")
fun ClosedRange<LocalTime>.reversedIfEmpty(): LocalTimeRange = if (isEmpty()) {
	reversed()
} else {
	toLocalTimeRange()
}

@JvmName("reversedIfEmptyOffsetDateTime")
fun ClosedRange<OffsetDateTime>.reversedIfEmpty(): OffsetDateTimeRange = if (isEmpty()) {
	reversed()
} else {
	toOffsetDateTimeRange()
}

@JvmName("reversedIfEmptyZonedDateTime")
fun ClosedRange<ZonedDateTime>.reversedIfEmpty(): ZonedDateTimeRange = if (isEmpty()) {
	reversed()
} else {
	toZonedDateTimeRange()
}

// TODO support for every custom range
