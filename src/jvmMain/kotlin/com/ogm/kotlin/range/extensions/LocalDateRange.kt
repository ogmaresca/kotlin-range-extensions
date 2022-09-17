package com.ogm.kotlin.range.extensions

import java.time.LocalDate
import java.time.Period

data class LocalDateRange(
	override val start: LocalDate,
	override val endInclusive: LocalDate,
) : ClosedRange<LocalDate>, Iterable<LocalDate> {
	override fun iterator(): Iterator<LocalDate> =
		LocalDateProgression.fromClosedRange(this, Period.ofDays(1)).iterator()

	override fun toString(): String = "$start..$endInclusive"

	companion object {
		val EMPTY = LocalDate.ofEpochDay(1)..LocalDate.ofEpochDay(-1)
	}
}

operator fun LocalDate.rangeTo(that: LocalDate) = LocalDateRange(this, that)
