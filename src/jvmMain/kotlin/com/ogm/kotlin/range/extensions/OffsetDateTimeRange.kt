package com.ogm.kotlin.range.extensions

import java.time.Duration
import java.time.OffsetDateTime
import java.time.ZoneOffset

data class OffsetDateTimeRange(
	override val start: OffsetDateTime,
	override val endInclusive: OffsetDateTime,
) : ClosedRange<OffsetDateTime>, Iterable<OffsetDateTime> {
	override fun iterator(): Iterator<OffsetDateTime> =
		OffsetDateTimeProgression.fromClosedRange(this, Duration.ofSeconds(1)).iterator()

	override fun toString(): String = "$start..$endInclusive"

	companion object {
		val EMPTY = InstantRange.EMPTY.mapToOffsetDateTime { it.atOffset(ZoneOffset.UTC) }
	}
}

/**
 * Create a closed [OffsetDateTimeRange] from [this] value to the specified [that] value.
 * The [OffsetDateTimeRange] implements [Iterable], with a step of PT1S.
 */
operator fun OffsetDateTime.rangeTo(that: OffsetDateTime) = OffsetDateTimeRange(this, that)

/**
 * Create an open [OffsetDateTimeRange] from [this] value to the specified [that] value.
 * The [OffsetDateTimeRange] implements [Iterable], with a step of PT1S.
 */
infix fun OffsetDateTime.until(that: OffsetDateTime) = this..that.minusNanos(1)

/**
 * Create a closed [OffsetDateTimeRange] from [this] value down to the specified [that] value.
 * The [OffsetDateTimeRange] implements [Iterable], with a step of PT1S.
 */
infix fun OffsetDateTime.downTo(that: OffsetDateTime) = that..this
