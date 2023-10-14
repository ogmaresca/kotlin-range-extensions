/** Generated file */

package com.ogm.kotlin.range.extensions

/**
 * Map this [ClosedRange] of [T] to a [ByteRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToByteRange(block: (T) -> Byte): ByteRange =
	(block(start)..block(endInclusive)).toByteRange()

/**
 * Map this [OpenEndRange] of [T] to a [ByteRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> OpenEndRange<T>.mapToByteRange(block: (T) -> Byte): ByteRange =
	(block(start)..<block(endExclusive)).toByteRange()
