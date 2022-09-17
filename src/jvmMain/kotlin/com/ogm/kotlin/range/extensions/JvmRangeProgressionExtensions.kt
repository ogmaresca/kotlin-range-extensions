package com.ogm.kotlin.range.extensions

import java.math.BigInteger
import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.Period
import java.time.temporal.TemporalUnit

@JvmName("progressionBigInteger")
fun ClosedRange<BigInteger>.progression(step: BigInteger) =
	BigIntegerProgression.fromClosedRange(this, step)
@JvmName("progressionBigInteger")
fun ClosedRange<BigInteger>.progression(step: Long) = progression(BigInteger.valueOf(step))

@JvmName("progressionDuration")
fun ClosedRange<Duration>.progression(step: Duration) =
	DurationProgression.fromClosedRange(this, step)
@JvmName("progressionDuration")
fun ClosedRange<Duration>.progression(stepSize: Long, stepUnit: TemporalUnit) =
	DurationProgression.fromClosedRange(this, stepSize, stepUnit)
@JvmName("progressionDuration")
fun ClosedRange<Duration>.progression(stepUnit: TemporalUnit) =
	DurationProgression.fromClosedRange(this, stepUnit)

@JvmName("progressionInstant")
fun ClosedRange<Instant>.progression(step: Duration) =
	InstantProgression.fromClosedRange(this, step)
@JvmName("progressionInstant")
fun ClosedRange<Instant>.progression(stepSize: Long, stepUnit: TemporalUnit) =
	InstantProgression.fromClosedRange(this, stepSize, stepUnit)
@JvmName("progressionInstant")
fun ClosedRange<Instant>.progression(stepUnit: TemporalUnit) =
	InstantProgression.fromClosedRange(this, stepUnit)

@JvmName("progressionLocalDate")
fun ClosedRange<LocalDate>.progression(step: Period) =
	LocalDateProgression.fromClosedRange(this, step)

// TODO support for every custom range
