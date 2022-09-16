package com.ogm.kotlin.range.extensions

import java.time.LocalDate
import java.time.Period

open class LocalDateProgression protected constructor(
	start: LocalDate,
	endInclusive: LocalDate,
	step: Period,
) : AbstractProgression<LocalDate, PeriodComparableWrapper>(start, endInclusive, step.toComparable()) {
	override fun valuePlusStep(left: LocalDate, right: PeriodComparableWrapper): LocalDate = left + right.toPeriod()

	override fun valueMinus(left: LocalDate, right: LocalDate): LocalDate = left - right

	override fun valueMinusStep(left: LocalDate, right: PeriodComparableWrapper): LocalDate = left - right.toPeriod()

	override fun stepMinus(left: PeriodComparableWrapper, right: PeriodComparableWrapper): PeriodComparableWrapper =
		(left.toPeriod() - right.toPeriod()).toComparable()

	override fun valueModuloStep(left: LocalDate, right: PeriodComparableWrapper): PeriodComparableWrapper =
		Period.ofDays((left.toEpochDay() % (left + right.toPeriod()).toEpochDay()).toInt()).toComparable()

	override fun zeroValue(): LocalDate = LocalDate.ofEpochDay(0)
	override fun zeroStep(): PeriodComparableWrapper = PeriodComparableWrapper.ZERO

	companion object {
		fun fromClosedRange(rangeStart: LocalDate, rangeEnd: LocalDate, step: Period) =
			LocalDateProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(range: ClosedRange<LocalDate>, step: Period) =
			fromClosedRange(range.start, range.endInclusive, step)
	}
}
