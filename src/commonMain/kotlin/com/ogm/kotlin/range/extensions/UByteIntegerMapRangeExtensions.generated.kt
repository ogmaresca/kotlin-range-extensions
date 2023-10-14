/** Generated file */

package com.ogm.kotlin.range.extensions

/**
 * Map this [ClosedRange] of [T] to a [UByteRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToUByteRange(block: (T) -> UByte): UByteRange =
	(block(start)..block(endInclusive)).toUByteRange()

/**
 * Map this [OpenEndRange] of [T] to a [UByteRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> OpenEndRange<T>.mapToUByteRange(block: (T) -> UByte): UByteRange =
	(block(start)..<block(endExclusive)).toUByteRange()
