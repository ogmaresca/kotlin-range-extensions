package com.ogm.kotlin.range.extensions

import java.time.Duration
import java.time.LocalTime
import java.time.temporal.TemporalUnit

class LocalTimeProgression private constructor(start: LocalTime, endInclusive: LocalTime, step: Duration) :
	AbstractToLongProgression<LocalTime, Duration>(
		start,
		endInclusive,
		step,
		step.toNanos(),
		Duration.ZERO,
		LocalTimeToLongConverter,
	) {
	private object LocalTimeToLongConverter : AbstractToLongProgressionConverter<LocalTime> {
		override fun toLong(value: LocalTime): Long = value.toNanoOfDay()

		override fun toValue(value: Long): LocalTime = LocalTime.ofNanoOfDay(value)
	}

	companion object {
		fun fromClosedRange(rangeStart: LocalTime, rangeEnd: LocalTime, step: Duration) = LocalTimeProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(rangeStart: LocalTime, rangeEnd: LocalTime, stepSize: Long, stepUnit: TemporalUnit) = fromClosedRange(rangeStart, rangeEnd, Duration.of(stepSize, stepUnit))

		fun fromClosedRange(rangeStart: LocalTime, rangeEnd: LocalTime, stepUnit: TemporalUnit) = fromClosedRange(rangeStart, rangeEnd, 1L, stepUnit)

		fun fromClosedRange(range: ClosedRange<LocalTime>, step: Duration) = fromClosedRange(range.start, range.endInclusive, step)

		fun fromClosedRange(range: ClosedRange<LocalTime>, stepSize: Long, stepUnit: TemporalUnit) = fromClosedRange(range.start, range.endInclusive, stepSize, stepUnit)

		fun fromClosedRange(range: ClosedRange<LocalTime>, stepUnit: TemporalUnit) = fromClosedRange(range.start, range.endInclusive, stepUnit)
	}
}
