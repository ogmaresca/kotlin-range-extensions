package com.ogm.kotlin.range.extensions

@JvmInline
value class UShortRange internal constructor(
	private val value: UIntRange,
) : ClosedRange<UShort>, OpenEndRange<UShort>, Iterable<UShort> {
	constructor(start: UShort, endInclusive: UShort) : this(start..endInclusive)

	override val start: UShort get() = value.first.toUShort()
	override val endInclusive: UShort get() = value.last.toUShort()

	@Suppress("DEPRECATION")
	@Deprecated("Can throw an exception when it's impossible to represent the value with UShort type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
	override val endExclusive: UShort get() = (value.endExclusive).toUShort()

	override fun toString(): String = "$start..$endInclusive"

	override fun iterator() = UShortProgression(value).iterator()

	override fun contains(value: UShort): Boolean {
		return super<ClosedRange>.contains(value)
	}

	override fun isEmpty(): Boolean {
		return super<ClosedRange>.isEmpty()
	}

	companion object {
		val EMPTY = UShortRange(UShort.MAX_VALUE, UShort.MIN_VALUE)
	}
}
