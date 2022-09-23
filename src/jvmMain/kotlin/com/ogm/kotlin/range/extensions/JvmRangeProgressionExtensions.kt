package com.ogm.kotlin.range.extensions

import java.math.BigInteger
import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.Period
import java.time.temporal.TemporalUnit

@JvmName("stepBigInteger")
fun ClosedRange<BigInteger>.step(step: BigInteger) =
	BigIntegerProgression.fromClosedRange(this, step)

@JvmName("stepBigInteger")
fun ClosedRange<BigInteger>.step(step: Long) = step(BigInteger.valueOf(step))

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

// TODO support for every custom range
