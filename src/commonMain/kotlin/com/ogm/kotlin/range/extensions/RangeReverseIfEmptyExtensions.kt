package com.ogm.kotlin.range.extensions

fun <T : Comparable<T>> ClosedRange<T>.reversedIfEmpty(): ClosedRange<T> = if (isEmpty()) {
	endInclusive..start
} else {
	this
}

@JvmName("reversedIfEmptyLong")
fun ClosedRange<Long>.reversedIfEmpty(): LongRange = if (isEmpty()) {
	reversed()
} else {
	toLongRange()
}

@JvmName("reversedIfEmptyULong")
fun ClosedRange<ULong>.reversedIfEmpty(): ULongRange = if (isEmpty()) {
	reversed()
} else {
	toULongRange()
}

@JvmName("reversedIfEmptyInt")
fun ClosedRange<Int>.reversedIfEmpty(): IntRange = if (isEmpty()) {
	reversed()
} else {
	toIntRange()
}

@JvmName("reversedIfEmptyUInt")
fun ClosedRange<UInt>.reversedIfEmpty(): UIntRange = if (isEmpty()) {
	reversed()
} else {
	toUIntRange()
}

@JvmName("reversedIfEmptyShort")
fun ClosedRange<Short>.reversedIfEmpty(): ShortRange = if (isEmpty()) {
	reversed()
} else {
	toShortRange()
}

@JvmName("reversedIfEmptyUShort")
fun ClosedRange<UShort>.reversedIfEmpty(): UShortRange = if (isEmpty()) {
	reversed()
} else {
	toUShortRange()
}

@JvmName("reversedIfEmptyByte")
fun ClosedRange<Byte>.reversedIfEmpty(): ByteRange = if (isEmpty()) {
	reversed()
} else {
	toByteRange()
}

@JvmName("reversedIfEmptyUByte")
fun ClosedRange<UByte>.reversedIfEmpty(): UByteRange = if (isEmpty()) {
	reversed()
} else {
	toUByteRange()
}


@JvmName("reversedIfEmptyDouble")
fun ClosedRange<Double>.reversedIfEmpty(): ClosedFloatingPointRange<Double> = if (isEmpty()) {
	reversed()
} else {
	toDoubleRange()
}

@JvmName("reversedIfEmptyFloat")
fun ClosedRange<Float>.reversedIfEmpty(): ClosedFloatingPointRange<Float> = if (isEmpty()) {
	reversed()
} else {
	toFloatRange()
}

@JvmName("reversedIfEmptyChar")
fun ClosedRange<Char>.reversedIfEmpty(): CharRange = if (isEmpty()) {
	reversed()
} else {
	toCharRange()
}

// TODO support for every custom range
