/** Generated file */

package com.ogm.kotlin.range.extensions


/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedLong")
fun ClosedRange<Long>.reversed() = (endInclusive..start).toLongRange()

/**
 * Reverse this [OpenEndRange]
 */
@JvmName("reversedLongOpenEndRange")
fun OpenEndRange<Long>.reversedOpenEndRange() = (calculateEndInclusive()..start).toLongRange()

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedULong")
fun ClosedRange<ULong>.reversed() = (endInclusive..start).toULongRange()

/**
 * Reverse this [OpenEndRange]
 */
@JvmName("reversedULongOpenEndRange")
fun OpenEndRange<ULong>.reversedOpenEndRange() = (calculateEndInclusive()..start).toULongRange()

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedInt")
fun ClosedRange<Int>.reversed() = (endInclusive..start).toIntRange()

/**
 * Reverse this [OpenEndRange]
 */
@JvmName("reversedIntOpenEndRange")
fun OpenEndRange<Int>.reversedOpenEndRange() = (calculateEndInclusive()..start).toIntRange()

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedUInt")
fun ClosedRange<UInt>.reversed() = (endInclusive..start).toUIntRange()

/**
 * Reverse this [OpenEndRange]
 */
@JvmName("reversedUIntOpenEndRange")
fun OpenEndRange<UInt>.reversedOpenEndRange() = (calculateEndInclusive()..start).toUIntRange()

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedShort")
fun ClosedRange<Short>.reversed() = (endInclusive..start).toShortRange()

/**
 * Reverse this [OpenEndRange]
 */
@JvmName("reversedShortOpenEndRange")
fun OpenEndRange<Short>.reversedOpenEndRange() = (calculateEndInclusive()..start).toShortRange()

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedUShort")
fun ClosedRange<UShort>.reversed() = (endInclusive..start).toUShortRange()

/**
 * Reverse this [OpenEndRange]
 */
@JvmName("reversedUShortOpenEndRange")
fun OpenEndRange<UShort>.reversedOpenEndRange() = (calculateEndInclusive()..start).toUShortRange()

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedByte")
fun ClosedRange<Byte>.reversed() = (endInclusive..start).toByteRange()

/**
 * Reverse this [OpenEndRange]
 */
@JvmName("reversedByteOpenEndRange")
fun OpenEndRange<Byte>.reversedOpenEndRange() = (calculateEndInclusive()..start).toByteRange()

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedUByte")
fun ClosedRange<UByte>.reversed() = (endInclusive..start).toUByteRange()

/**
 * Reverse this [OpenEndRange]
 */
@JvmName("reversedUByteOpenEndRange")
fun OpenEndRange<UByte>.reversedOpenEndRange() = (calculateEndInclusive()..start).toUByteRange()

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedDouble")
fun ClosedRange<Double>.reversed() = (endInclusive..start).toDoubleRange()

/**
 * Reverse this [OpenEndRange]
 */
@JvmName("reversedDoubleOpenEndRange")
fun OpenEndRange<Double>.reversedOpenEndRange() = (calculateEndInclusive()..start).toDoubleRange()

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedFloat")
fun ClosedRange<Float>.reversed() = (endInclusive..start).toFloatRange()

/**
 * Reverse this [OpenEndRange]
 */
@JvmName("reversedFloatOpenEndRange")
fun OpenEndRange<Float>.reversedOpenEndRange() = (calculateEndInclusive()..start).toFloatRange()

/**
 * Reverse this [ClosedRange]
 */
@JvmName("reversedChar")
fun ClosedRange<Char>.reversed() = (endInclusive..start).toCharRange()

/**
 * Reverse this [OpenEndRange]
 */
@JvmName("reversedCharOpenEndRange")
fun OpenEndRange<Char>.reversedOpenEndRange() = (calculateEndInclusive()..start).toCharRange()
