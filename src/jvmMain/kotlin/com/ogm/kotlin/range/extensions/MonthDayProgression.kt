package com.ogm.kotlin.range.extensions

import java.time.MonthDay
import java.time.Period

class MonthDayProgression private constructor(start: MonthDay, endInclusive: MonthDay, normalizedStep: Period) :
	AbstractProgression<MonthDay, PeriodComparableWrapper>(
		start,
		endInclusive,
		normalizedStep.normalized().toComparable(),
		PeriodComparableWrapper.ZERO,
	) {
	private val calculatedProgression: List<MonthDay> by lazy {
		val period = step.toPeriod()
		val periodMonths = period.toTotalMonths()

		mutableListOf<MonthDay>().apply {
			var next = start
			do {
				add(next)

				var days = next.dayOfMonth + period.days
				var month = next.month + periodMonths

				while (days > month.minLength()) {
					days -= month.minLength()
					month += 1L
				}

				next = MonthDay.of(month, days)
			} while (next <= endInclusive)
		}
	}

	override val last
		get() = calculatedProgression.last()

	override fun iterator() = calculatedProgression.iterator()

	companion object {
		fun fromClosedRange(rangeStart: MonthDay, rangeEnd: MonthDay, months: Int, days: Int) = fromClosedRange(rangeStart, rangeEnd, Period.of(0, months, days))

		fun fromClosedRange(rangeStart: MonthDay, rangeEnd: MonthDay, step: Period) = MonthDayProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(range: ClosedRange<MonthDay>, step: Period) = fromClosedRange(range.start, range.endInclusive, step)

		fun fromClosedRange(range: ClosedRange<MonthDay>, months: Int, days: Int) = fromClosedRange(range.start, range.endInclusive, months, days)
	}
}
