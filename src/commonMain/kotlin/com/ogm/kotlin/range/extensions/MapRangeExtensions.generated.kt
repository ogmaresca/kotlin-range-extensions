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
fun <T : Comparable<T>> OpenEndRange<T>.mapToLongOpenEndRangeRange(block: (T) -> Long): LongRange =
	block(start)..<block(endExclusive)

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
fun <T : Comparable<T>> OpenEndRange<T>.mapToULongOpenEndRangeRange(block: (T) -> ULong): ULongRange =
	block(start)..<block(endExclusive)

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
fun <T : Comparable<T>> OpenEndRange<T>.mapToIntOpenEndRangeRange(block: (T) -> Int): IntRange =
	block(start)..<block(endExclusive)

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
fun <T : Comparable<T>> OpenEndRange<T>.mapToUIntOpenEndRangeRange(block: (T) -> UInt): UIntRange =
	block(start)..<block(endExclusive)

/**
 * Map this [ClosedRange] of [T] to a [CharRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToCharRange(block: (T) -> Char): CharRange =
	block(start)..block(endInclusive)

/**
 * Map this [OpenEndRange] of [T] to a [CharRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> OpenEndRange<T>.mapToCharOpenEndRangeRange(block: (T) -> Char): CharRange =
	block(start)..<block(endExclusive)
