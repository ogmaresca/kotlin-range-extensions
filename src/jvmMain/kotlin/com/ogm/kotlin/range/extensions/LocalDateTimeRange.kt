package com.ogm.kotlin.range.extensions

import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneOffset

data class LocalDateTimeRange(
	override val start: LocalDateTime,
	override val endInclusive: LocalDateTime,
) : ClosedRange<LocalDateTime>, Iterable<LocalDateTime> {
	override fun iterator(): Iterator<LocalDateTime> =
		LocalDateTimeProgression.fromClosedRange(this, Duration.ofSeconds(1)).iterator()

	override fun toString(): String = "$start..$endInclusive"

	companion object {
		val EMPTY = LocalDateTime.ofEpochSecond(1, 0, ZoneOffset.UTC)..LocalDateTime.ofEpochSecond(0, 0, ZoneOffset.UTC)
	}
}

/**
 * Create a closed [LocalDateTimeRange] from [this] value to the specified [that] value.
 * The [LocalDateTimeRange] implements [Iterable], with a step of PT1S.
 */
operator fun LocalDateTime.rangeTo(that: LocalDateTime) = LocalDateTimeRange(this, that)

/**
 * Create an open [LocalDateTimeRange] from [this] value to the specified [that] value.
 * The [LocalDateTimeRange] implements [Iterable], with a step of PT1S.
 */
infix fun LocalDateTime.until(that: LocalDateTime) = this..that.minusNanos(1)

/**
 * Create a closed [LocalDateTimeRange] from [this] value down to the specified [that] value.
 * The [LocalDateTimeRange] implements [Iterable], with a step of PT1S.
 */
infix fun LocalDateTime.downTo(that: LocalDateTime) = that..this
