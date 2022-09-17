package com.ogm.kotlin.range.extensions

import java.time.Duration
import java.time.temporal.TemporalUnit

class DurationProgression private constructor(
	start: Duration,
	endInclusive: Duration,
	step: Duration,
) : AbstractToLongProgression<Duration, Duration>(
	start,
	endInclusive,
	step,
	step.toNanos(),
	Duration.ZERO,
	DurationToLongConverter,
) {
	private object DurationToLongConverter : AbstractToLongProgressionConverter<Duration> {
		override fun toLong(value: Duration): Long = value.toNanos()

		override fun toValue(value: Long): Duration = Duration.ofNanos(value)
	}

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
