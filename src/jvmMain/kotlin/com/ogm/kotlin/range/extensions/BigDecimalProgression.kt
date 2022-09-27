package com.ogm.kotlin.range.extensions

import java.math.BigDecimal

class BigDecimalProgression private constructor(
	start: BigDecimal,
	endInclusive: BigDecimal,
	step: BigDecimal,
) : AbstractProgression<BigDecimal, BigDecimal>(start, endInclusive, step, BigDecimal.ZERO) {
	override val last = if (isEmpty()) {
		endInclusive
	} else if (step > zeroStep) {
		val diff = endInclusive - start
		endInclusive - (diff % step)
	} else {
		val diff = start - endInclusive
		endInclusive + (diff % step.abs())
	}

	override fun iterator() = BigDecimalProgressionIterator()

	inner class BigDecimalProgressionIterator : Iterator<BigDecimal> {
		private var hasNext = !isEmpty()
		private var next = if (hasNext) first else last

		override fun hasNext() = hasNext

		override fun next(): BigDecimal {
			val value = next
			if (value == last) {
				if (!hasNext) throw NoSuchElementException()
				hasNext = false
			} else {
				next += step
			}
			return value
		}
	}

	companion object {
		fun fromClosedRange(rangeStart: BigDecimal, rangeEnd: BigDecimal, step: BigDecimal) =
			BigDecimalProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(range: ClosedRange<BigDecimal>, step: BigDecimal) =
			fromClosedRange(range.start, range.endInclusive, step)
	}
}
