package com.ogm.kotlin.range.extensions

import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoField

internal infix fun Instant.diff(right: Instant): Duration {
	val seconds = right.epochSecond - epochSecond
	val nano = if (seconds == 0L) {
		right.getLong(ChronoField.NANO_OF_SECOND) - getLong(ChronoField.NANO_OF_SECOND)
	} else if (seconds < 0L) {
		NANOS_PER_SECOND - getLong(ChronoField.NANO_OF_SECOND)
	} else {
		right.getLong(ChronoField.NANO_OF_SECOND)
	}
	return Duration.ofSeconds(seconds).plusNanos(nano)
}

internal operator fun Instant.minus(right: Instant) = this - (right diff this)

internal fun differenceBetween(left: Instant, right: Instant): Duration {
	val seconds = right.epochSecond - left.epochSecond
	val nano = if (seconds == 0L) {
		right.getLong(ChronoField.NANO_OF_SECOND) - left.getLong(ChronoField.NANO_OF_SECOND)
	} else if (seconds < 0L) {
		NANOS_PER_SECOND - left.getLong(ChronoField.NANO_OF_SECOND)
	} else {
		right.getLong(ChronoField.NANO_OF_SECOND)
	}
	return Duration.ofSeconds(seconds).plusNanos(nano)
}
