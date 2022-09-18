package com.ogm.kotlin.range.extensions

import java.math.BigInteger
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit

internal val NANOS_PER_UNIT = listOf<TemporalUnit>(
	ChronoUnit.NANOS,
	ChronoUnit.MICROS,
	ChronoUnit.MILLIS,
	ChronoUnit.SECONDS,
	ChronoUnit.MINUTES,
	ChronoUnit.HOURS,
	ChronoUnit.HALF_DAYS,
	ChronoUnit.DAYS,
	ChronoUnit.WEEKS,
	ChronoUnit.MONTHS,
	ChronoUnit.YEARS,
	ChronoUnit.DECADES,
	ChronoUnit.CENTURIES,
	ChronoUnit.MILLENNIA,
	ChronoUnit.ERAS,
).associateBy({ it }) { it.duration.toNanos() }

internal val NANOS_PER_SECOND = BigInteger.valueOf(NANOS_PER_UNIT.getValue(ChronoUnit.SECONDS))

internal val BIG_INTEGER_MAX_LONG_VALUE = BigInteger.valueOf(Long.MAX_VALUE)
