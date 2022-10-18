package com.ogm.kotlin.range.extensions

import java.time.Year

data class YearRange(
	override val start: Year,
	override val endInclusive: Year,
) : ClosedRange<Year>, Iterable<Year> {
	override fun iterator(): Iterator<Year> =
		YearProgression.fromClosedRange(this, 1).iterator()

	override fun toString(): String = "$start..$endInclusive"

	companion object {
		val EMPTY = Year.of(1)..Year.of(0)
	}
}

/**
 * Create a closed [YearRange] from [this] value to the specified [that] value.
 * The [YearRange] implements [Iterable], with a step of PT1S.
 */
operator fun Year.rangeTo(that: Year) = YearRange(this, that)

/**
 * Create an open [YearRange] from [this] value to the specified [that] value.
 * The [YearRange] implements [Iterable], with a step of PT1S.
 */
infix fun Year.until(that: Year) = this..Year.of(that.value - 1)

/**
 * Create a closed [YearRange] from [this] value down to the specified [that] value.
 * The [YearRange] implements [Iterable], with a step of PT1S.
 */
infix fun Year.downTo(that: Year) = that..this
