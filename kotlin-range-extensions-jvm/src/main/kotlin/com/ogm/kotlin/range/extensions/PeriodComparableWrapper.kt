package com.ogm.kotlin.range.extensions

import java.time.Period

// Kotlin 1.7: implement ChronoPeriod by delegation
// https://kotlinlang.org/docs/whatsnew17.html#allow-implementation-by-delegation-to-an-inlined-value-of-an-inline-class

@JvmInline
value class PeriodComparableWrapper(private val period: Period)
	: Comparable<PeriodComparableWrapper>/*, ChronoPeriod by period*/ {
	override fun compareTo(other: PeriodComparableWrapper) =
		other.period.years.compareTo(other.period.years).takeUnless { it == 0 }
			?: other.period.months.compareTo(other.period.months).takeUnless { it == 0 }
			?: other.period.days.compareTo(other.period.days)
	override fun toString() = period.toString()

	fun toPeriod(): Period = period

	companion object {
		val ZERO = Period.ZERO.toComparable()
	}
}

internal fun Period.toComparable() = PeriodComparableWrapper(this)

operator fun Period.rangeTo(that: Period) = toComparable()..toComparable()
