/** Generated file */

package com.ogm.kotlin.range.extensions

/**
 * Map this [ClosedRange] of [T] to a [ClosedFloatingPointRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToDoubleRange(block: (T) -> Double): ClosedFloatingPointRange<Double> = block(start)..block(endInclusive)

/**
 * Map this [OpenEndRange] of [T] to a [OpenEndRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> OpenEndRange<T>.mapToDoubleOpenEndRange(block: (T) -> Double): OpenEndRange<Double> = block(start)..<block(endExclusive)

/**
 * Map this [ClosedRange] of [T] to a [ClosedFloatingPointRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToFloatRange(block: (T) -> Float): ClosedFloatingPointRange<Float> = block(start)..block(endInclusive)

/**
 * Map this [OpenEndRange] of [T] to a [OpenEndRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> OpenEndRange<T>.mapToFloatOpenEndRange(block: (T) -> Float): OpenEndRange<Float> = block(start)..<block(endExclusive)
