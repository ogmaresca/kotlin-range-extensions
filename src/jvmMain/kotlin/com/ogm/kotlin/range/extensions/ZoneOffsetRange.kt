package com.ogm.kotlin.range.extensions

import java.time.ZoneOffset

data class ZoneOffsetRange(override val start: ZoneOffset, override val endInclusive: ZoneOffset) :
	ClosedRange<ZoneOffset>,
	Iterable<ZoneOffset> {
	override fun iterator(): Iterator<ZoneOffset> = ZoneOffsetProgression.fromClosedRange(this, 1).iterator()

	override fun toString(): String = "$start..$endInclusive"

	companion object {
		val EMPTY = ZoneOffset.ofTotalSeconds(1)..ZoneOffset.UTC
	}
}

/**
 * Create a closed [ZoneOffsetRange] from [this] value to the specified [that] value.
 * The [ZoneOffsetRange] implements [Iterable], with a step of PT1S.
 */
operator fun ZoneOffset.rangeTo(that: ZoneOffset) = ZoneOffsetRange(this, that)

/**
 * Create an open [ZoneOffsetRange] from [this] value to the specified [that] value.
 * The [ZoneOffsetRange] implements [Iterable], with a step of PT1S.
 */
infix fun ZoneOffset.until(that: ZoneOffset) = this..ZoneOffset.ofTotalSeconds(that.totalSeconds - 1)

/**
 * Create a closed [ZoneOffsetRange] from [this] value down to the specified [that] value.
 * The [ZoneOffsetRange] implements [Iterable], with a step of PT1S.
 */
infix fun ZoneOffset.downTo(that: ZoneOffset) = that..this
