/** Generated file */

package com.ogm.kotlin.range.extensions

import kotlin.math.absoluteValue

class DoubleProgression private constructor(start: Double, endInclusive: Double, step: Double) : AbstractProgression<Double, Double>(start, step, endInclusive, Double.MIN_VALUE) {
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
			} else {
				next += step
			}
			return value
		}
	}

	companion object {
		fun fromClosedRange(rangeStart: Double, rangeEnd: Double, step: Double): DoubleProgression = DoubleProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(range: ClosedRange<Double>, step: Double): DoubleProgression = fromClosedRange(range.start, range.endInclusive, step)

		fun fromOpenEndRange(rangeStart: Double, rangeEnd: Double, step: Double): DoubleProgression = fromOpenEndRange(rangeStart..<rangeEnd, step)

		fun fromOpenEndRange(range: OpenEndRange<Double>, step: Double): DoubleProgression = fromClosedRange(range.start, range.calculateEndInclusive(), step)
	}
}

class FloatProgression private constructor(start: Float, endInclusive: Float, step: Float) : AbstractProgression<Float, Float>(start, step, endInclusive, Float.MIN_VALUE) {
	override val last = if (isEmpty()) {
		endInclusive
	} else if (step > 0) {
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
		fun fromClosedRange(rangeStart: Float, rangeEnd: Float, step: Float): FloatProgression = FloatProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(range: ClosedRange<Float>, step: Float): FloatProgression = fromClosedRange(range.start, range.endInclusive, step)

		fun fromOpenEndRange(rangeStart: Float, rangeEnd: Float, step: Float): FloatProgression = fromOpenEndRange(rangeStart..<rangeEnd, step)

		fun fromOpenEndRange(range: OpenEndRange<Float>, step: Float): FloatProgression = fromClosedRange(range.start, range.calculateEndInclusive(), step)
	}
}
