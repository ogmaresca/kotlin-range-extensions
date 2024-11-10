/** Generated file */

package com.ogm.kotlin.range.extensions

@JvmName("calculateOpenEndLongRangeEndInclusive")
fun OpenEndRange<Long>.calculateEndInclusive(): Long = if (isEmpty()) {
	start
} else if (endExclusive < start) {
	(endExclusive + minValue(endExclusive))
} else {
	(endExclusive - minValue(endExclusive))
}

@JvmName("calculateClosedLongRangeEndInclusive")
fun ClosedRange<Long>.calculateEndExclusive(): Long = if (endInclusive >= start) {
	(endInclusive + minValue(endInclusive))
} else {
	(endInclusive - minValue(endInclusive))
}

@JvmName("calculateOpenEndULongRangeEndInclusive")
fun OpenEndRange<ULong>.calculateEndInclusive(): ULong = if (isEmpty()) {
	start
} else if (endExclusive < start) {
	(endExclusive + minValue(endExclusive))
} else {
	(endExclusive - minValue(endExclusive))
}

@JvmName("calculateClosedULongRangeEndInclusive")
fun ClosedRange<ULong>.calculateEndExclusive(): ULong = if (endInclusive >= start) {
	(endInclusive + minValue(endInclusive))
} else {
	(endInclusive - minValue(endInclusive))
}

@JvmName("calculateOpenEndIntRangeEndInclusive")
fun OpenEndRange<Int>.calculateEndInclusive(): Int = if (isEmpty()) {
	start
} else if (endExclusive < start) {
	(endExclusive + minValue(endExclusive))
} else {
	(endExclusive - minValue(endExclusive))
}

@JvmName("calculateClosedIntRangeEndInclusive")
fun ClosedRange<Int>.calculateEndExclusive(): Int = if (endInclusive >= start) {
	(endInclusive + minValue(endInclusive))
} else {
	(endInclusive - minValue(endInclusive))
}

@JvmName("calculateOpenEndUIntRangeEndInclusive")
fun OpenEndRange<UInt>.calculateEndInclusive(): UInt = if (isEmpty()) {
	start
} else if (endExclusive < start) {
	(endExclusive + minValue(endExclusive))
} else {
	(endExclusive - minValue(endExclusive))
}

@JvmName("calculateClosedUIntRangeEndInclusive")
fun ClosedRange<UInt>.calculateEndExclusive(): UInt = if (endInclusive >= start) {
	(endInclusive + minValue(endInclusive))
} else {
	(endInclusive - minValue(endInclusive))
}

@JvmName("calculateOpenEndShortRangeEndInclusive")
fun OpenEndRange<Short>.calculateEndInclusive(): Short = if (isEmpty()) {
	start
} else if (endExclusive < start) {
	(endExclusive + minValue(endExclusive)).toShort()
} else {
	(endExclusive - minValue(endExclusive)).toShort()
}

@JvmName("calculateClosedShortRangeEndInclusive")
fun ClosedRange<Short>.calculateEndExclusive(): Short = if (endInclusive >= start) {
	(endInclusive + minValue(endInclusive)).toShort()
} else {
	(endInclusive - minValue(endInclusive)).toShort()
}

@JvmName("calculateOpenEndUShortRangeEndInclusive")
fun OpenEndRange<UShort>.calculateEndInclusive(): UShort = if (isEmpty()) {
	start
} else if (endExclusive < start) {
	(endExclusive + minValue(endExclusive)).toUShort()
} else {
	(endExclusive - minValue(endExclusive)).toUShort()
}

@JvmName("calculateClosedUShortRangeEndInclusive")
fun ClosedRange<UShort>.calculateEndExclusive(): UShort = if (endInclusive >= start) {
	(endInclusive + minValue(endInclusive)).toUShort()
} else {
	(endInclusive - minValue(endInclusive)).toUShort()
}

@JvmName("calculateOpenEndByteRangeEndInclusive")
fun OpenEndRange<Byte>.calculateEndInclusive(): Byte = if (isEmpty()) {
	start
} else if (endExclusive < start) {
	(endExclusive + minValue(endExclusive)).toByte()
} else {
	(endExclusive - minValue(endExclusive)).toByte()
}

@JvmName("calculateClosedByteRangeEndInclusive")
fun ClosedRange<Byte>.calculateEndExclusive(): Byte = if (endInclusive >= start) {
	(endInclusive + minValue(endInclusive)).toByte()
} else {
	(endInclusive - minValue(endInclusive)).toByte()
}

@JvmName("calculateOpenEndUByteRangeEndInclusive")
fun OpenEndRange<UByte>.calculateEndInclusive(): UByte = if (isEmpty()) {
	start
} else if (endExclusive < start) {
	(endExclusive + minValue(endExclusive)).toUByte()
} else {
	(endExclusive - minValue(endExclusive)).toUByte()
}

@JvmName("calculateClosedUByteRangeEndInclusive")
fun ClosedRange<UByte>.calculateEndExclusive(): UByte = if (endInclusive >= start) {
	(endInclusive + minValue(endInclusive)).toUByte()
} else {
	(endInclusive - minValue(endInclusive)).toUByte()
}

@JvmName("calculateOpenEndDoubleRangeEndInclusive")
fun OpenEndRange<Double>.calculateEndInclusive(): Double = if (isEmpty()) {
	start
} else if (endExclusive < start) {
	(endExclusive + minValue(endExclusive))
} else {
	(endExclusive - minValue(endExclusive))
}

@JvmName("calculateClosedDoubleRangeEndInclusive")
fun ClosedRange<Double>.calculateEndExclusive(): Double = if (endInclusive >= start) {
	(endInclusive + minValue(endInclusive))
} else {
	(endInclusive - minValue(endInclusive))
}

@JvmName("calculateOpenEndFloatRangeEndInclusive")
fun OpenEndRange<Float>.calculateEndInclusive(): Float = if (isEmpty()) {
	start
} else if (endExclusive < start) {
	(endExclusive + minValue(endExclusive))
} else {
	(endExclusive - minValue(endExclusive))
}

@JvmName("calculateClosedFloatRangeEndInclusive")
fun ClosedRange<Float>.calculateEndExclusive(): Float = if (endInclusive >= start) {
	(endInclusive + minValue(endInclusive))
} else {
	(endInclusive - minValue(endInclusive))
}

@JvmName("calculateOpenEndCharRangeEndInclusive")
fun OpenEndRange<Char>.calculateEndInclusive(): Char = if (isEmpty()) {
	start
} else if (endExclusive < start) {
	(endExclusive + minValue(endExclusive))
} else {
	(endExclusive - minValue(endExclusive))
}

@JvmName("calculateClosedCharRangeEndInclusive")
fun ClosedRange<Char>.calculateEndExclusive(): Char = if (endInclusive >= start) {
	(endInclusive + minValue(endInclusive))
} else {
	(endInclusive - minValue(endInclusive))
}
