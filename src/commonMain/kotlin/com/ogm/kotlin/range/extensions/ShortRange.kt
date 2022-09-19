package com.ogm.kotlin.range.extensions

@JvmInline
value class ShortRange internal constructor(
	private val value: IntRange,
) : ClosedRange<Short>, Iterable<Short> {
	constructor(start: Short, endInclusive: Short) : this(start..endInclusive)

	override val start: Short get() = value.first.toShort()
	override val endInclusive: Short get() = value.last.toShort()

	override fun toString(): String = "$start..$endInclusive"

	override fun iterator() = ShortProgression(value).iterator()

	companion object {
		val EMPTY = ShortRange(Short.MAX_VALUE, Short.MIN_VALUE)
	}
}
