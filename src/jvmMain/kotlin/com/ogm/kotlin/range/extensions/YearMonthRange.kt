package com.ogm.kotlin.range.extensions

import java.time.Period
import java.time.YearMonth

data class YearMonthRange(
	override val start: YearMonth,
	override val endInclusive: YearMonth,
) : ClosedRange<YearMonth>, Iterable<YearMonth> {
	override fun iterator(): Iterator<YearMonth> =
		YearMonthProgression.fromClosedRange(this, Period.ofDays(1)).iterator()

	override fun toString(): String = "$start..$endInclusive"

	companion object {
		val EMPTY = YearMonth.of(1, 2)..YearMonth.of(1, 1)
	}
}

/**
 * Create a closed [YearMonthRange] from [this] value to the specified [that] value.
 * The [YearMonthRange] implements [Iterable], with a step of P1D.
 */
operator fun YearMonth.rangeTo(that: YearMonth) = YearMonthRange(this, that)

/**
 * Create an open [YearMonthRange] from [this] value to the specified [that] value.
 * The [YearMonthRange] implements [Iterable], with a step of P1D.
 */
infix fun YearMonth.until(that: YearMonth) = this..that.let {
	when (it.monthValue) {
		1 -> YearMonth.of(it.year - 1, that.month - 1L)
		else -> YearMonth.of(it.year, it.month - 1L)
	}
}

/**
 * Create a closed [YearMonthRange] from [this] value until to the specified [that] value.
 * The [YearMonthRange] implements [Iterable], with a step of P1D.
 */
infix fun YearMonth.downTo(that: YearMonth) = that..this
