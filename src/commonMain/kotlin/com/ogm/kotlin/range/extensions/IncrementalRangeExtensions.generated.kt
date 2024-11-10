/** Generated file */

package com.ogm.kotlin.range.extensions

/**
 * Convert this [ClosedRange] to a range where [ClosedRange.start] is less than or equal to [ClosedRange.endInclusive]
 */
@JvmName("toIncrementalLongRange")
fun ClosedRange<Long>.toIncrementalRange() = if (isIncremental()) {
	asLongRange()
} else {
	reversed()
}

/**
 * Convert this [OpenEndRange] to a range where [OpenEndRange.start] is less than [OpenEndRange.endExclusive]
 */
@JvmName("toIncrementalLongOpenEndRangeRange")
fun OpenEndRange<Long>.toIncrementalOpenEndRangeRange() = if (isIncrementalOpenEndRange()) {
	asOpenLongRange()
} else {
	reversedOpenEndRange()
}

/**
 * Convert this [ClosedRange] to a range where [ClosedRange.start] is less than or equal to [ClosedRange.endInclusive]
 */
@JvmName("toIncrementalULongRange")
fun ClosedRange<ULong>.toIncrementalRange() = if (isIncremental()) {
	asULongRange()
} else {
	reversed()
}

/**
 * Convert this [OpenEndRange] to a range where [OpenEndRange.start] is less than [OpenEndRange.endExclusive]
 */
@JvmName("toIncrementalULongOpenEndRangeRange")
fun OpenEndRange<ULong>.toIncrementalOpenEndRangeRange() = if (isIncrementalOpenEndRange()) {
	asOpenULongRange()
} else {
	reversedOpenEndRange()
}

/**
 * Convert this [ClosedRange] to a range where [ClosedRange.start] is less than or equal to [ClosedRange.endInclusive]
 */
@JvmName("toIncrementalIntRange")
fun ClosedRange<Int>.toIncrementalRange() = if (isIncremental()) {
	asIntRange()
} else {
	reversed()
}

/**
 * Convert this [OpenEndRange] to a range where [OpenEndRange.start] is less than [OpenEndRange.endExclusive]
 */
@JvmName("toIncrementalIntOpenEndRangeRange")
fun OpenEndRange<Int>.toIncrementalOpenEndRangeRange() = if (isIncrementalOpenEndRange()) {
	asOpenIntRange()
} else {
	reversedOpenEndRange()
}

/**
 * Convert this [ClosedRange] to a range where [ClosedRange.start] is less than or equal to [ClosedRange.endInclusive]
 */
@JvmName("toIncrementalUIntRange")
fun ClosedRange<UInt>.toIncrementalRange() = if (isIncremental()) {
	asUIntRange()
} else {
	reversed()
}

/**
 * Convert this [OpenEndRange] to a range where [OpenEndRange.start] is less than [OpenEndRange.endExclusive]
 */
@JvmName("toIncrementalUIntOpenEndRangeRange")
fun OpenEndRange<UInt>.toIncrementalOpenEndRangeRange() = if (isIncrementalOpenEndRange()) {
	asOpenUIntRange()
} else {
	reversedOpenEndRange()
}

/**
 * Convert this [ClosedRange] to a range where [ClosedRange.start] is less than or equal to [ClosedRange.endInclusive]
 */
@JvmName("toIncrementalShortRange")
fun ClosedRange<Short>.toIncrementalRange() = if (isIncremental()) {
	asShortRange()
} else {
	reversed()
}

/**
 * Convert this [OpenEndRange] to a range where [OpenEndRange.start] is less than [OpenEndRange.endExclusive]
 */
@JvmName("toIncrementalShortOpenEndRangeRange")
fun OpenEndRange<Short>.toIncrementalOpenEndRangeRange() = if (isIncrementalOpenEndRange()) {
	asOpenShortRange()
} else {
	reversedOpenEndRange()
}

/**
 * Convert this [ClosedRange] to a range where [ClosedRange.start] is less than or equal to [ClosedRange.endInclusive]
 */
@JvmName("toIncrementalUShortRange")
fun ClosedRange<UShort>.toIncrementalRange() = if (isIncremental()) {
	asUShortRange()
} else {
	reversed()
}

