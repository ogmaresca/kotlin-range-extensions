package com.ogm.kotlin.range.extensions

/**
 * Check if this range is in ascending order
 */
val <T : Comparable<T>> ClosedRange<T>.ascendingOrder
	get() = start <= endInclusive

/**
 * Check if this range is in ascending order
 */
val <T : Comparable<T>> OpenEndRange<T>.ascendingOrderRange
	get() = start < endExclusive

/**
 * Check if this range is in descending order
 */
val <T : Comparable<T>> ClosedRange<T>.descendingOrder
	get() = start >= endInclusive

/**
 * Check if this range is in descending order
 */
val <T : Comparable<T>> OpenEndRange<T>.descendingOrderRange
	get() = start > endExclusive

/**
 * Convert this [ClosedRange] to be in ascending order.
 * Ex: convert `10..1` to `1..10`
 */
fun <T : Comparable<T>> ClosedRange<T>.toAscendingOrder() = if (descendingOrder) {
	endInclusive..start
} else {
	this
}

/**
 * Convert this [ClosedRange] to be in descending order.
 * Ex: convert `1..10` to `10..1`
 */
fun <T : Comparable<T>> ClosedRange<T>.toDescendingOrder() = if (ascendingOrder) {
	endInclusive..start
} else {
	this
}
