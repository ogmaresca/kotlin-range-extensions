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
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit
import kotlin.math.max
import kotlin.random.Random
import kotlin.random.asJavaRandom
import kotlin.random.nextLong

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @param unit The smallest time unit for the random value to be rounded down to.
 * @throws [IllegalStateException] If the range is empty.
 */
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

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [IllegalStateException] If the range is empty.
 */
fun Random.nextBigInteger(range: ClosedRange<BigInteger>): BigInteger {
	if (range.start != BigInteger.ZERO) {
		return nextBigInteger(range.mapRange { it - range.start }) + range.start
	}

	check(!range.isEmpty()) { "Cannot get random in empty range: $range" }

	val random = BigInteger(range.endInclusive.bitLength(), asJavaRandom())

	return random % (range.endInclusive + BigInteger.ONE)
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [IllegalStateException] If the range is empty.
 */
fun Random.nextBigDecimal(range: ClosedRange<BigDecimal>): BigDecimal {
	check(!range.isEmpty()) { "Cannot get random in empty range: $range" }

	val startScale = max(range.start.stripTrailingZeros().scale(), 0)
	val endScale = max(range.endInclusive.stripTrailingZeros().scale(), 0)

	val pow = BigInteger.TEN.pow(max(startScale, endScale))

	val startInt = range.start.movePointRight(startScale).toBigInteger() * pow
	val endInt = range.endInclusive.movePointRight(endScale).toBigInteger() * pow

	return (startInt..endInt).random(this).toBigDecimal() / pow.toBigDecimal()
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [IllegalStateException] If the range is empty.
 */
@JvmName("randomBigInteger")
fun ClosedRange<BigInteger>.random(random: Random = Random.Default): BigInteger = random.nextBigInteger(this)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullBigInteger")
fun ClosedRange<BigInteger>.randomOrNull(random: Random = Random.Default): BigInteger? =
	takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [IllegalStateException] If the range is empty.
 */
@JvmName("randomBigDecimal")
fun ClosedRange<BigDecimal>.random(random: Random = Random.Default): BigDecimal = random.nextBigDecimal(this)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullBigDecimal")
fun ClosedRange<BigDecimal>.randomOrNull(random: Random = Random.Default): BigDecimal? =
	takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [IllegalStateException] If the range is empty.
 */
@JvmName("randomDuration")
fun ClosedRange<Duration>.random(random: Random = Random.Default): Duration = random.nextDuration(this)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullDuration")
fun ClosedRange<Duration>.randomOrNull(random: Random = Random.Default): Duration? =
	takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [IllegalStateException] If the range is empty.
 */
@JvmName("randomDuration")
fun ClosedRange<Duration>.random(unit: TemporalUnit, random: Random = Random.Default): Duration =
	random.nextDuration(this, unit)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullDuration")
fun ClosedRange<Duration>.randomOrNull(unit: TemporalUnit, random: Random = Random.Default): Duration? =
	takeUnless { it.isEmpty() }?.random(unit, random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [IllegalStateException] If the range is empty.
 */
@JvmName("randomInstant")
fun ClosedRange<Instant>.random(random: Random = Random.Default): Instant {
	check(!isEmpty()) { "Cannot get random in empty range: $this" }
	val diff = endInclusive.toBigIntegerEpochNanos() - start.toBigIntegerEpochNanos()
	val durationRange = Duration.ZERO..durationOfNanos(diff)
	return start + durationRange.random(random)
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullInstant")
fun ClosedRange<Instant>.randomOrNull(random: Random = Random.Default): Instant? =
	takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [IllegalStateException] If the range is empty.
 */
@JvmName("randomLocalDate")
fun ClosedRange<LocalDate>.random(random: Random = Random.Default): LocalDate {
	check(!isEmpty()) { "Cannot get random in empty range: $this" }
	return LocalDate.ofEpochDay((start.toEpochDay()..endInclusive.toEpochDay()).random(random))
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullLocalDate")
fun ClosedRange<LocalDate>.randomOrNull(random: Random = Random.Default): LocalDate? =
	takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [IllegalStateException] If the range is empty.
 */
@JvmName("randomLocalDateTime")
fun ClosedRange<LocalDateTime>.random(random: Random = Random.Default): LocalDateTime {
	check(!isEmpty()) { "Cannot get random in empty range: $this" }
	return mapToInstant { it.toInstant(ZoneOffset.UTC) }.random(random).atOffset(ZoneOffset.UTC).toLocalDateTime()
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullLocalDateTime")
fun ClosedRange<LocalDateTime>.randomOrNull(random: Random = Random.Default): LocalDateTime? =
	takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [IllegalStateException] If the range is empty.
 */
@JvmName("randomLocalTime")
fun ClosedRange<LocalTime>.random(random: Random = Random.Default): LocalTime {
	check(!isEmpty()) { "Cannot get random in empty range: $this" }
	return LocalTime.ofNanoOfDay((start.toNanoOfDay()..endInclusive.toNanoOfDay()).random(random))
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullLocalTime")
fun ClosedRange<LocalTime>.randomOrNull(random: Random = Random.Default): LocalTime? =
	takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [IllegalStateException] If the range is empty.
 */
@JvmName("randomMonthDay")
fun ClosedRange<MonthDay>.random(random: Random = Random.Default): MonthDay {
	check(!isEmpty()) { "Cannot get random in empty range: $this" }

	return mapToLocalDate { LocalDate.of(1970, it.month, it.dayOfMonth) }
		.random(random)
		.let { MonthDay.of(it.month, it.dayOfMonth) }
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullMonthDay")
fun ClosedRange<MonthDay>.randomOrNull(random: Random = Random.Default): MonthDay? =
	takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 *
 * If the [OffsetDateTime.offset] is different between the [ClosedRange.start] and [ClosedRange.endInclusive],
 * then the random value will be in the offset of the [ClosedRange.start].step
 * @throws [IllegalStateException] If the range is empty.
 */
@JvmName("randomOffsetDateTime")
fun ClosedRange<OffsetDateTime>.random(random: Random = Random.Default): OffsetDateTime {
	check(!isEmpty()) { "Cannot get random in empty range: $this" }
	return mapToInstant { it.toInstant() }.random(random).atOffset(start.offset)
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 *
 * If the [OffsetDateTime.offset] is different between the [ClosedRange.start] and [ClosedRange.endInclusive],
 * then the random value will be in the offset of the [ClosedRange.start].
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullOffsetDateTime")
fun ClosedRange<OffsetDateTime>.randomOrNull(random: Random = Random.Default): OffsetDateTime? =
	takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [IllegalStateException] If the range is empty.
 */
@JvmName("randomYearMonth")
fun ClosedRange<YearMonth>.random(random: Random = Random.Default): YearMonth {
	check(!isEmpty()) { "Cannot get random in empty range: $this" }

	return mapToLongRange { (it.year * 12L) + it.monthValue }.random(random).let {
		YearMonth.of(
			(it / 12L).toInt(),
			when (val month = (it % 12L).toInt()) {
				0 -> 12
				else -> month
			},
		)
	}
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullYearMonth")
fun ClosedRange<YearMonth>.randomOrNull(random: Random = Random.Default): YearMonth? =
	takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [IllegalStateException] If the range is empty.
 */
@JvmName("randomYear")
fun ClosedRange<Year>.random(random: Random = Random.Default): Year {
	check(!isEmpty()) { "Cannot get random in empty range: $this" }
	return Year.of(mapToIntRange { it.value }.random(random))
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullYear")
fun ClosedRange<Year>.randomOrNull(random: Random = Random.Default): Year? =
	takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 *
 * If the [ZonedDateTime.zone] is different between the [ClosedRange.start] and [ClosedRange.endInclusive],
 * then the random value will be in the timezone of the [ClosedRange.start].
 * @throws [IllegalStateException] If the range is empty.
 */
@JvmName("randomZonedDateTime")
fun ClosedRange<ZonedDateTime>.random(random: Random = Random.Default): ZonedDateTime {
	check(!isEmpty()) { "Cannot get random in empty range: $this" }
	return mapToInstant { it.toInstant() }.random(random).atZone(start.zone)
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 *
 * If the [ZonedDateTime.zone] is different between the [ClosedRange.start] and [ClosedRange.endInclusive],
 * then the random value will be in the timezone of the [ClosedRange.start].
 */
@JvmName("randomOrNullZonedDateTime")
fun ClosedRange<ZonedDateTime>.randomOrNull(random: Random = Random.Default): ZonedDateTime? =
	takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [IllegalStateException] If the range is empty.
 */
@JvmName("randomZoneOffset")
fun ClosedRange<ZoneOffset>.random(random: Random = Random.Default): ZoneOffset {
	check(!isEmpty()) { "Cannot get random in empty range: $this" }
	return ZoneOffset.ofTotalSeconds(mapToIntRange { it.totalSeconds }.random(random))
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullZoneOffset")
fun ClosedRange<ZoneOffset>.randomOrNull(random: Random = Random.Default): ZoneOffset? =
	takeUnless { it.isEmpty() }?.random(random)
