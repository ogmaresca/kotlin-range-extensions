package com.ogm.kotlin.range.extensions

import java.time.Duration

data class DurationRange(override val start: Duration, override val endInclusive: Duration) :
	ClosedRange<Duration>,
	Iterable<Duration> {
	override fun iterator(): Iterator<Duration> = DurationProgression.fromClosedRange(this, Duration.ofSeconds(1)).iterator()

	override fun toString(): String = "$start..$endInclusive"

	companion object {
		val EMPTY = Duration.ofNanos(1)..Duration.ofNanos(0)
	}
}

/**
 * Create a closed [DurationRange] from [this] value to the specified [that] value.
 * The [DurationRange] implements [Iterable], with a step of PT1S.
 */
operator fun Duration.rangeTo(that: Duration) = DurationRange(this, that)

/**
 * Create an open [DurationRange] from [this] value to the specified [that] value.
 * The [DurationRange] implements [Iterable], with a step of PT1S.
 */
infix fun Duration.until(that: Duration) = this..that.minusNanos(1)

/**
 * Create a closed [DurationRange] from [this] value down to the specified [that] value.
 * The [DurationRange] implements [Iterable], with a step of PT1S.
 */
infix fun Duration.downTo(that: Duration) = that..this
