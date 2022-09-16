package com.ogm.kotlin.range.extensions

import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoField
import java.time.temporal.TemporalUnit

open class InstantProgression protected constructor(
	start: Instant,
	endInclusive: Instant,
	step: Duration,
) : AbstractProgression<Instant, Duration>(start, endInclusive, step) {
	override fun valuePlusStep(left: Instant, right: Duration): Instant = left + right

	override fun valueMinus(left: Instant, right: Instant): Instant = left - right

	override fun valueMinusStep(left: Instant, right: Duration): Instant = left - right

	override fun stepMinus(left: Duration, right: Duration): Duration = left - right

	override fun valueModuloStep(left: Instant, right: Duration): Duration {
		val second = left.toEpochMilli() % right.seconds
		val nano = left.getLong(ChronoField.NANO_OF_SECOND) % right.nano
		return Duration.ofSeconds(second).plusNanos(nano)
	}

	override fun zeroValue(): Instant = Instant.ofEpochMilli(0)
	override fun zeroStep(): Duration = Duration.ZERO

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
