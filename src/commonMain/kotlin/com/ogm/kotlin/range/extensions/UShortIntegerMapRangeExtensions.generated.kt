/** Generated file */

package com.ogm.kotlin.range.extensions

/**
 * Map this [ClosedRange] of [T] to a [UShortRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToUShortRange(block: (T) -> UShort): UShortRange =
	(block(start)..block(endInclusive)).toUShortRange()

/**
 * Map this [OpenEndRange] of [T] to a [UShortRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> OpenEndRange<T>.mapToUShortRange(block: (T) -> UShort): UShortRange =
	(block(start)..<block(endExclusive)).toUShortRange()
