package com.ogm.kotlin.range.extensions

import java.time.Duration
import java.time.Instant

data class InstantRange(
	override val start: Instant,
	override val endInclusive: Instant,
) : ClosedRange<Instant>, Iterable<Instant> {
	override fun iterator(): Iterator<Instant> =
		InstantProgression.fromClosedRange(this, Duration.ofSeconds(1)).iterator()

	override fun toString(): String = "$start..$endInclusive"

	companion object {
		val EMPTY = Instant.ofEpochMilli(1)..Instant.ofEpochSecond(0)
	}
}

/**
 * Create a closed [InstantRange] from [this] value to the specified [that] value.
 * The [InstantRange] implements [Iterable], with a step of PT1S.
 */
operator fun Instant.rangeTo(that: Instant) = InstantRange(this, that)

/**
 * Create an open [InstantRange] from [this] value to the specified [that] value.
 * The [InstantRange] implements [Iterable], with a step of PT1S.
 */
infix fun Instant.until(that: Instant) = this..that.minusNanos(1)

/**
 * Create a closed [InstantRange] from [this] value down to the specified [that] value.
 * The [InstantRange] implements [Iterable], with a step of PT1S.
 */
infix fun Instant.downTo(that: Instant) = that..this
