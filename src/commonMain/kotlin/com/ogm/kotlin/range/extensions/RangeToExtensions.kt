package com.ogm.kotlin.range.extensions

fun ClosedRange<Long>.toLongRange(): LongRange = when (this) {
	is LongRange -> this
	else -> start..endInclusive
}

fun ClosedRange<ULong>.toULongRange(): ULongRange = when (this) {
	is ULongRange -> this
	else -> start..endInclusive
}

fun ClosedRange<Int>.toIntRange(): IntRange = when (this) {
	is IntRange -> this
	else -> start..endInclusive
}

fun ClosedRange<UInt>.toUIntRange(): UIntRange = when (this) {
	is UIntRange -> this
	else -> start..endInclusive
}

fun ClosedRange<Short>.toShortRange(): ShortRange = when (this) {
	is ShortRange -> this
	else -> ShortRange(start, endInclusive)
}

@JvmName("toShortRangeFromIntRange")
fun ClosedRange<Int>.toShortRange() = when (this) {
	is IntRange -> ShortRange(this)
	else -> ShortRange(start.toShort(), endInclusive.toShort())
}

fun ClosedRange<UShort>.toUShortRange(): UShortRange = when (this) {
	is UShortRange -> this
	else -> UShortRange(start, endInclusive)
}

@JvmName("toUShortRangeFromUIntRange")
fun ClosedRange<UInt>.toUShortRange() = when (this) {
	is UIntRange -> UShortRange(this)
	else -> UShortRange(start.toUShort(), endInclusive.toUShort())
}

fun ClosedRange<Byte>.toByteRange(): ByteRange = when (this) {
	is ByteRange -> this
	else -> ByteRange(start, endInclusive)
}

@JvmName("toByteRangeFromIntRange")
fun ClosedRange<Int>.toByteRange() = when (this) {
	is IntRange -> ByteRange(this)
	else -> ByteRange(start.toByte(), endInclusive.toByte())
}

fun ClosedRange<UByte>.toUByteRange(): UByteRange = when (this) {
	is UByteRange -> this
	else -> UByteRange(start, endInclusive)
}

@JvmName("toUByteRangeFromUIntRange")
fun ClosedRange<UInt>.toUByteRange() = when (this) {
	is UIntRange -> UByteRange(this)
	else -> UByteRange(start.toUByte(), endInclusive.toUByte())
}

fun ClosedRange<Double>.toDoubleRange(): ClosedFloatingPointRange<Double> = when (this) {
	is ClosedFloatingPointRange<Double> -> this
	else -> start..endInclusive
}

fun ClosedRange<Float>.toFloatRange(): ClosedFloatingPointRange<Float> = when (this) {
	is ClosedFloatingPointRange<Float> -> this
	else -> start..endInclusive
}

fun ClosedRange<Char>.toCharRange(): CharRange = when (this) {
	is CharRange -> this
	else -> start..endInclusive
}

// TODO support for every custom range
