package com.ogm.kotlin.range.extensions

import java.math.BigInteger
import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoField

internal fun Instant.toBigIntegerEpochNanos(): BigInteger {
	val seconds = BigInteger.valueOf(epochSecond) * NANOS_PER_SECOND
	val nanos = getLong(ChronoField.NANO_OF_SECOND)
	return seconds + BigInteger.valueOf(nanos)
}

internal fun instantOfEpochNano(nanos: BigInteger): Instant = Instant
	.ofEpochSecond((nanos / NANOS_PER_SECOND).toLong())
	.plusNanos((nanos % NANOS_PER_SECOND).toLong())

internal fun durationOfNanos(nanos: BigInteger): Duration = Duration
	.ofSeconds((nanos / NANOS_PER_SECOND).toLong(), (nanos % NANOS_PER_SECOND).toLong())
