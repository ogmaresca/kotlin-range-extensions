package com.ogm.kotlin.range.extensions

import java.time.Duration
import java.time.LocalTime

data class LocalTimeRange(override val start: LocalTime, override val endInclusive: LocalTime) :
	ClosedRange<LocalTime>,
	Iterable<LocalTime> {
	override fun iterator(): Iterator<LocalTime> = LocalTimeProgression.fromClosedRange(this, Duration.ofSeconds(1)).iterator()

	override fun toString(): String = "$start..$endInclusive"

	companion object {
		val EMPTY = LocalTime.ofNanoOfDay(1)..LocalTime.MIDNIGHT
	}
}

/**
 * Create a closed [LocalTimeRange] from [this] value to the specified [that] value.
 * The [LocalTimeRange] implements [Iterable], with a step of PT1S.
 */
operator fun LocalTime.rangeTo(that: LocalTime) = LocalTimeRange(this, that)

/**
 * Create an open [LocalTimeRange] from [this] value to the specified [that] value.
 * The [LocalTimeRange] implements [Iterable], with a step of PT1S.
 */
infix fun LocalTime.until(that: LocalTime) = this..that.minusNanos(1)

/**
 * Create a closed [LocalTimeRange] from [this] value down to the specified [that] value.
 * The [LocalTimeRange] implements [Iterable], with a step of PT1S.
 */
infix fun LocalTime.downTo(that: LocalTime) = that..this
