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

fun ClosedRange<UShort>.toUShortRange(): UShortRange = when (this) {
	is UShortRange -> this
	else -> UShortRange(start, endInclusive)
}

fun ClosedRange<UInt>.toUShortRange() = when (this) {
	is UIntRange -> UShortRange(this)
	else -> UShortRange(start.toUShort(), endInclusive.toUShort())
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
