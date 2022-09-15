package com.ogm.kotlin.range.extensions

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

@JvmName("randomDuration")
fun ClosedRange<Duration>.random(random: Random = Random.Default): Duration = random.nextDuration(this)

@JvmName("randomOrNullDuration")
fun ClosedRange<Duration>.randomOrNull(random: Random = Random.Default): Duration? =
	takeUnless { it.isEmpty() }?.random(random)

@JvmName("randomInstant")
fun ClosedRange<Instant>.random(random: Random = Random.Default): Instant {
	val diff = differenceBetween(start, endInclusive)
	val random = (Duration.ZERO..diff).random(random)
	return start + random
}

@JvmName("randomOrNullInstant")
fun ClosedRange<Instant>.randomOrNull(random: Random = Random.Default): Instant? =
	takeUnless { it.isEmpty() }?.random(random)

@JvmName("randomInstant")
fun ClosedRange<LocalDate>.random(random: Random = Random.Default): LocalDate {
	val random = (start.toEpochDay()..endInclusive.toEpochDay()).random(random)
	return LocalDate.ofEpochDay(random)
}

@JvmName("randomOrNullInstant")
fun ClosedRange<LocalDate>.randomOrNull(random: Random = Random.Default): LocalDate? =
	takeUnless { it.isEmpty() }?.random(random)

// TODO support for every custom range
