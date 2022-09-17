package com.ogm.kotlin.range.extensions

import java.math.BigInteger
import java.time.Duration
import java.time.Instant
import java.time.temporal.TemporalUnit

class InstantProgression private constructor(
	start: Instant,
	endInclusive: Instant,
	step: Duration,
) : AbstractToBigIntegerProgression<Instant, Duration>(
	start,
	endInclusive,
	step,
	BigInteger.valueOf(step.toNanos()),
	Duration.ZERO,
	InstantToBigIntegerConverter,
) {
	private object InstantToBigIntegerConverter : AbstractToBigIntegerProgressionConverter<Instant> {
		override fun toBigInteger(value: Instant): BigInteger = value.toBigIntegerEpochNanos()

		override fun toValue(value: BigInteger): Instant = instantOfEpochNano(value)
	}

	companion object {
		fun fromClosedRange(rangeStart: Instant, rangeEnd: Instant, step: Duration) =
			InstantProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(rangeStart: Instant, rangeEnd: Instant, stepSize: Long, stepUnit: TemporalUnit) =
			fromClosedRange(rangeStart, rangeEnd, Duration.of(stepSize, stepUnit))

		fun fromClosedRange(rangeStart: Instant, rangeEnd: Instant, stepUnit: TemporalUnit) =
			fromClosedRange(rangeStart, rangeEnd, 1L, stepUnit)

		fun fromClosedRange(range: ClosedRange<Instant>, step: Duration) =
			fromClosedRange(range.start, range.endInclusive, step)

		fun fromClosedRange(range: ClosedRange<Instant>, stepSize: Long, stepUnit: TemporalUnit) =
			fromClosedRange(range.start, range.endInclusive, stepSize, stepUnit)

		fun fromClosedRange(range: ClosedRange<Instant>, stepUnit: TemporalUnit) =
			fromClosedRange(range.start, range.endInclusive, stepUnit)
	}
}
