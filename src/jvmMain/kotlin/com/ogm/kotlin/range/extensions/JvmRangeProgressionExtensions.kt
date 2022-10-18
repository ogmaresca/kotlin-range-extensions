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
import java.time.Period
import java.time.Year
import java.time.YearMonth
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepBigInteger")
fun ClosedRange<BigInteger>.step(step: BigInteger) =
	BigIntegerProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepBigInteger")
fun ClosedRange<BigInteger>.step(step: Long) = step(BigInteger.valueOf(step))

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepBigDecimal")
fun ClosedRange<BigDecimal>.step(step: BigDecimal) =
	BigDecimalProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepDuration")
fun ClosedRange<Duration>.step(step: Duration) =
	DurationProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [stepSize] [stepUnit] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepDuration")
fun ClosedRange<Duration>.step(stepSize: Long, stepUnit: TemporalUnit) =
	DurationProgression.fromClosedRange(this, stepSize, stepUnit)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of a [stepUnit] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepDuration")
fun ClosedRange<Duration>.step(stepUnit: TemporalUnit) =
	DurationProgression.fromClosedRange(this, stepUnit)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepInstant")
fun ClosedRange<Instant>.step(step: Duration) =
	InstantProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [stepSize] [stepUnit] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepInstant")
fun ClosedRange<Instant>.step(stepSize: Long, stepUnit: TemporalUnit) =
	InstantProgression.fromClosedRange(this, stepSize, stepUnit)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of a [stepUnit] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepInstant")
fun ClosedRange<Instant>.step(stepUnit: TemporalUnit) =
	InstantProgression.fromClosedRange(this, stepUnit)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepLocalDate")
fun ClosedRange<LocalDate>.step(step: Period) =
	LocalDateProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepLocalDateTime")
fun ClosedRange<LocalDateTime>.step(step: Duration) =
	LocalDateTimeProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [stepSize] [stepUnit] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepLocalDateTime")
fun ClosedRange<LocalDateTime>.step(stepSize: Long, stepUnit: TemporalUnit) =
	LocalDateTimeProgression.fromClosedRange(this, stepSize, stepUnit)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of a [stepUnit] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepLocalDateTime")
fun ClosedRange<LocalDateTime>.step(stepUnit: TemporalUnit) =
	LocalDateTimeProgression.fromClosedRange(this, stepUnit)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepLocalTime")
fun ClosedRange<LocalTime>.step(step: Duration) =
	LocalTimeProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [stepSize] [stepUnit] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepLocalTime")
fun ClosedRange<LocalTime>.step(stepSize: Long, stepUnit: TemporalUnit) =
	LocalTimeProgression.fromClosedRange(this, stepSize, stepUnit)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of a [stepUnit] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepLocalTime")
fun ClosedRange<LocalTime>.step(stepUnit: TemporalUnit) =
	LocalTimeProgression.fromClosedRange(this, stepUnit)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepMonthDay")
fun ClosedRange<MonthDay>.step(step: Period) =
	MonthDayProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [years] years and [days] days after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepMonthDay")
fun ClosedRange<MonthDay>.step(years: Int, days: Int) =
	MonthDayProgression.fromClosedRange(this, years, days)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepOffsetDateTime")
fun ClosedRange<OffsetDateTime>.step(step: Duration) =
	OffsetDateTimeProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [stepSize] [stepUnit] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepOffsetDateTime")
fun ClosedRange<OffsetDateTime>.step(stepSize: Long, stepUnit: TemporalUnit) =
	OffsetDateTimeProgression.fromClosedRange(this, stepSize, stepUnit)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of a [stepUnit] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepOffsetDateTime")
fun ClosedRange<OffsetDateTime>.step(stepUnit: TemporalUnit) =
	OffsetDateTimeProgression.fromClosedRange(this, stepUnit)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepYearMonth")
fun ClosedRange<YearMonth>.step(step: Period) =
	YearMonthProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [years] years and [months] months after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepYearMonth")
fun ClosedRange<YearMonth>.step(years: Int, months: Int) =
	YearMonthProgression.fromClosedRange(this, years, months)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] years after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepYear")
fun ClosedRange<Year>.step(step: Int) =
	YearProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepZonedDateTime")
fun ClosedRange<ZonedDateTime>.step(step: Duration) =
	ZonedDateTimeProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [stepSize] [stepUnit] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepZonedDateTime")
fun ClosedRange<ZonedDateTime>.step(stepSize: Long, stepUnit: TemporalUnit) =
	ZonedDateTimeProgression.fromClosedRange(this, stepSize, stepUnit)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of a [stepUnit] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepZonedDateTime")
fun ClosedRange<ZonedDateTime>.step(stepUnit: TemporalUnit) =
	ZonedDateTimeProgression.fromClosedRange(this, stepUnit)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] seconds after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepZoneOffset")
fun ClosedRange<ZoneOffset>.step(step: Int) =
	ZoneOffsetProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [hours] hours and [seconds] seconds after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("stepZoneOffset")
fun ClosedRange<ZoneOffset>.step(hours: Int, seconds: Int) =
	ZoneOffsetProgression.fromClosedRange(this, (hours * ChronoUnit.HOURS.duration.seconds).toInt() + seconds)
