package com.ogm.kotlin.range.extensions

import kotlin.math.absoluteValue

class FloatProgression private constructor(
	start: Float,
	endInclusive: Float,
	step: Float,
) : AbstractProgression<Float, Float>(start, step, endInclusive, 0.0.toFloat()) {
	override val last = if (isEmpty()) {
		endInclusive
	} else if (step > zeroStep) {
		val diff = endInclusive - start
		endInclusive - (diff % step)
	} else {
		val diff = start - endInclusive
		endInclusive + (diff % step.absoluteValue)
	}

	override fun iterator() = FloatProgressionIterator()

	inner class FloatProgressionIterator : FloatIterator() {
		private var hasNext = !isEmpty()
		private var next = if (hasNext) first else last

		override fun hasNext() = hasNext

		override fun nextFloat(): Float {
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
		fun fromClosedRange(rangeStart: Float, rangeEnd: Float, step: Float) =
			FloatProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(range: ClosedRange<Float>, step: Float) =
			fromClosedRange(range.start, range.endInclusive, step)
	}
}
