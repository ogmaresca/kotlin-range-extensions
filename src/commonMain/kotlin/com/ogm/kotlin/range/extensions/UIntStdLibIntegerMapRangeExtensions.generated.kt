/** Generated file */

package com.ogm.kotlin.range.extensions

/**
 * Map this [ClosedRange] of [T] to a [UIntRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToUIntRange(block: (T) -> UInt): UIntRange =
	block(start)..block(endInclusive)

/**
 * Map this [OpenEndRange] of [T] to a [UIntRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> OpenEndRange<T>.mapToUIntRange(block: (T) -> UInt): UIntRange =
	block(start)..<block(endExclusive)
