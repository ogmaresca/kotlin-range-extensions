package com.ogm.kotlin.range.extensions

import java.time.LocalDate
import java.time.Period

class LocalDateProgression private constructor(
	start: LocalDate,
	endInclusive: LocalDate,
	nonnormalizedStep: Period,
) : AbstractToLongProgression<LocalDate, PeriodComparableWrapper>(
	start,
	endInclusive,
	nonnormalizedStep.normalized().toComparable(),
	nonnormalizedStep.days.toLong(),
	PeriodComparableWrapper.ZERO,
	LocalDateToLongConverter,
) {
	private val calculatedProgression: List<LocalDate>? by lazy {
		val period = step.toPeriod()
		val totalMonths = period.toTotalMonths()

		if (isEmpty() || totalMonths == 0L) {
			null
		} else {
			mutableListOf<LocalDate>().apply {
				var next = start
				do {
					add(next)
					next += period
				} while (next <= endInclusive)
			}
		}
	}

	override val last
		get() = calculatedProgression?.last() ?: super.last

	override fun iterator() = calculatedProgression?.iterator() ?: super.iterator()

	private object LocalDateToLongConverter : AbstractToLongProgressionConverter<LocalDate> {
		override fun toLong(value: LocalDate): Long = value.toEpochDay()

		override fun toValue(value: Long): LocalDate = LocalDate.ofEpochDay(value)
	}

	companion object {
		fun fromClosedRange(rangeStart: LocalDate, rangeEnd: LocalDate, step: Period) =
			LocalDateProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(range: ClosedRange<LocalDate>, step: Period) =
			fromClosedRange(range.start, range.endInclusive, step)
	}
}
