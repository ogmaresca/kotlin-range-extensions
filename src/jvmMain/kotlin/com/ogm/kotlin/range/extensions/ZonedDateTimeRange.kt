package com.ogm.kotlin.range.extensions

import java.time.Duration
import java.time.ZoneId
import java.time.ZonedDateTime

data class ZonedDateTimeRange(
	override val start: ZonedDateTime,
	override val endInclusive: ZonedDateTime,
) : ClosedRange<ZonedDateTime>, Iterable<ZonedDateTime> {
	override fun contains(value: ZonedDateTime): Boolean =
		(start.toInstant()..endInclusive.toInstant()).contains(value.toInstant())

	override fun isEmpty(): Boolean = (start.toInstant()..endInclusive.toInstant()).isEmpty()

	override fun iterator(): Iterator<ZonedDateTime> =
		ZonedDateTimeProgression.fromClosedRange(this, Duration.ofSeconds(1)).iterator()

	override fun toString(): String = "$start..$endInclusive"

	companion object {
		val EMPTY = InstantRange.EMPTY.mapToZonedDateTime { it.atZone(ZoneId.systemDefault()) }
	}
}

/**
 * Create a closed [ZonedDateTimeRange] from [this] value to the specified [that] value.
 * The [ZonedDateTimeRange] implements [Iterable], with a step of PT1S.
 */
operator fun ZonedDateTime.rangeTo(that: ZonedDateTime) = ZonedDateTimeRange(this, that)

/**
 * Create an open [ZonedDateTimeRange] from [this] value to the specified [that] value.
 * The [ZonedDateTimeRange] implements [Iterable], with a step of PT1S.
 */
infix fun ZonedDateTime.until(that: ZonedDateTime) = this..that.minusNanos(1)

/**
 * Create a closed [ZonedDateTimeRange] from [this] value down to the specified [that] value.
 * The [ZonedDateTimeRange] implements [Iterable], with a step of PT1S.
 */
infix fun ZonedDateTime.downTo(that: ZonedDateTime) = that..this
