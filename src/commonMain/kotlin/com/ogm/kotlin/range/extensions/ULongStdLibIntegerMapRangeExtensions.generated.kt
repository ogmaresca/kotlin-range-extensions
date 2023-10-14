/** Generated file */

package com.ogm.kotlin.range.extensions

/**
 * Map this [ClosedRange] of [T] to a [ULongRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToULongRange(block: (T) -> ULong): ULongRange =
	block(start)..block(endInclusive)

/**
 * Map this [OpenEndRange] of [T] to a [ULongRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> OpenEndRange<T>.mapToULongRange(block: (T) -> ULong): ULongRange =
	block(start)..<block(endExclusive)
