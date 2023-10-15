/** Generated file */

package com.ogm.kotlin.range.extensions


@JvmInline
value class ShortProgression internal constructor(
	private val value: IntProgression,
) : Iterable<Short> {
	val first get() = value.first.toShort()
	val last get() = value.last.toShort()
	val step get() = value.step.toShort()

	override fun iterator(): Iterator<Short> = ShortProgressionIterator(value.iterator())

	/**
	 * Checks if the progression is empty.
	 */
	fun isEmpty() = value.isEmpty()

	override fun toString() = value.toString()

	companion object {
		fun fromClosedRange(rangeStart: Short, rangeEnd: Short, step: Short): ShortProgression =
			ShortProgression((rangeStart..rangeEnd).step(step.toInt()))

		fun fromClosedRange(range: ClosedRange<Short>, step: Short): ShortProgression =
			fromClosedRange(range.start, range.endInclusive, step)

		fun fromOpenEndRange(rangeStart: Short, rangeEnd: Short, step: Short): ShortProgression =
			ShortProgression((rangeStart..<rangeEnd).step(step.toInt()))

		fun fromOpenEndRange(range: OpenEndRange<Short>, step: Short): ShortProgression =
			fromOpenEndRange(range.start, range.endExclusive, step)
	}

	@JvmInline
	private value class ShortProgressionIterator(private val value: Iterator<Int>) : Iterator<Short> {
		override fun hasNext() = value.hasNext()
		override fun next() = value.next().toShort()
	}
}

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
		fun fromClosedRange(rangeStart: UShort, rangeEnd: UShort, step: Short): UShortProgression =
			UShortProgression((rangeStart..rangeEnd).step(step.toInt()))

		fun fromClosedRange(range: ClosedRange<UShort>, step: Short): UShortProgression =
			fromClosedRange(range.start, range.endInclusive, step)

		fun fromOpenEndRange(rangeStart: UShort, rangeEnd: UShort, step: Short): UShortProgression =
			UShortProgression((rangeStart..<rangeEnd).step(step.toInt()))

		fun fromOpenEndRange(range: OpenEndRange<UShort>, step: Short): UShortProgression =
			fromOpenEndRange(range.start, range.endExclusive, step)
	}

	@JvmInline
	private value class UShortProgressionIterator(private val value: Iterator<UInt>) : Iterator<UShort> {
		override fun hasNext() = value.hasNext()
		override fun next() = value.next().toUShort()
	}
}

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
		fun fromClosedRange(rangeStart: Byte, rangeEnd: Byte, step: Byte): ByteProgression =
			ByteProgression((rangeStart..rangeEnd).step(step.toInt()))

		fun fromClosedRange(range: ClosedRange<Byte>, step: Byte): ByteProgression =
			fromClosedRange(range.start, range.endInclusive, step)

		fun fromOpenEndRange(rangeStart: Byte, rangeEnd: Byte, step: Byte): ByteProgression =
			ByteProgression((rangeStart..<rangeEnd).step(step.toInt()))

		fun fromOpenEndRange(range: OpenEndRange<Byte>, step: Byte): ByteProgression =
			fromOpenEndRange(range.start, range.endExclusive, step)
	}

	@JvmInline
	private value class ByteProgressionIterator(private val value: Iterator<Int>) : Iterator<Byte> {
		override fun hasNext() = value.hasNext()
		override fun next() = value.next().toByte()
	}
}

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
		fun fromClosedRange(rangeStart: UByte, rangeEnd: UByte, step: Byte): UByteProgression =
			UByteProgression((rangeStart..rangeEnd).step(step.toInt()))

		fun fromClosedRange(range: ClosedRange<UByte>, step: Byte): UByteProgression =
			fromClosedRange(range.start, range.endInclusive, step)

		fun fromOpenEndRange(rangeStart: UByte, rangeEnd: UByte, step: Byte): UByteProgression =
			UByteProgression((rangeStart..<rangeEnd).step(step.toInt()))

		fun fromOpenEndRange(range: OpenEndRange<UByte>, step: Byte): UByteProgression =
			fromOpenEndRange(range.start, range.endExclusive, step)
	}

	@JvmInline
	private value class UByteProgressionIterator(private val value: Iterator<UInt>) : Iterator<UByte> {
		override fun hasNext() = value.hasNext()
		override fun next() = value.next().toUByte()
	}
}
