package com.ogm.kotlin.range.extensions

import java.math.BigInteger

class BigIntegerProgression private constructor(
	start: BigInteger,
	endInclusive: BigInteger,
	step: BigInteger,
) : AbstractProgression<BigInteger, BigInteger>(start, endInclusive, step, BigInteger.ZERO) {
	override val last = if (isEmpty()) {
		endInclusive
	} else if (step > zeroStep) {
		val diff = endInclusive - start
		endInclusive - (diff % step)
	} else {
		val diff = start - endInclusive
		endInclusive + (diff % step.abs())
	}

	override fun iterator() = BigIntegerProgressionIterator()

	inner class BigIntegerProgressionIterator : Iterator<BigInteger> {
		private var hasNext = !isEmpty()
		private var next = if (hasNext) first else last

		override fun hasNext() = hasNext

		override fun next(): BigInteger {
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
		fun fromClosedRange(rangeStart: BigInteger, rangeEnd: BigInteger, step: BigInteger) =
			BigIntegerProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(range: ClosedRange<BigInteger>, step: BigInteger) =
			fromClosedRange(range.start, range.endInclusive, step)
	}
}
