/** Generated file */

package com.ogm.kotlin.range.extensions

@JvmInline
value class UByteProgression internal constructor(
	private val value: UIntProgression,
) : Iterable<UByte> {
	val first get() = value.first.toUByte()
	val last get() = value.last.toUByte()
	val step get() = value.step.toUByte()

	override fun iterator(): Iterator<UByte> = UByteProgressionIterator(value.iterator())

	/**
	 * Checks if the progression is empty.
	 */
	fun isEmpty() = value.isEmpty()

	override fun toString() = value.toString()

	companion object {
		fun fromClosedRange(rangeStart: UByte, rangeEnd: UByte, step: Byte) =
			UByteProgression((rangeStart..rangeEnd).step(step.toInt()))

		fun fromClosedRange(range: ClosedRange<UByte>, step: Byte) =
			fromClosedRange(range.start, range.endInclusive, step)

		fun fromOpenEndRange(rangeStart: UByte, rangeEnd: UByte, step: Byte) =
			UByteProgression((rangeStart..<rangeEnd).step(step.toInt()))

		fun fromOpenEndRange(range: ClosedRange<UByte>, step: Byte) =
			fromOpenEndRange(range.start, range.endInclusive, step)
	}

	@JvmInline
	private value class UByteProgressionIterator(private val value: Iterator<UInt>) : Iterator<UByte> {
		override fun hasNext() = value.hasNext()
		override fun next() = value.next().toUByte()
	}
}
