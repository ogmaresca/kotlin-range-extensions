package com.ogm.kotlin.range.extensions

@JvmInline
value class UByteRange internal constructor(
	private val value: UIntRange,
) : ClosedRange<UByte>, OpenEndRange<UByte>, Iterable<UByte> {
	constructor(start: UByte, endInclusive: UByte) : this(start..endInclusive)

	override val start: UByte get() = value.first.toUByte()
	override val endInclusive: UByte get() = value.last.toUByte()

	@Suppress("DEPRECATION")
	@Deprecated("Can throw an exception when it's impossible to represent the value with UByte type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
	override val endExclusive: UByte get() = (value.endExclusive).toUByte()

	override fun toString(): String = "$start..$endInclusive"

	override fun iterator() = UByteProgression(value).iterator()

	override fun contains(value: UByte): Boolean {
		return super<ClosedRange>.contains(value)
	}

	override fun isEmpty(): Boolean {
		return super<ClosedRange>.isEmpty()
	}

	companion object {
		val EMPTY = UByteRange(UByte.MAX_VALUE, UByte.MIN_VALUE)
	}
}
