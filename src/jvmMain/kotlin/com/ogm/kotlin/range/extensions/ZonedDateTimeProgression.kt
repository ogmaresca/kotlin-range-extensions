package com.ogm.kotlin.range.extensions

import java.math.BigInteger
import java.time.Duration
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.temporal.TemporalUnit

class ZonedDateTimeProgression private constructor(
	start: ZonedDateTime,
	endInclusive: ZonedDateTime,
	step: Duration,
) : AbstractToBigIntegerProgression<ZonedDateTime, Duration>(
	start,
	endInclusive,
	step,
	BigInteger.valueOf(step.toNanos()),
	Duration.ZERO,
	ZonedDateTimeToBigIntegerConverter(start.zone),
) {
	private class ZonedDateTimeToBigIntegerConverter(
		private val zone: ZoneId,
	) : AbstractToBigIntegerProgressionConverter<ZonedDateTime> {
		override fun toBigInteger(value: ZonedDateTime): BigInteger = value.toInstant().toBigIntegerEpochNanos()

		override fun toValue(value: BigInteger): ZonedDateTime = instantOfEpochNano(value).atZone(zone)
	}

	companion object {
		fun fromClosedRange(rangeStart: ZonedDateTime, rangeEnd: ZonedDateTime, step: Duration) =
			ZonedDateTimeProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(rangeStart: ZonedDateTime, rangeEnd: ZonedDateTime, stepSize: Long, stepUnit: TemporalUnit) =
			fromClosedRange(rangeStart, rangeEnd, Duration.of(stepSize, stepUnit))

		fun fromClosedRange(rangeStart: ZonedDateTime, rangeEnd: ZonedDateTime, stepUnit: TemporalUnit) =
			fromClosedRange(rangeStart, rangeEnd, 1L, stepUnit)

		fun fromClosedRange(range: ClosedRange<ZonedDateTime>, step: Duration) =
			fromClosedRange(range.start, range.endInclusive, step)

		fun fromClosedRange(range: ClosedRange<ZonedDateTime>, stepSize: Long, stepUnit: TemporalUnit) =
			fromClosedRange(range.start, range.endInclusive, stepSize, stepUnit)

		fun fromClosedRange(range: ClosedRange<ZonedDateTime>, stepUnit: TemporalUnit) =
			fromClosedRange(range.start, range.endInclusive, stepUnit)
	}
}
