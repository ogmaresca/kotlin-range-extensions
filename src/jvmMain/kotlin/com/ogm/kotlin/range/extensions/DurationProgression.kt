package com.ogm.kotlin.range.extensions

import java.time.Duration
import java.time.temporal.TemporalUnit

@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
open class DurationProgression protected constructor(
	start: Duration,
	endInclusive: Duration,
	step: Duration,
) : AbstractProgressionSameStepType<Duration>(start, endInclusive, step) {
	override fun Duration.plus(right: Duration): Duration = this@plus.plus(right)

	override fun Duration.minus(right: Duration): Duration = this@minus.minus(right)

	override fun Duration.rem(right: Duration): Duration = Duration.ofNanos(toNanos() % right.toNanos())

	override fun zero(): Duration = Duration.ZERO

	companion object {
		fun fromClosedRange(rangeStart: Duration, rangeEnd: Duration, step: Duration) =
			DurationProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(rangeStart: Duration, rangeEnd: Duration, stepSize: Long, stepUnit: TemporalUnit) =
			fromClosedRange(rangeStart, rangeEnd, Duration.of(stepSize, stepUnit))

		fun fromClosedRange(rangeStart: Duration, rangeEnd: Duration, stepUnit: TemporalUnit) =
			fromClosedRange(rangeStart, rangeEnd, 1L, stepUnit)

		fun fromClosedRange(range: ClosedRange<Duration>, step: Duration) =
			fromClosedRange(range.start, range.endInclusive, step)

		fun fromClosedRange(range: ClosedRange<Duration>, stepSize: Long, stepUnit: TemporalUnit) =
			fromClosedRange(range.start, range.endInclusive, stepSize, stepUnit)

		fun fromClosedRange(range: ClosedRange<Duration>, stepUnit: TemporalUnit) =
			fromClosedRange(range.start, range.endInclusive, stepUnit)
	}
}
