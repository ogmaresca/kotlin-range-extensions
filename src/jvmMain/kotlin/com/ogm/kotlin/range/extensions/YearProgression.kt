package com.ogm.kotlin.range.extensions

import java.time.Year

class YearProgression private constructor(
	start: Year,
	endInclusive: Year,
	step: Int,
) : AbstractToLongProgression<Year, Int>(
	start,
	endInclusive,
	step,
	step.toLong(),
	0,
	YearToLongConverter,
) {
	private object YearToLongConverter : AbstractToLongProgressionConverter<Year> {
		override fun toLong(value: Year): Long = value.value.toLong()

		override fun toValue(value: Long): Year = Year.of(value.toInt())
	}

	companion object {
		fun fromClosedRange(rangeStart: Year, rangeEnd: Year, step: Int) =
			YearProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(range: ClosedRange<Year>, step: Int) =
			fromClosedRange(range.start, range.endInclusive, step)
	}
}
