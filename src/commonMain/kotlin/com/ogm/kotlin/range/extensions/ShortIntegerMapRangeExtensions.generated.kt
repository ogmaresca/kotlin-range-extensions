/** Generated file */

package com.ogm.kotlin.range.extensions

/**
 * Map this [ClosedRange] of [T] to a [ShortRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToShortRange(block: (T) -> Short): ShortRange =
	(block(start)..block(endInclusive)).toShortRange()

/**
 * Map this [OpenEndRange] of [T] to a [ShortRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> OpenEndRange<T>.mapToShortRange(block: (T) -> Short): ShortRange =
	(block(start)..<block(endExclusive)).toShortRange()
