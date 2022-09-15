package com.ogm.kotlin.range.extensions

import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.Period
import java.time.temporal.TemporalUnit

fun ClosedRange<Duration>.progression(step: Duration) =
	DurationProgression.fromClosedRange(this, step)
fun ClosedRange<Duration>.progression(stepSize: Long, stepUnit: TemporalUnit) =
	DurationProgression.fromClosedRange(this, stepSize, stepUnit)
fun ClosedRange<Duration>.progression(stepUnit: TemporalUnit) =
	DurationProgression.fromClosedRange(this, stepUnit)

fun ClosedRange<Instant>.progression(step: Duration) =
	InstantProgression.fromClosedRange(this, step)
fun ClosedRange<Instant>.progression(stepSize: Long, stepUnit: TemporalUnit) =
	InstantProgression.fromClosedRange(this, stepSize, stepUnit)
fun ClosedRange<Instant>.progression(stepUnit: TemporalUnit) =
	InstantProgression.fromClosedRange(this, stepUnit)

fun ClosedRange<LocalDate>.progression(step: Period) =
	LocalDateProgression.fromClosedRange(this, step)

// TODO support for every custom range
