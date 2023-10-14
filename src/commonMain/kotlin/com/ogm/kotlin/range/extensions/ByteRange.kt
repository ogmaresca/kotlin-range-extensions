package com.ogm.kotlin.range.extensions

@JvmInline
value class ByteRange internal constructor(
	private val value: IntRange,
) : ClosedRange<Byte>, OpenEndRange<Byte>, Iterable<Byte> {
	constructor(start: Byte, endInclusive: Byte) : this(start..endInclusive)

	override val start: Byte get() = value.first.toByte()
	override val endInclusive: Byte get() = value.last.toByte()

	@Suppress("DEPRECATION")
	@Deprecated("Can throw an exception when it's impossible to represent the value with Byte type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
	override val endExclusive: Byte get() = (value.endExclusive).toByte()

	override fun toString(): String = "$start..$endInclusive"

	override fun iterator() = ByteProgression(value).iterator()

	override fun contains(value: Byte): Boolean {
		return super<ClosedRange>.contains(value)
	}

	override fun isEmpty(): Boolean {
		return super<ClosedRange>.isEmpty()
	}

	companion object {
		val EMPTY = ByteRange(Byte.MAX_VALUE, Byte.MIN_VALUE)
	}
}
