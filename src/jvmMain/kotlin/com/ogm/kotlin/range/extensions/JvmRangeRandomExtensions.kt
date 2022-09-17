package com.ogm.kotlin.range.extensions

import java.math.BigInteger
import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import kotlin.random.Random
import kotlin.random.nextLong

fun Random.nextDuration(range: ClosedRange<Duration>): Duration {
	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	val nano = nextLong(range.mapToLongRange { it.toNanos() })
	return Duration.ofNanos(nano)
}

fun Random.nextBigInteger(range: ClosedRange<BigInteger>): BigInteger {
	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }

	// TODO support values > Long.MAX_VALUE
	val longRange = 0L..(range.endInclusive % BIG_INTEGER_MAX_LONG_VALUE).toLong()
	return BigInteger.valueOf(nextLong(longRange))
}

@JvmName("randomBigInteger")
fun ClosedRange<BigInteger>.random(random: Random = Random.Default): BigInteger = random.nextBigInteger(this)

@JvmName("randomOrNullBigInteger")
fun ClosedRange<BigInteger>.randomOrNull(random: Random = Random.Default): BigInteger? =
	takeUnless { it.isEmpty() }?.random(random)

@JvmName("randomDuration")
fun ClosedRange<Duration>.random(random: Random = Random.Default): Duration = random.nextDuration(this)

@JvmName("randomOrNullDuration")
fun ClosedRange<Duration>.randomOrNull(random: Random = Random.Default): Duration? =
	takeUnless { it.isEmpty() }?.random(random)

@JvmName("randomInstant")
fun ClosedRange<Instant>.random(random: Random = Random.Default): Instant {
	val diff = endInclusive.toBigIntegerEpochNanos() - start.toBigIntegerEpochNanos()
	val durationRange = Duration.ZERO..durationOfNanos(diff)
	return start + durationRange.random(random)
}

@JvmName("randomOrNullInstant")
fun ClosedRange<Instant>.randomOrNull(random: Random = Random.Default): Instant? =
	takeUnless { it.isEmpty() }?.random(random)

@JvmName("randomLocalDate")
fun ClosedRange<LocalDate>.random(random: Random = Random.Default): LocalDate =
	LocalDate.ofEpochDay((start.toEpochDay()..endInclusive.toEpochDay()).random(random))

@JvmName("randomOrNullLocalDate")
fun ClosedRange<LocalDate>.randomOrNull(random: Random = Random.Default): LocalDate? =
	takeUnless { it.isEmpty() }?.random(random)

// TODO support for every custom range
