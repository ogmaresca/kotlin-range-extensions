package com.ogm.kotlin.range.extensions

import java.time.Period
import java.time.chrono.ChronoPeriod

// Kotlin 1.7: implement ChronoPeriod by delegation
// https://kotlinlang.org/docs/whatsnew17.html#allow-implementation-by-delegation-to-an-inlined-value-of-an-inline-class

@JvmInline
value class PeriodComparableWrapper(private val period: Period)
	: Comparable<PeriodComparableWrapper>, ChronoPeriod by period {
	override fun compareTo(other: PeriodComparableWrapper): Int {
		val normalized = period.normalized()
		val otherNormalized = other.period.normalized()
		return normalized.toTotalMonths().compareTo(otherNormalized.toTotalMonths()).takeUnless { it == 0 }
			?: normalized.days.compareTo(otherNormalized.days)
	}
	override fun toString() = period.toString()

	fun toPeriod(): Period = period

	companion object {
		val ZERO = Period.ZERO.toComparable()
	}
}

internal fun Period.toComparable() = PeriodComparableWrapper(this)

operator fun Period.rangeTo(that: Period) = toComparable()..that.toComparable()
