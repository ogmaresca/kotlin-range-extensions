package com.ogm.kotlin.range.extensions

@JvmInline
value class UByteRange internal constructor(
	private val value: UIntRange,
) : ClosedRange<UByte>, Iterable<UByte> {
	constructor(start: UByte, endInclusive: UByte) : this(start..endInclusive)

	override val start: UByte get() = value.first.toUByte()
	override val endInclusive: UByte get() = value.last.toUByte()

	override fun toString(): String = "$start..$endInclusive"

	override fun iterator() = UByteProgression(value).iterator()

	companion object {
		val EMPTY = UByteRange(UByte.MAX_VALUE, UByte.MIN_VALUE)
	}
}
