/** Generated file */

package com.ogm.kotlin.range.extensions

/**
 * Map this [ClosedRange] of [T] to a [IntRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToIntRange(block: (T) -> Int): IntRange =
	block(start)..block(endInclusive)

/**
 * Map this [OpenEndRange] of [T] to a [IntRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> OpenEndRange<T>.mapToIntRange(block: (T) -> Int): IntRange =
	block(start)..<block(endExclusive)
