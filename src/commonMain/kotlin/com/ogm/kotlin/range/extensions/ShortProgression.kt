package com.ogm.kotlin.range.extensions

@JvmInline
value class ShortProgression internal constructor(
	private val value: IntProgression,
) : Iterable<Short> {
	val first get() = value.first.toUShort()
	val last get() = value.last.toUShort()
	val step get() = value.step.toShort()

	override fun iterator(): Iterator<Short> = ShortProgressionIterator(value.iterator())

	/**
	 * Checks if the progression is empty.
	 */
	fun isEmpty() = value.isEmpty()

	override fun toString() = value.toString()

	companion object {
		fun fromClosedRange(rangeStart: Short, rangeEnd: Short, step: Short) =
			ShortProgression(IntProgression.fromClosedRange(rangeStart.toInt(), rangeEnd.toInt(), step.toInt()))

		fun fromClosedRange(range: ClosedRange<Short>, step: Short) =
			fromClosedRange(range.start, range.endInclusive, step)
	}

	@JvmInline
	private value class ShortProgressionIterator(private val value: Iterator<Int>) : Iterator<Short> {
		override fun hasNext() = value.hasNext()
		override fun next() = value.next().toShort()
	}
}
