package com.ogm.kotlin.range.extensions

fun <T : Comparable<T>> ClosedRange<T>.isIncremental() = endInclusive >= start

fun <T : Comparable<T>> OpenEndRange<T>.isIncrementalOpenEndRange() = endExclusive >= start

/**
 * Convert this [ClosedRange] to a range where [ClosedRange.start] is less than or equal to [ClosedRange.endInclusive]
 */
fun <T : Comparable<T>> ClosedRange<T>.toIncrementalRange(): ClosedRange<T> = if (isIncremental()) {
	this
} else {
	reversed()
}
