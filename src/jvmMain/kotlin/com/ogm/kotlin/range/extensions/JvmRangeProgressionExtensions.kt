package com.ogm.kotlin.range.extensions

import java.math.BigDecimal
import java.math.BigInteger
import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.Period
import java.time.ZonedDateTime
import java.time.temporal.TemporalUnit

@JvmName("stepBigInteger")
fun ClosedRange<BigInteger>.step(step: BigInteger) =
	BigIntegerProgression.fromClosedRange(this, step)

@JvmName("stepBigInteger")
fun ClosedRange<BigInteger>.step(step: Long) = step(BigInteger.valueOf(step))

@JvmName("stepBigDecimal")
fun ClosedRange<BigDecimal>.step(step: BigDecimal) =
	BigDecimalProgression.fromClosedRange(this, step)

@JvmName("stepDuration")
fun ClosedRange<Duration>.step(step: Duration) =
	DurationProgression.fromClosedRange(this, step)

@JvmName("stepDuration")
fun ClosedRange<Duration>.step(stepSize: Long, stepUnit: TemporalUnit) =
	DurationProgression.fromClosedRange(this, stepSize, stepUnit)

@JvmName("stepDuration")
fun ClosedRange<Duration>.step(stepUnit: TemporalUnit) =
	DurationProgression.fromClosedRange(this, stepUnit)

@JvmName("stepInstant")
fun ClosedRange<Instant>.step(step: Duration) =
	InstantProgression.fromClosedRange(this, step)

@JvmName("stepInstant")
fun ClosedRange<Instant>.step(stepSize: Long, stepUnit: TemporalUnit) =
	InstantProgression.fromClosedRange(this, stepSize, stepUnit)

@JvmName("stepInstant")
fun ClosedRange<Instant>.step(stepUnit: TemporalUnit) =
	InstantProgression.fromClosedRange(this, stepUnit)

@JvmName("stepLocalDate")
fun ClosedRange<LocalDate>.step(step: Period) =
	LocalDateProgression.fromClosedRange(this, step)

@JvmName("stepLocalDateTime")
fun ClosedRange<LocalDateTime>.step(step: Duration) =
	LocalDateTimeProgression.fromClosedRange(this, step)

@JvmName("stepLocalDateTime")
fun ClosedRange<LocalDateTime>.step(stepSize: Long, stepUnit: TemporalUnit) =
	LocalDateTimeProgression.fromClosedRange(this, stepSize, stepUnit)

@JvmName("stepLocalDateTime")
fun ClosedRange<LocalDateTime>.step(stepUnit: TemporalUnit) =
	LocalDateTimeProgression.fromClosedRange(this, stepUnit)

@JvmName("stepLocalTime")
fun ClosedRange<LocalTime>.step(step: Duration) =
	LocalTimeProgression.fromClosedRange(this, step)

@JvmName("stepLocalTime")
fun ClosedRange<LocalTime>.step(stepSize: Long, stepUnit: TemporalUnit) =
	LocalTimeProgression.fromClosedRange(this, stepSize, stepUnit)

@JvmName("stepLocalTime")
fun ClosedRange<LocalTime>.step(stepUnit: TemporalUnit) =
	LocalTimeProgression.fromClosedRange(this, stepUnit)

@JvmName("stepOffsetDateTime")
fun ClosedRange<OffsetDateTime>.step(step: Duration) =
	OffsetDateTimeProgression.fromClosedRange(this, step)

@JvmName("stepOffsetDateTime")
fun ClosedRange<OffsetDateTime>.step(stepSize: Long, stepUnit: TemporalUnit) =
	OffsetDateTimeProgression.fromClosedRange(this, stepSize, stepUnit)

@JvmName("stepOffsetDateTime")
fun ClosedRange<OffsetDateTime>.step(stepUnit: TemporalUnit) =
	OffsetDateTimeProgression.fromClosedRange(this, stepUnit)

@JvmName("stepZonedDateTime")
fun ClosedRange<ZonedDateTime>.step(step: Duration) =
	ZonedDateTimeProgression.fromClosedRange(this, step)

@JvmName("stepZonedDateTime")
fun ClosedRange<ZonedDateTime>.step(stepSize: Long, stepUnit: TemporalUnit) =
	ZonedDateTimeProgression.fromClosedRange(this, stepSize, stepUnit)

@JvmName("stepZonedDateTime")
fun ClosedRange<ZonedDateTime>.step(stepUnit: TemporalUnit) =
	ZonedDateTimeProgression.fromClosedRange(this, stepUnit)

// TODO support for every custom range
