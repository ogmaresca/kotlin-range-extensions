package com.ogm.kotlin.range.extensions

import kotlin.jvm.JvmName

fun <T : Comparable<T>> ClosedRange<T>.abs(): ClosedRange<T> = if (start > endInclusive) {
	endInclusive..start
} else {
	this
}

fun LongRange.abs(): LongRange = if (start > endInclusive) {
	endInclusive..start
} else {
	this
}

fun ULongRange.abs(): ULongRange = if (start > endInclusive) {
	endInclusive..start
} else {
	this
}

fun IntRange.abs(): IntRange = if (start > endInclusive) {
	endInclusive..start
} else {
	this
}

fun UIntRange.abs(): UIntRange = if (start > endInclusive) {
	endInclusive..start
} else {
	this
}

fun UShortRange.abs(): UShortRange = if (start > endInclusive) {
	UShortRange(endInclusive, start)
} else {
	this
}

@JvmName("absDouble")
fun ClosedFloatingPointRange<Double>.abs(): ClosedFloatingPointRange<Double> = if (start > endInclusive) {
	endInclusive..start
} else {
	this
}

@JvmName("absFloat")
fun ClosedFloatingPointRange<Float>.abs(): ClosedFloatingPointRange<Float> = if (start > endInclusive) {
	endInclusive..start
} else {
	this
}

fun CharRange.abs(): CharRange = if (start > endInclusive) {
	endInclusive..start
} else {
	this
}

// TODO support for every custom range
