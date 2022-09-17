package com.ogm.kotlin.range.extensions

import kotlin.math.absoluteValue

class DoubleProgression private constructor(
	start: Double,
	endInclusive: Double,
	step: Double,
) : AbstractProgression<Double, Double>(start, step, endInclusive, 0.0) {
	override val last = if (isEmpty()) {
		endInclusive
	} else if (step > 0) {
		val diff = endInclusive - start
		endInclusive - (diff % step)
	} else {
		val diff = start - endInclusive
		endInclusive + (diff % step.absoluteValue)
	}

	override fun iterator() = DoubleProgressionIterator()

	inner class DoubleProgressionIterator : DoubleIterator() {
		private var hasNext = !isEmpty()
		private var next = if (hasNext) first else last

		override fun hasNext() = hasNext

		override fun nextDouble(): Double {
			val value = next
			if (value == last) {
				if (!hasNext) throw NoSuchElementException()
				hasNext = false
			}
			else {
				next += step
			}
			return value
		}
	}

	companion object {
		fun fromClosedRange(rangeStart: Double, rangeEnd: Double, step: Double) =
			DoubleProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(range: ClosedRange<Double>, step: Double) =
			fromClosedRange(range.start, range.endInclusive, step)
	}
}
