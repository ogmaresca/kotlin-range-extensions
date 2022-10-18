package com.ogm.kotlin.range.extensions

import java.time.Period
import java.time.YearMonth

class YearMonthProgression private constructor(
	start: YearMonth,
	endInclusive: YearMonth,
	step: PeriodComparableWrapper,
) : AbstractToLongProgression<YearMonth, PeriodComparableWrapper>(
	start,
	endInclusive,
	step,
	step.toPeriod().toTotalMonths(),
	PeriodComparableWrapper.ZERO,
	YearMonthPeriodToLongConverter,
) {
	init {
		require(step.toPeriod().days == 0) {
			"The step cannot have a day value"
		}
	}

	private object YearMonthPeriodToLongConverter : AbstractToLongProgressionConverter<YearMonth> {
		override fun toLong(value: YearMonth): Long = (value.year * 12L) + value.monthValue

		override fun toValue(value: Long): YearMonth = YearMonth.of(
			(value / 12L).toInt(),
			when (val month = (value % 12L).toInt()) {
				0 -> 12
				else -> month
			},
		)
	}

	companion object {
		fun fromClosedRange(rangeStart: YearMonth, rangeEnd: YearMonth, step: Period) =
			YearMonthProgression(rangeStart, rangeEnd, step.toComparable())

		fun fromClosedRange(rangeStart: YearMonth, rangeEnd: YearMonth, years: Int, months: Int) =
			fromClosedRange(rangeStart, rangeEnd, Period.of(years, months, 0))

		fun fromClosedRange(range: ClosedRange<YearMonth>, step: Period) =
			fromClosedRange(range.start, range.endInclusive, step)

		fun fromClosedRange(range: ClosedRange<YearMonth>, years: Int, months: Int) =
			fromClosedRange(range.start, range.endInclusive, Period.of(years, months, 0))
	}
}
