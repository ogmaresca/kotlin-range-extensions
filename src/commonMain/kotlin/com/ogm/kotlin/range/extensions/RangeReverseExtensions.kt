package com.ogm.kotlin.range.extensions

/**
 * Reverse this [ClosedRange]
 */
fun <T : Comparable<T>> ClosedRange<T>.reversed(): ClosedRange<T> = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedLong")
fun ClosedRange<Long>.reversed(): LongRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedULong")
fun ClosedRange<ULong>.reversed(): ULongRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedInt")
fun ClosedRange<Int>.reversed(): IntRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedUInt")
fun ClosedRange<UInt>.reversed(): UIntRange = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedShort")
fun ClosedRange<Short>.reversed(): ShortRange = (endInclusive..start).toShortRange()

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedUShort")
fun ClosedRange<UShort>.reversed(): UShortRange = (endInclusive..start).toUShortRange()

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedByte")
fun ClosedRange<Byte>.reversed(): ByteRange = (endInclusive..start).toByteRange()

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedUByte")
fun ClosedRange<UByte>.reversed(): UByteRange = (endInclusive..start).toUByteRange()

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedDouble")
fun ClosedRange<Double>.reversed(): ClosedFloatingPointRange<Double> = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedFloat")
fun ClosedRange<Float>.reversed(): ClosedFloatingPointRange<Float> = endInclusive..start

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedChar")
fun ClosedRange<Char>.reversed(): CharRange = endInclusive..start

// TODO support for every custom range
