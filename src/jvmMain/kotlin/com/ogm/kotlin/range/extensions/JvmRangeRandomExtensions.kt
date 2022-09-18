package com.ogm.kotlin.range.extensions

import java.math.BigInteger
import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit
import kotlin.random.Random
import kotlin.random.nextLong

fun Random.nextDuration(range: ClosedRange<Duration>, unit: TemporalUnit = ChronoUnit.NANOS): Duration {
	check(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	val nanoRange = range.mapToLongRange { it.toNanos() }
	return when (unit) {
		ChronoUnit.NANOS -> Duration.ofNanos(nextLong(nanoRange))
		else -> {
			val nanosPerUnit = NANOS_PER_UNIT[unit]
			requireNotNull(nanosPerUnit) { "Unsupported TemporalUnit $unit" }

			val startUnitModulo = nanoRange.first % nanosPerUnit

			if (range.start == range.endInclusive) {
				require(startUnitModulo == 0L)
				return range.start
			}

			val startInUnit = when (startUnitModulo) {
				0L -> nanoRange.first
				else -> nanoRange.first + (nanosPerUnit - startUnitModulo)
			} / nanosPerUnit

			val endInUnit = nanoRange.last + (nanosPerUnit - (nanoRange.last % nanosPerUnit))

			Duration.of(nextLong(startInUnit..endInUnit), unit)
		}
	}
}

fun Random.nextBigInteger(range: ClosedRange<BigInteger>): BigInteger {
	check(!range.isEmpty()) { "Cannot get random in empty range: $range" }

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

@JvmName("randomDuration")
fun ClosedRange<Duration>.random(unit: TemporalUnit, random: Random = Random.Default): Duration =
	random.nextDuration(this, unit)

@JvmName("randomOrNullDuration")
fun ClosedRange<Duration>.randomOrNull(unit: TemporalUnit, random: Random = Random.Default): Duration? =
	takeUnless { it.isEmpty() }?.random(unit, random)

@JvmName("randomInstant")
fun ClosedRange<Instant>.random(random: Random = Random.Default): Instant =
	random(ChronoUnit.NANOS, random)

@JvmName("randomOrNullInstant")
fun ClosedRange<Instant>.randomOrNull(random: Random = Random.Default): Instant? =
	takeUnless { it.isEmpty() }?.random(random)

@JvmName("randomInstant")
fun ClosedRange<Instant>.random(unit: ChronoUnit, random: Random = Random.Default): Instant {
	check(!isEmpty()) { "Cannot get random in empty range: $this" }
	val diff = endInclusive.toBigIntegerEpochNanos() - start.toBigIntegerEpochNanos()
	val durationRange = Duration.ZERO..durationOfNanos(diff)
	return start + durationRange.random(unit, random)
}

@JvmName("randomOrNullInstant")
fun ClosedRange<Instant>.randomOrNull(unit: ChronoUnit, random: Random = Random.Default): Instant? =
	takeUnless { it.isEmpty() }?.random(unit, random)

@JvmName("randomLocalDate")
fun ClosedRange<LocalDate>.random(random: Random = Random.Default): LocalDate {
	check(!isEmpty()) { "Cannot get random in empty range: $this" }
	return LocalDate.ofEpochDay((start.toEpochDay()..endInclusive.toEpochDay()).random(random))
}

@JvmName("randomOrNullLocalDate")
fun ClosedRange<LocalDate>.randomOrNull(random: Random = Random.Default): LocalDate? =
	takeUnless { it.isEmpty() }?.random(random)

// TODO support for every custom range
