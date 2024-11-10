/** Generated file */

package com.ogm.kotlin.range.extensions

/**
 * Map this [ClosedRange] of [T] to a [ShortRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToShortRange(block: (T) -> Short): ShortRange = (block(start)..block(endInclusive)).toShortRange()

/**
 * Map this [OpenEndRange] of [T] to a [ShortRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> OpenEndRange<T>.mapToShortOpenEndRangeRange(block: (T) -> Short): ShortRange = (block(start)..<block(endExclusive)).toShortRange()

/**
 * Map this [ClosedRange] of [T] to a [UShortRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToUShortRange(block: (T) -> UShort): UShortRange = (block(start)..block(endInclusive)).toUShortRange()

/**
 * Map this [OpenEndRange] of [T] to a [UShortRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> OpenEndRange<T>.mapToUShortOpenEndRangeRange(block: (T) -> UShort): UShortRange = (block(start)..<block(endExclusive)).toUShortRange()

/**
 * Map this [ClosedRange] of [T] to a [ByteRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToByteRange(block: (T) -> Byte): ByteRange = (block(start)..block(endInclusive)).toByteRange()

/**
 * Map this [OpenEndRange] of [T] to a [ByteRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> OpenEndRange<T>.mapToByteOpenEndRangeRange(block: (T) -> Byte): ByteRange = (block(start)..<block(endExclusive)).toByteRange()

/**
 * Map this [ClosedRange] of [T] to a [UByteRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToUByteRange(block: (T) -> UByte): UByteRange = (block(start)..block(endInclusive)).toUByteRange()

/**
 * Map this [OpenEndRange] of [T] to a [UByteRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> OpenEndRange<T>.mapToUByteOpenEndRangeRange(block: (T) -> UByte): UByteRange = (block(start)..<block(endExclusive)).toUByteRange()
