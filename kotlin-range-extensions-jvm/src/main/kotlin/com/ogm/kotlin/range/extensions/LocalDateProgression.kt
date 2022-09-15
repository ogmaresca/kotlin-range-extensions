package com.ogm.kotlin.range.extensions

import java.time.LocalDate
import java.time.Period

@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
open class LocalDateProgression protected constructor(
	start: LocalDate,
	endInclusive: LocalDate,
	step: Period,
) : AbstractProgression<LocalDate, PeriodComparableWrapper>(start, endInclusive, step.toComparable()) {
	override fun LocalDate.plus(right: PeriodComparableWrapper): LocalDate = this.plus(right)

	override fun LocalDate.minus(right: PeriodComparableWrapper): LocalDate = this.minus(right)

	override fun LocalDate.minus(right: LocalDate): LocalDate = this.minus(right)

	override fun PeriodComparableWrapper.minus(right: PeriodComparableWrapper): PeriodComparableWrapper =
		this.minus(right)

	override fun LocalDate.rem(right: PeriodComparableWrapper): PeriodComparableWrapper =
		Period.ofDays((toEpochDay() % (this + right.toPeriod()).toEpochDay()).toInt()).toComparable()

	override fun zeroValue(): LocalDate = LocalDate.ofEpochDay(0)
	override fun zeroStep(): PeriodComparableWrapper = PeriodComparableWrapper.ZERO

	companion object {
		fun fromClosedRange(rangeStart: LocalDate, rangeEnd: LocalDate, step: Period) =
			LocalDateProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(range: ClosedRange<LocalDate>, step: Period) =
			fromClosedRange(range.start, range.endInclusive, step)
	}
}
