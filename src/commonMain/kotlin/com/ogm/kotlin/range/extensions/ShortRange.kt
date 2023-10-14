package com.ogm.kotlin.range.extensions

@JvmInline
value class ShortRange internal constructor(
	private val value: IntRange,
) : ClosedRange<Short>, OpenEndRange<Short>, Iterable<Short> {
	constructor(start: Short, endInclusive: Short) : this(start..endInclusive)

	override val start: Short get() = value.first.toShort()

	override val endInclusive: Short get() = value.last.toShort()

	@Suppress("DEPRECATION")
	@Deprecated("Can throw an exception when it's impossible to represent the value with Short type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
	override val endExclusive: Short get() = (value.endExclusive).toShort()

	override fun toString(): String = "$start..$endInclusive"

	override fun iterator() = ShortProgression(value).iterator()

	override fun contains(value: Short): Boolean {
		return super<ClosedRange>.contains(value)
	}

	override fun isEmpty(): Boolean {
		return super<ClosedRange>.isEmpty()
	}

	companion object {
		val EMPTY = ShortRange(Short.MAX_VALUE, Short.MIN_VALUE)
	}
}