/**
 * Convert this [OpenEndRange] to a range where [OpenEndRange.start] is less than [OpenEndRange.endExclusive]
 */
@JvmName("toIncrementalUShortOpenEndRangeRange")
fun OpenEndRange<UShort>.toIncrementalOpenEndRangeRange() = if (isIncrementalOpenEndRange()) {
	asOpenUShortRange()
} else {
	reversedOpenEndRange()
}

/**
 * Convert this [ClosedRange] to a range where [ClosedRange.start] is less than or equal to [ClosedRange.endInclusive]
 */
@JvmName("toIncrementalByteRange")
fun ClosedRange<Byte>.toIncrementalRange() = if (isIncremental()) {
	asByteRange()
} else {
	reversed()
}

/**
 * Convert this [OpenEndRange] to a range where [OpenEndRange.start] is less than [OpenEndRange.endExclusive]
 */
@JvmName("toIncrementalByteOpenEndRangeRange")
fun OpenEndRange<Byte>.toIncrementalOpenEndRangeRange() = if (isIncrementalOpenEndRange()) {
	asOpenByteRange()
} else {
	reversedOpenEndRange()
}

/**
 * Convert this [ClosedRange] to a range where [ClosedRange.start] is less than or equal to [ClosedRange.endInclusive]
 */
@JvmName("toIncrementalUByteRange")
fun ClosedRange<UByte>.toIncrementalRange() = if (isIncremental()) {
	asUByteRange()
} else {
	reversed()
}

/**
 * Convert this [OpenEndRange] to a range where [OpenEndRange.start] is less than [OpenEndRange.endExclusive]
 */
@JvmName("toIncrementalUByteOpenEndRangeRange")
fun OpenEndRange<UByte>.toIncrementalOpenEndRangeRange() = if (isIncrementalOpenEndRange()) {
	asOpenUByteRange()
} else {
	reversedOpenEndRange()
}

/**
 * Convert this [ClosedRange] to a range where [ClosedRange.start] is less than or equal to [ClosedRange.endInclusive]
 */
@JvmName("toIncrementalDoubleRange")
fun ClosedRange<Double>.toIncrementalRange() = if (isIncremental()) {
	asDoubleRange()
} else {
	reversed()
}

/**
 * Convert this [OpenEndRange] to a range where [OpenEndRange.start] is less than [OpenEndRange.endExclusive]
 */
@JvmName("toIncrementalDoubleOpenEndRangeRange")
fun OpenEndRange<Double>.toIncrementalOpenEndRangeRange() = if (isIncrementalOpenEndRange()) {
	asOpenDoubleRange()
} else {
	reversedOpenEndRange()
}

/**
 * Convert this [ClosedRange] to a range where [ClosedRange.start] is less than or equal to [ClosedRange.endInclusive]
 */
@JvmName("toIncrementalFloatRange")
fun ClosedRange<Float>.toIncrementalRange() = if (isIncremental()) {
	asFloatRange()
} else {
	reversed()
}

/**
 * Convert this [OpenEndRange] to a range where [OpenEndRange.start] is less than [OpenEndRange.endExclusive]
 */
@JvmName("toIncrementalFloatOpenEndRangeRange")
fun OpenEndRange<Float>.toIncrementalOpenEndRangeRange() = if (isIncrementalOpenEndRange()) {
	asOpenFloatRange()
} else {
	reversedOpenEndRange()
}

/**
 * Convert this [ClosedRange] to a range where [ClosedRange.start] is less than or equal to [ClosedRange.endInclusive]
 */
@JvmName("toIncrementalCharRange")
fun ClosedRange<Char>.toIncrementalRange() = if (isIncremental()) {
	asCharRange()
} else {
	reversed()
}

/**
 * Convert this [OpenEndRange] to a range where [OpenEndRange.start] is less than [OpenEndRange.endExclusive]
 */
@JvmName("toIncrementalCharOpenEndRangeRange")
fun OpenEndRange<Char>.toIncrementalOpenEndRangeRange() = if (isIncrementalOpenEndRange()) {
	asOpenCharRange()
} else {
	reversedOpenEndRange()
}
