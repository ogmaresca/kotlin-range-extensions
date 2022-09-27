package com.ogm.kotlin.range.extensions

/**
 * Convert this [ClosedRange] to a [LongRange]
 */
fun ClosedRange<Long>.toLongRange(): LongRange = when (this) {
	is LongRange -> this
	else -> start..endInclusive
}

/**
 * Convert this [ClosedRange] to a [ULongRange]
 */
fun ClosedRange<ULong>.toULongRange(): ULongRange = when (this) {
	is ULongRange -> this
	else -> start..endInclusive
}

/**
 * Convert this [ClosedRange] to a [IntRange]
 */
fun ClosedRange<Int>.toIntRange(): IntRange = when (this) {
	is IntRange -> this
	else -> start..endInclusive
}

/**
 * Convert this [ClosedRange] to a [UIntRange]
 */
fun ClosedRange<UInt>.toUIntRange(): UIntRange = when (this) {
	is UIntRange -> this
	else -> start..endInclusive
}

/**
 * Convert this [ClosedRange] to a [ShortRange]
 */
fun ClosedRange<Short>.toShortRange(): ShortRange = when (this) {
	is ShortRange -> this
	else -> ShortRange(start, endInclusive)
}

/**
 * Convert this [ClosedRange] to a [ShortRange]
 */
@JvmName("toShortRangeFromIntRange")
fun ClosedRange<Int>.toShortRange() = when (this) {
	is IntRange -> ShortRange(this)
	else -> ShortRange(start.toShort(), endInclusive.toShort())
}

/**
 * Convert this [ClosedRange] to a [UShortRange]
 */
fun ClosedRange<UShort>.toUShortRange(): UShortRange = when (this) {
	is UShortRange -> this
	else -> UShortRange(start, endInclusive)
}

/**
 * Convert this [ClosedRange] to a [UShortRange]
 */
@JvmName("toUShortRangeFromUIntRange")
fun ClosedRange<UInt>.toUShortRange() = when (this) {
	is UIntRange -> UShortRange(this)
	else -> UShortRange(start.toUShort(), endInclusive.toUShort())
}

/**
 * Convert this [ClosedRange] to a [ByteRange]
 */
fun ClosedRange<Byte>.toByteRange(): ByteRange = when (this) {
	is ByteRange -> this
	else -> ByteRange(start, endInclusive)
}

/**
 * Convert this [ClosedRange] to a [ByteRange]
 */
@JvmName("toByteRangeFromIntRange")
fun ClosedRange<Int>.toByteRange() = when (this) {
	is IntRange -> ByteRange(this)
	else -> ByteRange(start.toByte(), endInclusive.toByte())
}

/**
 * Convert this [ClosedRange] to a [UByteRange]
 */
fun ClosedRange<UByte>.toUByteRange(): UByteRange = when (this) {
	is UByteRange -> this
	else -> UByteRange(start, endInclusive)
}

/**
 * Convert this [ClosedRange] to a [UByteRange]
 */
@JvmName("toUByteRangeFromUIntRange")
fun ClosedRange<UInt>.toUByteRange() = when (this) {
	is UIntRange -> UByteRange(this)
	else -> UByteRange(start.toUByte(), endInclusive.toUByte())
}

/**
 * Convert this [ClosedRange] to a [ClosedDoubleRange]
 */
fun ClosedRange<Double>.toDoubleRange(): ClosedFloatingPointRange<Double> = when (this) {
	is ClosedFloatingPointRange<Double> -> this
	else -> start..endInclusive
}

/**
 * Convert this [ClosedRange] to a [ClosedFloatRange]
 */
fun ClosedRange<Float>.toFloatRange(): ClosedFloatingPointRange<Float> = when (this) {
	is ClosedFloatingPointRange<Float> -> this
	else -> start..endInclusive
}

/**
 * Convert this [ClosedRange] to a [CharRange]
 */
fun ClosedRange<Char>.toCharRange(): CharRange = when (this) {
	is CharRange -> this
	else -> start..endInclusive
}

// TODO support for every custom range
