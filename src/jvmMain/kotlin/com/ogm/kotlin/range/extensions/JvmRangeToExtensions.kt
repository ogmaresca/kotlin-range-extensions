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

fun ClosedRange<BigInteger>.toBigIntegerRange(): BigIntegerRange = when (this) {
	is BigIntegerRange -> this
	else -> start..endInclusive
}

fun ClosedRange<BigDecimal>.toBigDecimalRange(): BigDecimalRange = when (this) {
	is BigDecimalRange -> this
	else -> start..endInclusive
}

fun ClosedRange<Duration>.toDurationRange(): DurationRange = when (this) {
	is DurationRange -> this
	else -> start..endInclusive
}

fun ClosedRange<Instant>.toInstantRange(): InstantRange = when (this) {
	is InstantRange -> this
	else -> start..endInclusive
}

fun ClosedRange<LocalDate>.toLocalDateRange(): LocalDateRange = when (this) {
	is LocalDateRange -> this
	else -> start..endInclusive
}

fun ClosedRange<LocalDateTime>.toLocalDateTimeRange(): LocalDateTimeRange = when (this) {
	is LocalDateTimeRange -> this
	else -> start..endInclusive
}

fun ClosedRange<LocalTime>.toLocalTimeRange(): LocalTimeRange = when (this) {
	is LocalTimeRange -> this
	else -> start..endInclusive
}

fun ClosedRange<OffsetDateTime>.toOffsetDateTimeRange(): OffsetDateTimeRange = when (this) {
	is OffsetDateTimeRange -> this
	else -> start..endInclusive
}

fun ClosedRange<ZonedDateTime>.toZonedDateTimeRange(): ZonedDateTimeRange = when (this) {
	is ZonedDateTimeRange -> this
	else -> start..endInclusive
}

// TODO support for every custom range
