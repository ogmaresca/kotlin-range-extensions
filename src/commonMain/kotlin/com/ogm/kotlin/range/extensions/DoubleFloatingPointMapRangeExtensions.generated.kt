/** Generated file */

package com.ogm.kotlin.range.extensions

/**
 * Map this [ClosedRange] of [T] to a [ClosedDoubleRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToDoubleRange(block: (T) -> Double): ClosedFloatingPointRange<Double> =
	block(start)..block(endInclusive)
