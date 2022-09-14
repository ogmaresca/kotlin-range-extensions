package com.ogm.kotlin.range.extensions

import java.time.Period

@JvmInline
value class PeriodComparableWrapper(private val period: Period) : Comparable<PeriodComparableWrapper> {
	override fun compareTo(other: PeriodComparableWrapper) =
		other.period.years.compareTo(other.period.years).takeUnless { it == 0 }
			?: other.period.months.compareTo(other.period.months).takeUnless { it == 0 }
			?: other.period.days.compareTo(other.period.days)
	override fun toString() = period.toString()
}

internal fun Period.toComparable() = PeriodComparableWrapper(this)

class PeriodRange(start: Period, endInclusive: Period) : ClosedRange<PeriodComparableWrapper> {
	override val start = PeriodComparableWrapper(start)
	override val endInclusive = PeriodComparableWrapper(endInclusive)
}

operator fun Period.rangeTo(that: Period) = PeriodRange(this, that)
