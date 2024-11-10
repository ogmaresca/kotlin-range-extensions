package com.ogm.kotlin.range.extensions

import java.math.BigInteger
import java.time.Duration
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.temporal.TemporalUnit

class OffsetDateTimeProgression private constructor(start: OffsetDateTime, endInclusive: OffsetDateTime, step: Duration) :
	AbstractToBigIntegerProgression<OffsetDateTime, Duration>(
		start,
		endInclusive,
		step,
		BigInteger.valueOf(step.toNanos()),
		Duration.ZERO,
		OffsetDateTimeToBigIntegerConverter(start.offset),
	) {
	private class OffsetDateTimeToBigIntegerConverter(private val offset: ZoneOffset) : AbstractToBigIntegerProgressionConverter<OffsetDateTime> {
		override fun toBigInteger(value: OffsetDateTime): BigInteger = value.toInstant().toBigIntegerEpochNanos()

		override fun toValue(value: BigInteger): OffsetDateTime = instantOfEpochNano(value).atOffset(offset)
	}

	companion object {
		fun fromClosedRange(rangeStart: OffsetDateTime, rangeEnd: OffsetDateTime, step: Duration) = OffsetDateTimeProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(rangeStart: OffsetDateTime, rangeEnd: OffsetDateTime, stepSize: Long, stepUnit: TemporalUnit) = fromClosedRange(rangeStart, rangeEnd, Duration.of(stepSize, stepUnit))

		fun fromClosedRange(rangeStart: OffsetDateTime, rangeEnd: OffsetDateTime, stepUnit: TemporalUnit) = fromClosedRange(rangeStart, rangeEnd, 1L, stepUnit)

		fun fromClosedRange(range: ClosedRange<OffsetDateTime>, step: Duration) = fromClosedRange(range.start, range.endInclusive, step)

		fun fromClosedRange(range: ClosedRange<OffsetDateTime>, stepSize: Long, stepUnit: TemporalUnit) = fromClosedRange(range.start, range.endInclusive, stepSize, stepUnit)

		fun fromClosedRange(range: ClosedRange<OffsetDateTime>, stepUnit: TemporalUnit) = fromClosedRange(range.start, range.endInclusive, stepUnit)
	}
}
