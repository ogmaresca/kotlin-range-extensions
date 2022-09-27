package com.ogm.kotlin.range.extensions

/**
 * Reverse this [ClosedRange], if the range is empty
 */
fun <T : Comparable<T>> ClosedRange<T>.reversedIfEmpty(): ClosedRange<T> = if (isEmpty()) {
	endInclusive..start
} else {
	this
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyLong")
fun ClosedRange<Long>.reversedIfEmpty(): LongRange = if (isEmpty()) {
	reversed()
} else {
	toLongRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyULong")
fun ClosedRange<ULong>.reversedIfEmpty(): ULongRange = if (isEmpty()) {
	reversed()
} else {
	toULongRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyInt")
fun ClosedRange<Int>.reversedIfEmpty(): IntRange = if (isEmpty()) {
	reversed()
} else {
	toIntRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyUInt")
fun ClosedRange<UInt>.reversedIfEmpty(): UIntRange = if (isEmpty()) {
	reversed()
} else {
	toUIntRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyShort")
fun ClosedRange<Short>.reversedIfEmpty(): ShortRange = if (isEmpty()) {
	reversed()
} else {
	toShortRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyUShort")
fun ClosedRange<UShort>.reversedIfEmpty(): UShortRange = if (isEmpty()) {
	reversed()
} else {
	toUShortRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyByte")
fun ClosedRange<Byte>.reversedIfEmpty(): ByteRange = if (isEmpty()) {
	reversed()
} else {
	toByteRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyUByte")
fun ClosedRange<UByte>.reversedIfEmpty(): UByteRange = if (isEmpty()) {
	reversed()
} else {
	toUByteRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyDouble")
fun ClosedRange<Double>.reversedIfEmpty(): ClosedFloatingPointRange<Double> = if (isEmpty()) {
	reversed()
} else {
	toDoubleRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyFloat")
fun ClosedRange<Float>.reversedIfEmpty(): ClosedFloatingPointRange<Float> = if (isEmpty()) {
	reversed()
} else {
	toFloatRange()
}

/**
 * Reverse this [ClosedRange], if the range is empty
 */
@JvmName("reversedIfEmptyChar")
fun ClosedRange<Char>.reversedIfEmpty(): CharRange = if (isEmpty()) {
	reversed()
} else {
	toCharRange()
}

// TODO support for every custom range
