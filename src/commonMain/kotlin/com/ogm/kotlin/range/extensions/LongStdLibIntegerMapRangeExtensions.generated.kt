/** Generated file */

package com.ogm.kotlin.range.extensions

/**
 * Map this [ClosedRange] of [T] to a [LongRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToLongRange(block: (T) -> Long): LongRange =
	block(start)..block(endInclusive)

/**
 * Map this [OpenEndRange] of [T] to a [LongRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> OpenEndRange<T>.mapToLongRange(block: (T) -> Long): LongRange =
	block(start)..<block(endExclusive)
