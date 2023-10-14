/** Generated file */

package com.ogm.kotlin.range.extensions

/**
 * Map this [ClosedRange] of [T] to a [ClosedFloatRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToFloatRange(block: (T) -> Float): ClosedFloatingPointRange<Float> =
	block(start)..block(endInclusive)
