package com.ogm.kotlin.range.extensions

@JvmInline
value class ByteRange internal constructor(
	private val value: IntRange,
) : ClosedRange<Byte>, Iterable<Byte> {
	constructor(start: Byte, endInclusive: Byte) : this(start..endInclusive)

	override val start: Byte get() = value.first.toByte()
	override val endInclusive: Byte get() = value.last.toByte()

	override fun toString(): String = "$start..$endInclusive"

	override fun iterator() = ByteProgression(value).iterator()

	companion object {
		val EMPTY = ByteRange(Byte.MAX_VALUE, Byte.MIN_VALUE)
	}
}
