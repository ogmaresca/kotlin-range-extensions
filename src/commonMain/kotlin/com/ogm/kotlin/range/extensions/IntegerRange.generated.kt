/** Generated file */

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
