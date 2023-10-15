package com.ogm.kotlin.range.extensions

/**
 * Map this [ClosedRange] of [T] to a [ClosedRange] of [R].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>, R : Comparable<R>> ClosedRange<T>.mapRange(block: (T) -> R): ClosedRange<R> =
	block(start)..block(endInclusive)

/**
 * Map this [ClosedRange] of [T] to a [OpenEndRange] of [R].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>, R : Comparable<R>> OpenEndRange<T>.mapRange(block: (T) -> R): OpenEndRange<R> =
	block(start)..<block(endExclusive)
