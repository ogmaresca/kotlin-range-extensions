/** Generated file */

package com.ogm.kotlin.range.extensions

@JvmInline
value class ByteProgression internal constructor(
	private val value: IntProgression,
) : Iterable<Byte> {
	val first get() = value.first.toByte()
	val last get() = value.last.toByte()
	val step get() = value.step.toByte()

	override fun iterator(): Iterator<Byte> = ByteProgressionIterator(value.iterator())

	/**
	 * Checks if the progression is empty.
	 */
	fun isEmpty() = value.isEmpty()

	override fun toString() = value.toString()

	companion object {
		fun fromClosedRange(rangeStart: Byte, rangeEnd: Byte, step: Byte) =
			ByteProgression((rangeStart..rangeEnd).step(step.toInt()))

		fun fromClosedRange(range: ClosedRange<Byte>, step: Byte) =
			fromClosedRange(range.start, range.endInclusive, step)

		fun fromOpenEndRange(rangeStart: Byte, rangeEnd: Byte, step: Byte) =
			ByteProgression((rangeStart..<rangeEnd).step(step.toInt()))

		fun fromOpenEndRange(range: ClosedRange<Byte>, step: Byte) =
			fromOpenEndRange(range.start, range.endInclusive, step)
	}

	@JvmInline
	private value class ByteProgressionIterator(private val value: Iterator<Int>) : Iterator<Byte> {
		override fun hasNext() = value.hasNext()
		override fun next() = value.next().toByte()
	}
}
