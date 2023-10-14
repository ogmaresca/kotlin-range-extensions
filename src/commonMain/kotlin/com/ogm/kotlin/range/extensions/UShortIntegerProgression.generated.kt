/** Generated file */

package com.ogm.kotlin.range.extensions

@JvmInline
value class UShortProgression internal constructor(
	private val value: UIntProgression,
) : Iterable<UShort> {
	val first get() = value.first.toUShort()
	val last get() = value.last.toUShort()
	val step get() = value.step.toUShort()

	override fun iterator(): Iterator<UShort> = UShortProgressionIterator(value.iterator())

	/**
	 * Checks if the progression is empty.
	 */
	fun isEmpty() = value.isEmpty()

	override fun toString() = value.toString()

	companion object {
		fun fromClosedRange(rangeStart: UShort, rangeEnd: UShort, step: Short) =
			UShortProgression((rangeStart..rangeEnd).step(step.toInt()))

		fun fromClosedRange(range: ClosedRange<UShort>, step: Short) =
			fromClosedRange(range.start, range.endInclusive, step)

		fun fromOpenEndRange(rangeStart: UShort, rangeEnd: UShort, step: Short) =
			UShortProgression((rangeStart..<rangeEnd).step(step.toInt()))

		fun fromOpenEndRange(range: ClosedRange<UShort>, step: Short) =
			fromOpenEndRange(range.start, range.endInclusive, step)
	}

	@JvmInline
	private value class UShortProgressionIterator(private val value: Iterator<UInt>) : Iterator<UShort> {
		override fun hasNext() = value.hasNext()
		override fun next() = value.next().toUShort()
	}
}
