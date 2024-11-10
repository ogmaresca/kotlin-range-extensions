package com.ogm.kotlin.range.extensions

import java.time.Month
import java.time.MonthDay
import java.time.Period

data class MonthDayRange(override val start: MonthDay, override val endInclusive: MonthDay) :
	ClosedRange<MonthDay>,
	Iterable<MonthDay> {
	override fun iterator(): Iterator<MonthDay> = MonthDayProgression.fromClosedRange(this, Period.ofDays(1)).iterator()

	override fun toString(): String = "$start..$endInclusive"

	companion object {
		val EMPTY = MonthDay.of(Month.JANUARY, 2)..MonthDay.of(Month.JANUARY, 1)
	}
}

/**
 * Create a closed [MonthDayRange] from [this] value to the specified [that] value.
 * The [MonthDayRange] implements [Iterable], with a step of P1D.
 */
operator fun MonthDay.rangeTo(that: MonthDay) = MonthDayRange(this, that)

/**
 * Create an open [MonthDayRange] from [this] value to the specified [that] value.
 * The [MonthDayRange] implements [Iterable], with a step of P1D.
 */
infix fun MonthDay.until(that: MonthDay) = this..that.let {
	when (it.dayOfMonth) {
		1 -> (that.month - 1L).let { month -> MonthDay.of(month, month.minLength()) }
		else -> MonthDay.of(it.month, it.dayOfMonth - 1)
	}
}

/**
 * Create a closed [MonthDayRange] from [this] value until to the specified [that] value.
 * The [MonthDayRange] implements [Iterable], with a step of P1D.
 */
infix fun MonthDay.downTo(that: MonthDay) = that..this
