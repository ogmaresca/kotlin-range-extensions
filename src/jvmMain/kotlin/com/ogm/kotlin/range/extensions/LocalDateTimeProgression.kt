package com.ogm.kotlin.range.extensions

import java.math.BigInteger
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.temporal.TemporalUnit

class LocalDateTimeProgression private constructor(start: LocalDateTime, endInclusive: LocalDateTime, step: Duration) :
	AbstractToBigIntegerProgression<LocalDateTime, Duration>(
		start,
		endInclusive,
		step,
		BigInteger.valueOf(step.toNanos()),
		Duration.ZERO,
		LocalDateTimeToBigIntegerConverter,
	) {
	private object LocalDateTimeToBigIntegerConverter : AbstractToBigIntegerProgressionConverter<LocalDateTime> {
		override fun toBigInteger(value: LocalDateTime): BigInteger = value.toInstant(ZoneOffset.UTC).toBigIntegerEpochNanos()

		override fun toValue(value: BigInteger): LocalDateTime = instantOfEpochNano(value).atOffset(ZoneOffset.UTC).toLocalDateTime()
	}

	companion object {
		fun fromClosedRange(rangeStart: LocalDateTime, rangeEnd: LocalDateTime, step: Duration) = LocalDateTimeProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(rangeStart: LocalDateTime, rangeEnd: LocalDateTime, stepSize: Long, stepUnit: TemporalUnit) = fromClosedRange(rangeStart, rangeEnd, Duration.of(stepSize, stepUnit))

		fun fromClosedRange(rangeStart: LocalDateTime, rangeEnd: LocalDateTime, stepUnit: TemporalUnit) = fromClosedRange(rangeStart, rangeEnd, 1L, stepUnit)

		fun fromClosedRange(range: ClosedRange<LocalDateTime>, step: Duration) = fromClosedRange(range.start, range.endInclusive, step)

		fun fromClosedRange(range: ClosedRange<LocalDateTime>, stepSize: Long, stepUnit: TemporalUnit) = fromClosedRange(range.start, range.endInclusive, stepSize, stepUnit)

		fun fromClosedRange(range: ClosedRange<LocalDateTime>, stepUnit: TemporalUnit) = fromClosedRange(range.start, range.endInclusive, stepUnit)
	}
}
