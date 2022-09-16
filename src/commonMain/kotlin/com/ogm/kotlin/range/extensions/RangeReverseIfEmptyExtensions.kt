package com.ogm.kotlin.range.extensions

import kotlin.jvm.JvmName

fun <T : Comparable<T>> ClosedRange<T>.reverseIfEmpty(): ClosedRange<T> = if (isEmpty()) {
	endInclusive..start
} else {
	this
}

@JvmName("reverseIfEmptyLong")
fun ClosedRange<Long>.reverseIfEmpty(): LongRange = if (isEmpty()) {
	reverse()
} else {
	toLongRange()
}

@JvmName("reverseIfEmptyULong")
fun ClosedRange<ULong>.reverseIfEmpty(): ULongRange = if (isEmpty()) {
	reverse()
} else {
	toULongRange()
}

@JvmName("reverseIfEmptyInt")
fun ClosedRange<Int>.reverseIfEmpty(): IntRange = if (isEmpty()) {
	reverse()
} else {
	toIntRange()
}

@JvmName("reverseIfEmptyUInt")
fun ClosedRange<UInt>.reverseIfEmpty(): UIntRange = if (isEmpty()) {
	reverse()
} else {
	toUIntRange()
}

@JvmName("reverseIfEmptyUShort")
fun ClosedRange<UShort>.reverseIfEmpty(): UShortRange = if (isEmpty()) {
	reverse()
} else {
	toUShortRange()
}

@JvmName("reverseIfEmptyDouble")
fun ClosedRange<Double>.reverseIfEmpty(): ClosedFloatingPointRange<Double> = if (isEmpty()) {
	reverse()
} else {
	toDoubleRange()
}

@JvmName("reverseIfEmptyFloat")
fun ClosedRange<Float>.reverseIfEmpty(): ClosedFloatingPointRange<Float> = if (isEmpty()) {
	reverse()
} else {
	toFloatRange()
}

@JvmName("reverseIfEmptyChar")
fun ClosedRange<Char>.reverseIfEmpty(): CharRange = if (isEmpty()) {
	reverse()
} else {
	toCharRange()
}

// TODO support for every custom range
